package com.football.common.email;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.*;
import java.io.*;
import java.util.*;

import com.football.common.cache.Cache;
import com.football.common.constant.Constant;
import com.football.common.response.Response;
import com.football.common.util.StringCommon;
import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.Message;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GmailCommon {

    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.EMAIL);

    /**
     * Create a MimeMessage using the parameters provided.
     *
     * @param to       Email address of the receiver.
     * @param from     Email address of the sender, the mailbox account.
     * @param subject  Subject of the email.
     * @param bodyText Body text of the email.
     * @param file     Path to the file to be attached.
     * @return MimeMessage to be used to send email.
     * @throws MessagingException
     */
    public static MimeMessage createEmail(String to,
                                          String from,
                                          String subject,
                                          String bodyText,
                                          File file)
            throws MessagingException, IOException {
        Properties props = new Properties();
        Session session = Session.getDefaultInstance(props, null);

        MimeMessage email = new MimeMessage(session);

        email.setFrom(new InternetAddress(from));
        email.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(to));
        email.setSubject(subject);

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(bodyText, "text/plain");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);
        if (file.exists()) {
            mimeBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(file);

            mimeBodyPart.setDataHandler(new DataHandler(source));
            mimeBodyPart.setFileName(file.getName());
        }
        multipart.addBodyPart(mimeBodyPart);
        email.setContent(multipart);

        return email;
    }

    /**
     * Create a message from an email.
     *
     * @param emailContent Email to be set to raw of message
     * @return a message containing a base64url encoded email
     * @throws IOException
     * @throws MessagingException
     */
    public static Message createMessageWithEmail(MimeMessage emailContent)
            throws MessagingException, IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        emailContent.writeTo(buffer);
        byte[] bytes = buffer.toByteArray();
        String encodedEmail = Base64.encodeBase64URLSafeString(bytes);
        Message message = new Message();
        message.setRaw(encodedEmail);
        return message;
    }

    /**
     * Send an email from the user's mailbox to its recipient.
     *
     * @param service      Authorized Gmail API instance.
     * @param userId       User's email address. The special value "me"
     *                     can be used to indicate the authenticated user.
     * @param emailContent Email to be sent.
     * @return The sent message
     * @throws MessagingException
     * @throws IOException
     */
    public static Message sendMessage(Gmail service,
                                      String userId,
                                      MimeMessage emailContent)
            throws MessagingException, IOException {
        Message message = createMessageWithEmail(emailContent);
        message = service.users().messages().send(userId, message).execute();

        System.out.println("Message id: " + message.getId());
        System.out.println(message.toPrettyString());
        return message;
    }

    public static Response send(String recipient, String subject, String contents) {
        long id = System.currentTimeMillis();
        LOGGER.info("[B][" + id + "] Gmail.send >>> " + subject);
        String account = Cache.getValueParamFromCache(Constant.PARAMS.TYPE.GMAIL, Constant.PARAMS.CODE.ACCOUNT);
        account = StringCommon.isNullOrBlank(account) ? "ecpay.it" : account;
        String pass = Cache.getValueParamFromCache(Constant.PARAMS.TYPE.GMAIL, Constant.PARAMS.CODE.PASS);
        pass = StringCommon.isNullOrBlank(pass) ? "Ecpayit2017" : pass;
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", account);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);
        if (
                StringCommon.isNullOrBlank(recipient)
                        || StringCommon.isNullOrBlank(subject)
                        || StringCommon.isNullOrBlank(contents)
        )
            return Response.REQUIRED_PARAMETERS_MAY_NOT_BE_BLANK;

        String[] to = recipient.split(";");
        Response response = Response.OK;
        try {
            message.setFrom(new InternetAddress(account + "@gmail.com"));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(javax.mail.Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(contents);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, account, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            ae.printStackTrace();
            response = Response.FAILED_TO_LOGIN_MAIL_SERVER;
        } catch (MessagingException me) {
            me.printStackTrace();
            response = Response.FAILED_TO_LOGIN_MAIL_SERVER;
        } finally {
            LOGGER.info("[E][" + id + "][Duration = " + (System.currentTimeMillis() - id) + "] Gmail.send >>> " + response.toString());
        }
        return response;
    }
}
