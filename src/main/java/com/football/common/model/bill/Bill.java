package com.football.common.model.bill;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 04-Jun-18
 * Time: 10:30 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class Bill implements Serializable {
    private Long id;
    private String customerCode;
    private String billId;
    private Long amount;
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
