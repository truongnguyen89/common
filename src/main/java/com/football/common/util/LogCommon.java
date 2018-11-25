/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.football.common.util;

import com.football.common.constant.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
public class LogCommon {

    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.COMMON);

    public static String getStackTraceLog(Exception e) {
        try {
            StringBuilder a = new StringBuilder(e.toString());
            for (int i = 0; i < 10; i++) {
                a.append(e.getStackTrace()[i]).append("\n");
            }
            return a.toString();
        } catch (Exception ex) {
            LOGGER.error("Exception when getStackTraceLog: ", ex);
            return e.toString() + "\n" + e.getStackTrace()[0] + "\n" + e.getStackTrace()[1] + "\n" + e.getStackTrace()[1];
        }
    }

    public static String toString(Object[] arrObj) {
        StringBuilder sb = new StringBuilder("{");
        for (Object ob : arrObj) {
            if (!"{".equals(sb.toString())) {
                sb.append(", ");
            }
            sb.append(ob);
        }
        return sb.append("}").toString();
    }
}
