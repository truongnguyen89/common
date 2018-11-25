package com.football.common.util;

import java.util.Random;

/**
 * @author : TruongNQ
 * @date created : Apr 7, 2018
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
public class Common {

    /**
     *
     * @return audit-number 9 char number
     */
    public static Long getAuditNumber() {
        return Math.abs(new Random().nextLong() % 1000000000);
    }
}
