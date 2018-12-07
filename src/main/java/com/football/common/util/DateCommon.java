/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.football.common.util;

import com.football.common.constant.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
public class DateCommon {

    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.COMMON);

    public static Date convertStringToDateByPattern(String strTime, String pattern) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            return dateFormat.parse(strTime);
        } catch (Exception e) {
            LOGGER.error("Exception when convertStringToDateByPattern", e);
            return null;
        }
    }

    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date) {
        if (date == null)
            return null;
        else {
            try {
                return new java.sql.Date(date.getTime());
            } catch (Exception e) {
                LOGGER.error("Exception when convertUtilDateToSqlDate", e);
                return null;
            }
        }
    }

    public static Date convertStringToDate(String strTime, String pattern) {
        return convertStringToDateByPattern(strTime, Constant.DATE.FORMAT.SHORT_DATE);
    }

    public static Date convertStringToDateTime(String strTime, String pattern) {
        return convertStringToDateByPattern(strTime, Constant.DATE.FORMAT.FULL_DATE);
    }

    public static String convertDateToStringByPattern(Date date, String pattern) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            return dateFormat.format(date);
        } catch (Exception e) {
            LOGGER.error("Exception when convertDateToStringByPattern", e);
            return "";
        }
    }

    public static String convertDateToString(Date date) {
        return convertDateToStringByPattern(date, Constant.DATE.FORMAT.SHORT_DATE);
    }

    public static String convertStringToDateTime(Date date) {
        return convertDateToStringByPattern(date, Constant.DATE.FORMAT.FULL_DATE);
    }

    private static Date add(Date dt, int iValue, int iType) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(dt);
        cld.add(iType, iValue);
        return cld.getTime();
    }

    public static Timestamp convertStringToTimestamp(String strTime, String pattern) throws Exception {
        if (!StringCommon.isNullOrBlank(strTime)) {
            return new Timestamp(convertStringToDate(strTime, pattern).getTime());
        }
        return null;
    }

    public static Date addYear(Date dt, int iValue) {
        return add(dt, iValue, Calendar.YEAR);
    }

    public static Date addMonth(Date dt, int iValue) {
        return add(dt, iValue, Calendar.MONTH);
    }

    public static Date addDay(Date dt, int iValue) {
        return add(dt, iValue, Calendar.DAY_OF_MONTH);
    }

    public static Date addHour(Date dt, int iValue) {
        return add(dt, iValue, Calendar.HOUR_OF_DAY);
    }

    public static Date addMinute(Date dt, int iValue) {
        return add(dt, iValue, Calendar.MINUTE);
    }

    public static Date addSecond(Date dt, int iValue) {
        return add(dt, iValue, Calendar.SECOND);
    }

    public static Date addMilliSecond(Date dt, int iValue) {
        return add(dt, iValue, Calendar.MILLISECOND);
    }

    private static Date set(Date dt, int iValue, int iType) {
        Calendar cld = Calendar.getInstance();
        cld.setTime(dt);
        cld.set(iType, iValue);
        return cld.getTime();
    }

    public static Date setYear(Date dt, int iValue) {
        return set(dt, iValue, Calendar.YEAR);
    }

    public static Date setMonth(Date dt, int iValue) {
        return set(dt, iValue, Calendar.MONTH);
    }

    public static Date setDay(Date dt, int iValue) {
        return set(dt, iValue, Calendar.DAY_OF_MONTH);
    }

    public static Date setHour(Date dt, int iValue) {
        return set(dt, iValue, Calendar.HOUR_OF_DAY);
    }

    public static Date setMinute(Date dt, int iValue) {
        return set(dt, iValue, Calendar.MINUTE);
    }

    public static Date setSecond(Date dt, int iValue) {
        return set(dt, iValue, Calendar.SECOND);
    }

    public static Date setMilliSecond(Date dt, int iValue) {
        return set(dt, iValue, Calendar.MILLISECOND);
    }

    public static long subDay(Date date1, Date date2) {
        if ((date1 == null) && (date2 == null)) {
            return 0L;
        }
        if (date1 == null) {
            return date2.getTime() / 86400000L;
        }
        if (date2 == null) {
            return -1L * date1.getTime() / 86400000L;
        }
        return (date2.getTime() - date1.getTime()) / 86400000L;
    }

    public static long subTime(Date date1, Date date2) {
        if ((date1 == null) && (date2 == null)) {
            return 0L;
        }
        if (date1 == null) {
            return date2.getTime();
        }
        if (date2 == null) {
            return -1L * date1.getTime();
        }
        return date2.getTime() - date1.getTime();
    }

    public static Date getBeginDay(Date date) {
        date = setHour(date, 0);
        date = setMinute(date, 0);
        date = setSecond(date, 0);
        date = setMilliSecond(date, 0);

        return date;
    }

    public static Date getEndDay(Date date) {
        date = setHour(date, 23);
        date = setMinute(date, 59);
        date = setSecond(date, 59);
        date = setMilliSecond(date, 999);

        return date;
    }

    public static Date getBeginMonth(Date date) {
        date = setHour(date, 0);
        date = setMinute(date, 0);
        date = setSecond(date, 0);
        date = setMilliSecond(date, 0);
        date = setDay(date, 1);
        return date;
    }

    public static Date getEndMonth(Date date) {
        date = setHour(date, 0);
        date = setMinute(date, 0);
        date = setSecond(date, 0);
        date = setMilliSecond(date, 0);
        date = setDay(date, 1);
        date = addMonth(date, 1);
        date = addMilliSecond(date, -1);
        return date;
    }

    public static Date getBeginYear(Date date) {
        date = setHour(date, 0);
        date = setMinute(date, 0);
        date = setSecond(date, 0);
        date = setMilliSecond(date, 0);
        date = setDay(date, 1);
        date = setMonth(date, 0);
        return date;
    }

    public static Date getEndYear(Date date) {
        date = setHour(date, 0);
        date = setMinute(date, 0);
        date = setSecond(date, 0);
        date = setMilliSecond(date, 0);
        date = setDay(date, 1);
        date = setMonth(date, 0);
        date = addYear(date, 1);
        date = addMilliSecond(date, -1);
        return date;
    }

    public static int dayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(7);
    }

    public static int dayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(5);
    }

    public static int dayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(6);
    }
}
