/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.football.common.util;

import java.util.List;

/**
 * @date created : Apr 7, 2018
 * @author : TruongNQ
 * @describe : Expression des is undefined on line 13, column 25 in
 * Templates/Classes/Class.java.
 */
public class ArrayListCommon {

    public static boolean isNullOrEmpty(List lst) {
        return lst == null || lst.isEmpty();
    }

    public static boolean isNullOrEmpty(Object[] arrObj) {
        return arrObj == null || arrObj.length == 0;
    }

    public static Object[] convertList2Array(List list) {
        return list.toArray(new Object[list.size()]);
    }
}
