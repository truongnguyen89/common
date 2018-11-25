package com.football.common.model.billing;

import com.football.common.response.Response;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 02-Jul-18
 * Time: 2:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class BillingBody {
    private Long auditNumber;
    private Long traceNumber;
    private String edong;
    private String cashierPay;
    private Long amount;
    private String providerCode;
    private String session;
    private String otp;
    private String partnerCode;
    private String billSerial;
    private String[] params;
    private String responseCode;
    private String description;

    public Long getAuditNumber() {
        return auditNumber;
    }

    public void setAuditNumber(Long auditNumber) {
        this.auditNumber = auditNumber;
    }

    public Long getTraceNumber() {
        return traceNumber;
    }

    public void setTraceNumber(Long traceNumber) {
        this.traceNumber = traceNumber;
    }

    public String getEdong() {
        return edong;
    }

    public void setEdong(String edong) {
        this.edong = edong;
    }

    public String getCashierPay() {
        return cashierPay;
    }

    public void setCashierPay(String cashierPay) {
        this.cashierPay = cashierPay;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getProviderCode() {
        return providerCode;
    }

    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }

    public String getPartnerCode() {
        return partnerCode;
    }

    public void setPartnerCode(String partnerCode) {
        this.partnerCode = partnerCode;
    }

    public String getBillSerial() {
        return billSerial;
    }

    public void setBillSerial(String billSerial) {
        this.billSerial = billSerial;
    }

    public String[] getParams() {
        return params;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setResponse(Response response) {
        this.responseCode = response.getResponseCode();
        this.description = response.getDescription();
    }
}
