package com.football.common.util;

import com.football.common.constant.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.io.ClassPathResource;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
public class Resource {

    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.COMMON);

    private static ResourceBundle rb = null;

    public static String getMessageResoudrce(String key) {
        return getMessageResource(key, null);
    }

    public static String getResoudrce(String fileConfig, String key) {
        return getResource(fileConfig, key, null);
    }

    public static String getMessageResource(String key, Locale locale) {
        try {
            if (locale == null) {
                rb = ResourceBundle.getBundle("messages");
            } else {
                rb = ResourceBundle.getBundle("messages", locale);
            }
            return rb.getString(key);
        } catch (Exception ex) {
            LOGGER.error("Exception when getting resource: ", ex);
        }
        return key;
    }

    public static String getResource(String fileConfig, String key, Locale locale) {
        if (StringCommon.isNullOrBlank(fileConfig)) {
            return key;
        }
        try {
            if (locale == null) {
                rb = ResourceBundle.getBundle(fileConfig);
            } else {
                rb = ResourceBundle.getBundle(fileConfig, locale);
            }
            return rb.getString(key);
        } catch (Exception ex) {
            LOGGER.error("Exception when getting resource: ", ex);
        }
        return key;
    }

    public static PropertiesFactoryBean mapper(String fileConfig) {
        PropertiesFactoryBean bean = new PropertiesFactoryBean();
        bean.setLocation(new ClassPathResource(fileConfig.endsWith("properties") ? fileConfig : (fileConfig + ".properties")));
        return bean;
    }

}
