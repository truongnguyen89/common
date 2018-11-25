package com.football.common.model.customer;

import com.football.common.util.JsonCommon;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 04-Jun-18
 * Time: 10:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class CustomerFinance extends Customer {
    private String idNo;
    private String bridgeCode;

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    @Override
    public String toString() {
        return JsonCommon.objectToJsonNotNull(this);
    }

    public CustomerFinance() {
    }

    public CustomerFinance(String providerCode,
                           String code,
                           String name,
                           String address,
                           String phoneByProvider,
                           String phoneByEcpay,
                           String type,
                           String idNo) {
        setProviderCode(providerCode);
        setCode(code);
        setName(name);
        setAddress(address);
        setPhoneByProvider(phoneByProvider);
        setPhoneByEcpay(phoneByEcpay);
        setIdNo(idNo);
        setType(type);
    }

    public String getBridgeCode() {
        return bridgeCode;
    }

    public void setBridgeCode(String bridgeCode) {
        this.bridgeCode = bridgeCode;
    }
}
