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

    private static final String UNICODE = "áàảãạăắằẳẵặâấầẩẫậđéèẻẽẹêếềểễệíìỉĩịóòỏõọôốồổỗộơớờởỡợúùủũụưứừửữựýỳỷỹỵÁÀẢÃẠĂẮẰẲẴẶÂẤẦẨẪẬĐÉÈẺẼẸÊẾỀỂỄỆÍÌỈĨỊÓÒỎÕỌÔỐỒỔỖỘƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰÝỲỶỸỴ";
    private static final String NOSIGN_CONST = "aaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyAAAAAAAAAAAAAAAAADEEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYY";
    private static char[] NOSIGN = new char["aaaaaaaaaaaaaaaaadeeeeeeeeeeeiiiiiooooooooooooooooouuuuuuuuuuuyyyyyAAAAAAAAAAAAAAAAADEEEEEEEEEEEIIIIIOOOOOOOOOOOOOOOOOUUUUUUUUUUUYYYYY".length()];

    public static final byte[] EBCDIC2ASCII = { 0, 1, 2, 3, -100, 9, -122, 127, -105, -115, -114, 11, 12, 13, 14, 15, 16, 17, 18, 19, -99, 10, 8, -121, 24, 25, -110, -113, 28, 29, 30, 31, -128, -127, -126, -125, -124, -123, 23, 27, -120, -119, -118, -117, -116, 5, 6, 7, -112, -111, 22, -109, -108, -107, -106, 4, -104, -103, -102, -101, 20, 21, -98, 26, 32, -96, -30, -28, -32, -31, -29, -27, -25, -15, -94, 46, 60, 40, 43, 124, 38, -23, -22, -21, -24, -19, -18, -17, -20, -33, 33, 36, 42, 41, 59, 94, 45, 47, -62, -60, -64, -63, -61, -59, -57, -47, -90, 44, 37, 95, 62, 63, -8, -55, -54, -53, -56, -51, -50, -49, -52, 96, 58, 35, 64, 39, 61, 34, -40, 97, 98, 99, 100, 101, 102, 103, 104, 105, -85, -69, -16, -3, -2, -79, -80, 106, 107, 108, 109, 110, 111, 112, 113, 114, -86, -70, -26, -72, -58, -92, -75, 126, 115, 116, 117, 118, 119, 120, 121, 122, -95, -65, -48, 91, -34, -82, -84, -93, -91, -73, -87, -89, -74, -68, -67, -66, -35, -88, -81, 93, -76, -41, 123, 65, 66, 67, 68, 69, 70, 71, 72, 73, -83, -12, -10, -14, -13, -11, 125, 74, 75, 76, 77, 78, 79, 80, 81, 82, -71, -5, -4, -7, -6, -1, 92, -9, 83, 84, 85, 86, 87, 88, 89, 90, -78, -44, -42, -46, -45, -43, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, -77, -37, -36, -39, -38, -97 };

    public static final byte[] ASCII2EBCDIC = { 0, 1, 2, 3, 55, 45, 46, 47, 22, 5, 21, 11, 12, 13, 14, 15, 16, 17, 18, 19, 60, 61, 50, 38, 24, 25, 63, 39, 28, 29, 30, 31, 64, 90, 127, 123, 91, 108, 80, 125, 77, 93, 92, 78, 107, 96, 75, 97, -16, -15, -14, -13, -12, -11, -10, -9, -8, -7, 122, 94, 76, 126, 110, 111, 124, -63, -62, -61, -60, -59, -58, -57, -56, -55, -47, -46, -45, -44, -43, -42, -41, -40, -39, -30, -29, -28, -27, -26, -25, -24, -23, -83, -32, -67, 95, 109, 121, -127, -126, -125, -124, -123, -122, -121, -120, -119, -111, -110, -109, -108, -107, -106, -105, -104, -103, -94, -93, -92, -91, -90, -89, -88, -87, -64, 79, -48, -95, 7, 32, 33, 34, 35, 36, 37, 6, 23, 40, 41, 42, 43, 44, 9, 10, 27, 48, 49, 26, 51, 52, 53, 54, 8, 56, 57, 58, 59, 4, 20, 62, -1, 65, -86, 74, -79, -97, -78, 106, -75, -69, -76, -102, -118, -80, -54, -81, -68, -112, -113, -22, -6, -66, -96, -74, -77, -99, -38, -101, -117, -73, -72, -71, -85, 100, 101, 98, 102, 99, 103, -98, 104, 116, 113, 114, 115, 120, 117, 118, 119, -84, 105, -19, -18, -21, -17, -20, -65, -128, -3, -2, -5, -4, -70, -82, 89, 68, 69, 66, 70, 67, 71, -100, 72, 84, 81, 82, 83, 88, 85, 86, 87, -116, 73, -51, -50, -53, -49, -52, -31, 112, -35, -34, -37, -36, -115, -114, -33 };
    public static final byte STX = 2;
    public static final byte FS = 28;
    public static final byte US = 31;
    public static final byte RS = 29;
    public static final byte GS = 30;
    public static final byte ETX = 3;
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

    /**
     *
     * @param str
     * @return reverse of String input
     */
    public static String reverse(String str) {
        if (isNullOrBlank(str))
            return str;
        else
            return new StringBuffer(str).reverse().toString();
    }
}
