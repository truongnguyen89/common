package com.football.common.model.common;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 04-Oct-18
 * Time: 3:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class PassThroughArray {

    private String nameType;
    private Object[] array;

    public PassThroughArray() {
    }

    public PassThroughArray(String nameType) {
        this.nameType = nameType;
    }

    public PassThroughArray(Object[] array) {
        this.array = array;
    }

    public PassThroughArray(String nameType, Object[] array) {
        this.nameType = nameType;
        this.array = array;
    }

    public String getNameType() {
        return this.nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public Object[] getArray() {
        return this.array;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }
}
