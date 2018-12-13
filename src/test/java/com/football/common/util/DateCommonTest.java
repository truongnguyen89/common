package com.football.common.util;

import com.football.common.constant.Constant;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 13-Dec-18
 * Time: 10:10 AM
 * To change this template use File | Settings | File Templates.
 */
public class DateCommonTest {
    public static void main(String[] args) {
        long id = System.currentTimeMillis();
        System.out.println(id);
        System.out.println(1544691600);
        Date date=new Date(id); // accept long value.
        System.out.println(DateCommon.convertDateToStringByPattern(date, Constant.DATE.FORMAT.FULL_DATE));
        System.out.println(DateCommon.convertDateToStringByPattern(new Date(1544691600L*1000), Constant.DATE.FORMAT.FULL_DATE));
    }
}
