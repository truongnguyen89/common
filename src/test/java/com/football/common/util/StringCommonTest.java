package com.football.common.util;

/**
 * Created by IntelliJ IDEA.
 * User: truongnq
 * Date: 2018-12-16
 * Time: 17:38
 * To change this template use File | Settings | File Templates.
 */
public class StringCommonTest {
    public static void main(String[] args) {
        System.out.println("param1.is.null=" + Resource.getMessageResoudrce("IS_NULL"));
        System.out.println("param1.is.exists=" + Resource.getMessageResoudrce("IS_EXISTS"));
        System.out.println("param1.not.found=" + Resource.getMessageResoudrce("NOT_FOUND"));
        System.out.println("param1.inactive=" + Resource.getMessageResoudrce("INACTIVE"));
        System.out.println("param1.invalid=" + Resource.getMessageResoudrce("INVALID"));
        System.out.println("param1.of.param2.is.not.available=" + Resource.getMessageResoudrce("NOT_AVAILABLE_FIELD_OF_OBJECT"));
        System.out.println("param1.of.param2.is.null=" + Resource.getMessageResoudrce("IS_NULL_FIELD_OF_OBJECT"));
        System.out.println("param1.of.param2.is.exists=" + Resource.getMessageResoudrce("IS_EXISTS_FIELD_OF_OBJECT"));
        System.out.println("param1.of.param2.not.found=" + Resource.getMessageResoudrce("NOT_FOUND_FIELD_OF_OBJECT"));
        System.out.println("param1.of.param2.inactive=" + Resource.getMessageResoudrce("INACTIVE_FIELD_OF_OBJECT"));
        System.out.println("param1.of.param2.invalid=" + Resource.getMessageResoudrce("INVALID_FIELD_OF_OBJECT"));
    }
}
