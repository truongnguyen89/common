/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.football.common.util;

import com.football.common.constant.Constant;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.util.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
public class StringCommon {

    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.COMMON);
    private static char[] NOSIGN = new char["aaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyAAAAAAAAAAAAAAAAADEEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYY".length()];

    /**
     * @param str
     * @return
     */
    public static boolean isNullOrBlank(String str) {
        return str == null || str.trim().equals("");
    }

    public static String padleft(String s, int len, char c)
            throws Exception {
        s = s.trim();
        if (s.length() > len) {
            throw new Exception(new StringBuilder()
                    .append("invalid len ").append(s.length()).append("/")
                    .append(len).toString());
        }
        StringBuffer d = new StringBuffer(len);
        int fill = len - s.length();
        while (fill-- > 0) {
            d.append(c);
        }
        d.append(s);
        return d.toString();
    }

    public static String toNoSign(String s) {
        String result = "";
        if (isNullOrBlank(s)) {
            return result;
        }
        for (int i = 0; (s != null) && (i < s.length()); i++) {
            char c = s.charAt(i);
            int pos;
            if ((pos = "áàảãạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ".indexOf(c)) != -1) {
                result = new StringBuilder().append(result).append(NOSIGN[pos]).toString();
            } else {
                result = new StringBuilder().append(result).append(c).toString();
            }
        }
        result = result.replaceAll("[^-a-zA-Z0-9~!@#$%^&*()_+={}\\[\\]|\\\\/?<>,\"':;. ]+", "");
        return result;
    }

    /**
     * Validate {@code str} not null, not empty and matches {@code regex}
     *
     * @param str
     * @param regex
     * @return {@code str} matches {@code regex}
     * @throws IllegalArgumentException if {@code regex} is null
     */
    public static boolean isValidPattern(String str, String regex) {

        if (regex == null) {
            throw new IllegalArgumentException("Regex pattern must not be null");
        }

        if (!StringUtils.isEmpty(str)) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(str);
            return matcher.matches();
        }

        return false;
    }
}
