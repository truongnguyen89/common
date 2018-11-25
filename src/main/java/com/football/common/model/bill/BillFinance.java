package com.football.common.model.bill;

import com.football.common.constant.Constant;
import com.football.common.util.JsonCommon;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Truong Nguyen
 * Date: 04-Jun-18
 * Time: 10:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class BillFinance extends Bill {
    private Long currentAmountNeedPayment;
    private Long minAmount;
    private Long maxRange;
    private Long minRange;
    private Long fee;
    private String contractNo;
    private String month;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.SHORT_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date currentPaymentExpire;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constant.DATE.FORMAT.SHORT_DATE, timezone = "Asia/Ho_Chi_Minh")
    private Date expireDate;

    public Date getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Long getCurrentAmountNeedPayment() {
        return currentAmountNeedPayment;
    }

    public void setCurrentAmountNeedPayment(Long currentAmountNeedPayment) {
        this.currentAmountNeedPayment = currentAmountNeedPayment;
    }

    public Long getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(Long minAmount) {
        this.minAmount = minAmount;
    }

    public Long getMaxRange() {
        return maxRange;
    }

    public void setMaxRange(Long maxRange) {
        this.maxRange = maxRange;
    }

    public Long getMinRange() {
        return minRange;
    }

    public void setMinRange(Long minRange) {
        this.minRange = minRange;
    }

    public Long getFee() {
        return fee;
    }

    public void setFee(Long fee) {
        this.fee = fee;
    }

    public Date getCurrentPaymentExpire() {
        return currentPaymentExpire;
    }

    public void setCurrentPaymentExpire(Date currentPaymentExpire) {
        this.currentPaymentExpire = currentPaymentExpire;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return JsonCommon.objectToJsonNotNull(this);
    }
}
