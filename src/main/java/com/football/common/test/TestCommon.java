package com.football.common.test;/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.football.common.constant.Constant;
import com.football.common.email.EmailCommon;
import com.football.common.email.GmailCommon;
import com.football.common.file.FileCommon;
import com.football.common.response.Response;
import com.football.common.util.*;
import org.apache.commons.collections.keyvalue.MultiKey;

import java.io.IOException;
import java.util.*;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
public class TestCommon {

    public static void main(String[] args) throws Exception {
//        System.out.println(JsonCommon.convertObjects2JsonLog(FileCommon_writeTextFile().toString()));
//        System.out.println(LogCommon_toString());
//        System.out.println(DateCommon_compareTo());
//        System.out.println(JsonCommon_stringToObjectToString());
//        System.out.println(JsonCommon_objectToString());
//        System.out.println(LogCommon.toString(BeanCommon_getNullPropertyNames()));
//        System.out.println(StringCommon.isValidPattern("nqtruong@egmail.com", null));
//        System.out.println(EmailCommon_send());
//        System.out.println(JsonCommon.objectToJsonLog(FileCommon_readExcel()));
//        System.out.println(FileCommon_writeExcel());
//        System.out.println(description2responseCode("Search object does not exist"));
//        System.out.println(responseCode2description("FILE_DOES_NOT_EXIST"));
//        System.out.println(description2responseCode("Required parameters may not be left blank"));

        System.out.println(Response.OBJECT_NOT_FOUND.toString());

    }

    public static Response FileCommon_writeTextFile() throws ClassNotFoundException {
        List<String> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add("infor + " + i);
            System.out.println(i);
        }
        return FileCommon.writeTextFile("C://Log//test.txt", data);
    }

    public static String LogCommon_toString() throws ClassNotFoundException {
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            data.add(i);
        }
        Object[] arrInt = ArrayListCommon.convertList2Array(data);
        String re = LogCommon.toString(arrInt);
        return re;
    }

    public static int DateCommon_compareTo() throws ClassNotFoundException {
        Date date = new Date();
        return date.compareTo(DateCommon.getEndDay(date));
    }

    public static String[] BeanCommon_getNullPropertyNames() {
        String s = "{\"id\":12394577,\"txnDate\":\"2018-04-10\",\"edong\":\"PAHPG4002281\",\"cashierPay\":\"PAHPG4002281\",\"ecpBillId\":261477183,\"providerCode\":\"NCC0500\",\"billingType\":\"OFF\",\"offType\":2,\"intOffType\":0,\"auditNumberCore\":194537387,\"status\":0,\"requestDate\":\"2018-04-10\",\"billingDate\":null,\"responseDate\":null,\"responseCode\":null,\"description\":null,\"work\":\"2018-04-11\",\"pcId\":247,\"numberBillingTime\":0,\"pcCode\":null,\"customerCode\":null,\"strAmount\":null,\"strBillId\":null,\"strOffType\":null,\"strAuditNumber\":null,\"strRequestDate\":\"2018-04-10 19:45:35.0\",\"strResponseDate\":null,\"strWorkDate\":\"2018-04-11 15:57:47.0\",\"strTerm\":null,\"customer\":{\"regionId\":0,\"code\":\"PH11000705388\",\"pcCode\":null,\"pcCodeExt\":null,\"cardNo\":null,\"name\":null,\"nameNosign\":null,\"address\":null,\"addressNosign\":null,\"phoneByevn\":null,\"phoneByecp\":\"0983651931\",\"bookCmis\":null,\"electricityMeter\":null,\"inning\":null,\"road\":null,\"station\":null,\"taxCode\":null,\"trade\":null,\"countPeriod\":null,\"team\":null,\"status\":null,\"type\":null,\"strType\":null,\"createdDate\":null,\"lastQuery\":null,\"idChanged\":null,\"dateChanged\":null,\"bankAccount\":null,\"idNumber\":null,\"bankName\":null,\"cashier\":null,\"providerCode\":null,\"checkBillEvn\":0,\"autoBilling\":0,\"smsFlag\":0,\"assignFromEvn\":0,\"balance\":0,\"lockMoney\":0,\"offMoney\":0,\"response\":null,\"responseCode\":null,\"description\":null,\"listBill\":null,\"countBill\":0},\"bill\":{\"customerCode\":\"PH11000705388\",\"customerPayCode\":null,\"billId\":70352125,\"term\":null,\"strTerm\":\"04/2018\",\"amount\":56229,\"period\":\"1\",\"issueDate\":null,\"strIssueDate\":null,\"status\":2,\"seri\":null,\"pcCode\":null,\"handoverCode\":null,\"cashierCode\":null,\"bookCmis\":null,\"fromDate\":null,\"toDate\":null,\"strFromDate\":null,\"strToDate\":null,\"home\":null,\"tax\":null,\"billNum\":null,\"currency\":null,\"priceDetails\":null,\"numeDetails\":null,\"amountDetails\":null,\"oldIndex\":null,\"newIndex\":null,\"nume\":null,\"amountNotTax\":null,\"amountTax\":null,\"multiple\":null,\"billType\":null,\"typeIndex\":null,\"groupTypeIndex\":null,\"createdDate\":null,\"idChanged\":null,\"dateChanged\":null,\"edong\":\"PAHPG4002281\",\"pcCodeExt\":null,\"code\":null,\"name\":null,\"nameNosign\":null,\"address\":null,\"addressNosign\":null,\"phoneByevn\":null,\"phoneByecp\":null,\"electricityMeter\":null,\"inning\":null,\"road\":null,\"station\":null,\"taxCode\":null,\"trade\":null,\"countPeriod\":null,\"team\":null,\"type\":null,\"lastQuery\":null,\"groupType\":null,\"billingChannel\":null,\"billingType\":\"OFF\",\"billingBy\":null,\"cashierPay\":\"PAHPG4002281\",\"responseCode\":null,\"description\":null,\"strBillId\":null,\"strAmount\":null,\"strStatus\":null,\"strAmountNotTax\":null,\"strAmountTax\":null,\"strMultiple\":null,\"strType\":null,\"strTax\":null},\"billSerial\":null,\"auditNumber\":194537387}";
        Object o = null;
        try {
            o = JsonCommon.stringToObject(s);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException when JsonCommon.stringToObject" + e.toString());
        }
        return BeanCommon.getNullPropertyNames(o);
    }

    public static String JsonCommon_stringToObjectToString() {
        String s = "{\"id\":12394577,\"txnDate\":\"2018-04-10\",\"edong\":\"PAHPG4002281\",\"cashierPay\":\"PAHPG4002281\",\"ecpBillId\":261477183,\"providerCode\":\"NCC0500\",\"billingType\":\"OFF\",\"offType\":2,\"intOffType\":0,\"auditNumberCore\":194537387,\"status\":0,\"requestDate\":\"2018-04-10\",\"billingDate\":null,\"responseDate\":null,\"responseCode\":null,\"description\":null,\"work\":\"2018-04-11\",\"pcId\":247,\"numberBillingTime\":0,\"pcCode\":null,\"customerCode\":null,\"strAmount\":null,\"strBillId\":null,\"strOffType\":null,\"strAuditNumber\":null,\"strRequestDate\":\"2018-04-10 19:45:35.0\",\"strResponseDate\":null,\"strWorkDate\":\"2018-04-11 15:57:47.0\",\"strTerm\":null,\"customer\":{\"regionId\":0,\"code\":\"PH11000705388\",\"pcCode\":null,\"pcCodeExt\":null,\"cardNo\":null,\"name\":null,\"nameNosign\":null,\"address\":null,\"addressNosign\":null,\"phoneByevn\":null,\"phoneByecp\":\"0983651931\",\"bookCmis\":null,\"electricityMeter\":null,\"inning\":null,\"road\":null,\"station\":null,\"taxCode\":null,\"trade\":null,\"countPeriod\":null,\"team\":null,\"status\":null,\"type\":null,\"strType\":null,\"createdDate\":null,\"lastQuery\":null,\"idChanged\":null,\"dateChanged\":null,\"bankAccount\":null,\"idNumber\":null,\"bankName\":null,\"cashier\":null,\"providerCode\":null,\"checkBillEvn\":0,\"autoBilling\":0,\"smsFlag\":0,\"assignFromEvn\":0,\"balance\":0,\"lockMoney\":0,\"offMoney\":0,\"response\":null,\"responseCode\":null,\"description\":null,\"listBill\":null,\"countBill\":0},\"bill\":{\"customerCode\":\"PH11000705388\",\"customerPayCode\":null,\"billId\":70352125,\"term\":null,\"strTerm\":\"04/2018\",\"amount\":56229,\"period\":\"1\",\"issueDate\":null,\"strIssueDate\":null,\"status\":2,\"seri\":null,\"pcCode\":null,\"handoverCode\":null,\"cashierCode\":null,\"bookCmis\":null,\"fromDate\":null,\"toDate\":null,\"strFromDate\":null,\"strToDate\":null,\"home\":null,\"tax\":null,\"billNum\":null,\"currency\":null,\"priceDetails\":null,\"numeDetails\":null,\"amountDetails\":null,\"oldIndex\":null,\"newIndex\":null,\"nume\":null,\"amountNotTax\":null,\"amountTax\":null,\"multiple\":null,\"billType\":null,\"typeIndex\":null,\"groupTypeIndex\":null,\"createdDate\":null,\"idChanged\":null,\"dateChanged\":null,\"edong\":\"PAHPG4002281\",\"pcCodeExt\":null,\"code\":null,\"name\":null,\"nameNosign\":null,\"address\":null,\"addressNosign\":null,\"phoneByevn\":null,\"phoneByecp\":null,\"electricityMeter\":null,\"inning\":null,\"road\":null,\"station\":null,\"taxCode\":null,\"trade\":null,\"countPeriod\":null,\"team\":null,\"type\":null,\"lastQuery\":null,\"groupType\":null,\"billingChannel\":null,\"billingType\":\"OFF\",\"billingBy\":null,\"cashierPay\":\"PAHPG4002281\",\"responseCode\":null,\"description\":null,\"strBillId\":null,\"strAmount\":null,\"strStatus\":null,\"strAmountNotTax\":null,\"strAmountTax\":null,\"strMultiple\":null,\"strType\":null,\"strTax\":null},\"billSerial\":null,\"auditNumber\":194537387}";
        System.out.println(JsonCommon.string2Json(s));
        Object o = null;
        try {
            o = JsonCommon.stringToObject(s);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException when JsonCommon.stringToObject" + e.toString());
        }
        return JsonCommon.objectToJsonLog(o);
    }

    public static String JsonCommon_objectToString() {
        Object o = null;
        return JsonCommon.objectToJsonNotNull(o);
    }

    public static String EmailCommon_send() {
        EmailCommon emailCommon = new EmailCommon();
        emailCommon.setHost("mail.ecpay.vn");
        emailCommon.setAccount("nqtruong");
        emailCommon.setFromMail("nqtruong@ecpay.vn");
        emailCommon.setPass("");
        emailCommon.setPort(25);
        return emailCommon.send("Test", "xxx", ""
                , "nqtruong@ecpay.vn", "truongnguyen89@gmail.com", "").toString();

    }

    public static void GmailCommon_send() {
        GmailCommon gmailCommon = new GmailCommon();
        try {

//            MimeMessage emailContent = gmailCommon.createEmail("truongnguyen89@gmail.com", "ecpay.it"
//                    , "abc", "mmmmvvv", new File("C:\\aoesync.txt"));
//            gmailCommon.sendMessage(new Gmail(null), "ecpay.it", emailContent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String description2responseCode(String s) {
        return s.toUpperCase().replaceAll(" ", "_");
    }

    public static String responseCode2description(String s) {
        String input = s.toLowerCase().replaceAll("_", " ");
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    public static String testMapParam() {
        Map<MultiKey, String> paramTmp = new HashMap<>();
        paramTmp.put(new MultiKey("1", "1"), "XXXXXXXXXXXX");
        return paramTmp.get(new MultiKey("1", "1"));
    }


}
