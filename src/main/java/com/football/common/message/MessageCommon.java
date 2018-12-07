package com.football.common.message;

import com.football.common.constant.Constant;
import com.football.common.util.ArrayListCommon;
import com.football.common.util.StringCommon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.MessageFormat;

public class MessageCommon {
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.COMMON);

    public static String getMessage(String msgPattern, Object[] params) {
        if (!StringCommon.isNullOrBlank(msgPattern) && !ArrayListCommon.isNullOrEmpty(params)) {
            msgPattern = MessageFormat.format(msgPattern, params);
        }
        return msgPattern;
    }

    public static String getMessage(String msgPattern, String param) {
        if (!StringCommon.isNullOrBlank(msgPattern) && !StringCommon.isNullOrBlank(param)) {
            Object[] a = {param};
            msgPattern = MessageFormat.format(msgPattern, a);
        }
        return msgPattern;
    }

    public static String getMessage(String msgPattern, String field, String object) {
        if (!StringCommon.isNullOrBlank(msgPattern) && !StringCommon.isNullOrBlank(field) && !StringCommon.isNullOrBlank(object)) {
            Object[] a = {field, object};
            msgPattern = MessageFormat.format(msgPattern, a);
        }
        return msgPattern;
    }
}
