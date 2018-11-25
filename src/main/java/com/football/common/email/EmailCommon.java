package com.football.common.email;

import com.football.common.constant.Constant;
import com.football.common.response.Response;
import com.football.common.util.ArrayListCommon;
import com.football.common.util.StringCommon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
public class EmailCommon {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.EMAIL);
    private List<String> listToMail;
    private List<String> listCcMail;
    private List<String> listBccMail;
    private String fromMail;
    private String toMail;
    private String account;
    private String pass;
    private String host;
    private int port;

    public EmailCommon(String fromMail, String toMail, String account, String pass, String host, int port) {
        this.fromMail = fromMail;
        this.toMail = toMail;
        this.account = account;
        this.pass = pass;
        this.host = host;
        this.port = port;
    }

    public EmailCommon(String fromMail, String account, String pass, String host, int port) {
        this.fromMail = fromMail;
        this.account = account;
        this.pass = pass;
        this.host = host;
        this.port = port;
    }

    public EmailCommon() {
    }

    public Response send(String subject, String decripsion, String listFileName, String toMail, String ccMail, String bccMail) {
        long id = System.currentTimeMillis();
        LOGGER.info("[B][" + id + "] SendEmail.send >>> " + subject);
        Response response = Response.FAILED_TO_SEND_MAIL;
        try {
            if (StringCommon.isNullOrBlank(toMail)) {
                toMail = this.toMail;
            }
            setListToMail(toMail);
            if (!StringCommon.isNullOrBlank(ccMail)) {
                setListCcMail(ccMail);
            }
            if (!StringCommon.isNullOrBlank(bccMail)) {
                setListBccMail(bccMail);
            }
            if (StringCommon.isNullOrBlank(host)
                    || StringCommon.isNullOrBlank(account)
                    || StringCommon.isNullOrBlank(pass)
                    || StringCommon.isNullOrBlank(fromMail)
                    || ArrayListCommon.isNullOrEmpty(listToMail)
                    || StringCommon.isNullOrBlank(subject)
                    || StringCommon.isNullOrBlank(decripsion)) {
                response = Response.BAD_REQUEST;
                return response;
            }
            String[] arrFileName = null;
            if (!StringCommon.isNullOrBlank(listFileName)) {
                arrFileName = listFileName.split(";");
                if (arrFileName != null && arrFileName.length > 0) {
                    for (String fileName : arrFileName) {
                        File file = new File(fileName);
                        if (!file.exists()) {
                            return Response.NOT_FOUND;
                        }
                    }
                }
            }
            InternetAddress[] recipientAddress = convertListMail(listToMail);
            InternetAddress[] recipientCCAddress = null;
            InternetAddress[] recipientBCCAddress = null;
            if (!ArrayListCommon.isNullOrEmpty(listCcMail)) {
                recipientCCAddress = convertListMail(listCcMail);
            }
            if (!ArrayListCommon.isNullOrEmpty(listBccMail)) {
                recipientBCCAddress = convertListMail(listBccMail);
            }

            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", host);
            p.put("mail.smtp.port", port);
            p.put("mail.smtp.ssl.trust", "*");
            Session s;
            try {
                s = Session.getInstance(p,
                        new javax.mail.Authenticator() {
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(account, pass);
                            }
                        });
            } catch (Exception e) {
                LOGGER.error("Exception[" + id + "][Duration = " + (System.currentTimeMillis() - id) + "] login server mail false ", e);
                response = Response.FAILED_TO_LOGIN_MAIL_SERVER;
                return response;
            }
            if (s == null) {
                response = Response.FAILED_TO_LOGIN_MAIL_SERVER;
                return response;
            }
            Message msg = new MimeMessage(s);
            msg.setFrom(new InternetAddress(fromMail));
            msg.setRecipients(Message.RecipientType.TO, recipientAddress);
            if (recipientCCAddress != null) {
                msg.setRecipients(Message.RecipientType.CC, recipientCCAddress);
            }
            if (recipientBCCAddress != null) {
                msg.setRecipients(Message.RecipientType.BCC, recipientBCCAddress);
            }
            msg.setSubject(subject);

            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText(decripsion);

            // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            if (arrFileName != null && arrFileName.length > 0) {
                for (String filePath : arrFileName) {
                    if (!StringCommon.isNullOrBlank(filePath)) {
                        messageBodyPart = new MimeBodyPart();
                        DataSource source = new FileDataSource(filePath);
                        messageBodyPart.setDataHandler(new DataHandler(source));
                        messageBodyPart.setFileName(filePath.substring(filePath.lastIndexOf('/') + 1, filePath.length()));
                        multipart.addBodyPart(messageBodyPart);
                    }
                }
            }
            // Send the complete message parts
            msg.setContent(multipart);
            Transport.send(msg);
            response = Response.OK;
        } catch (MessagingException e) {
            LOGGER.error("Exception[" + id + "][Duration = " + (System.currentTimeMillis() - id) + "] Send email false ", e);
            response = Response.FAILED_TO_SEND_MAIL;
        } finally {
            LOGGER.info("[E][" + id + "][Duration = " + (System.currentTimeMillis() - id) + "] SendEmail.send >>> " + subject + " | " + response.toString());
        }
        return response;
    }

    public List getListToMail() {
        return listToMail;
    }

    public void setListToMail(List listToMail) {
        this.listToMail = listToMail;
    }

    public void setListToMail(String toMail) {
        String[] arrToMail = toMail.split(";");
        if (arrToMail != null && arrToMail.length > 0) {
            this.listToMail = Arrays.asList(arrToMail);
        }
    }

    public List getListCcMail() {
        return listCcMail;
    }

    public void setListCcMail(List listCcMail) {
        this.listCcMail = listCcMail;
    }

    public void setListCcMail(String ccMail) {
        String[] arrCCMail = ccMail.split(";");
        if (arrCCMail != null && arrCCMail.length > 0) {
            this.listCcMail = Arrays.asList(arrCCMail);
        }
    }

    public List getListBccMail() {
        return listBccMail;
    }

    public void setListBccMail(List listBccMail) {
        this.listBccMail = listBccMail;
    }

    public void setListBccMail(String bccMail) {
        String[] arrBCCMail = bccMail.split(";");
        if (arrBCCMail != null && arrBCCMail.length > 0) {
            this.listBccMail = Arrays.asList(arrBCCMail);
        }
    }

    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public InternetAddress[] convertListMail(List<String> listMail) {
        if (listMail == null || listMail.isEmpty()) {
            return null;
        }
        try {
            InternetAddress[] recipientAddress = new InternetAddress[listMail.size()];
            for (int i = 0; i < listMail.size(); i++) {
                recipientAddress[i] = new InternetAddress(listMail.get(i).trim());
            }
            return recipientAddress;
        } catch (Exception e) {
        }
        return null;
    }
}
