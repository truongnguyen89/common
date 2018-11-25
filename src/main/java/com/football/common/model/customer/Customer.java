package com.football.common.model.customer;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 04-Jun-18
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Customer implements Serializable {
    private Long id;
    private String providerCode;
    private String code;
    private String name;
    private String address;
    private String phoneByProvider;
    private String phoneByEcpay;
    private Integer status;
    private String type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneByProvider() {
        return phoneByProvider;
    }

    public void setPhoneByProvider(String phoneByProvider) {
        this.phoneByProvider = phoneByProvider;
    }

    public String getPhoneByEcpay() {
        return phoneByEcpay;
    }

    public void setPhoneByEcpay(String phoneByEcpay) {
        this.phoneByEcpay = phoneByEcpay;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
