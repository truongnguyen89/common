/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.football.common.util;

import com.football.common.constant.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
public class NumberCommon {

    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.COMMON);

    public static Long convertToLong(Object value) {
        if (value == null || StringCommon.isNullOrBlank((String) value)) {
            return null;
        }
        try {
            Long result = Long.parseLong(value.toString());
            return result;
        } catch (NumberFormatException e) {
            LOGGER.error("Exception when converting (" + value.toString() + ") to Long value: ", e);
            return null;
        }
    }

    public static Integer convertToInteger(Object value) {
        if (value == null || StringCommon.isNullOrBlank((String) value)) {
            return null;
        }
        try {
            Integer result = Integer.valueOf(value.toString());
            return result;
        } catch (NumberFormatException e) {
            LOGGER.error("Exception when converting (" + value.toString() + ") to Integer value. Set value default zero: ", e);
            return 0;
        }
    }

    public static Float convertToFloat(Object value) {
        if (value == null || StringCommon.isNullOrBlank((String) value)) {
            return null;
        }
        try {
            Float result = Float.parseFloat(value.toString());
            return result;
        } catch (NumberFormatException e) {
            LOGGER.error("Exception when converting (" + value.toString() + ") to Float value: ", e);
            return null;
        }
    }

    public static Double convertToDouble(Object value) {
        if (value == null || StringCommon.isNullOrBlank((String) value)) {
            return null;
        }
        try {
            Double result = Double.parseDouble(value.toString());
            return result;
        } catch (NumberFormatException e) {
            LOGGER.error("Exception when converting (" + value.toString() + ") to Double value: ", e);
            return null;
        }
    }

    /**
     * convert object to long
     *
     * @param o            object
     * @param defaultValue if  o  null or empty function return defaultValue
     * @return long
     */
    static public long toLong(Object o, long defaultValue) {
        try {
            if (o == null) return defaultValue;
            if (o instanceof Long) return (long) o;
            if (o instanceof Integer) return ((Integer) o).longValue();
            if (o instanceof String && !((String) o).isEmpty()) return new Long((String) o);
        } catch (Exception e) {
            LOGGER.error("Exception: ObjectConvertor ->   toLong " + e.getMessage());
        }
        return defaultValue;
    }

    /**
     * convert object to int
     *
     * @param o            object
     * @param defaultValue if  o  null or empty function return defaultValue
     * @return int
     */
    static public int toInt(Object o, int defaultValue) {
        try {
            if (o == null) return defaultValue;
            if (o instanceof Long) return ((Long) o).intValue();
            if (o instanceof Integer) return (Integer) o;
            if (o instanceof String && !((String) o).isEmpty()) return new Integer((String) o);
        } catch (Exception e) {
            LOGGER.error("Exception: ObjectConvertor ->  toInt " + e.getMessage());
        }
        return defaultValue;
    }

    /**
     * @param number
     * @param min
     * @param max
     * @return
     * @throws IllegalArgumentException if (number == null || (min == null && max == null) || (max !=
     *                                  null && min != null && max.doubleValue() <
     *                                  min.doubleValue()))
     */
    public static boolean isBetweenRange(Number number, Number min, Number max) {

        if (number == null || (min == null && max == null)
                || (max != null && min != null && max.doubleValue() < min.doubleValue())) {
            throw new IllegalArgumentException("Invalid arguments");
        }

        return !((min == null && number.doubleValue() > max.doubleValue())
                || (max == null && number.doubleValue() < min.doubleValue()) || (min != null && max != null
                && (number.doubleValue() < min.doubleValue() || number.doubleValue() > max.doubleValue())));
    }

    public static String formatCurrencyNumber(double amount) {
        try {
            return String.format("%,.0f", amount);
        } catch (Exception e) {
            LOGGER.error("Exception when formatCurrencyNumber(" + amount + ") ", e);
        }
        return null;
    }

    public static int getRandomBetweenRange(int min, int max) {
        return min + new Random().nextInt(max);
    }

    public static long getRandomBetweenRange(long min, long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

}
