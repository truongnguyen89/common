package com.football.common.model.customer;

import com.football.common.model.bill.BillFinance;
import com.football.common.response.Response;

import java.util.List;

public class CustomerBillFinance extends CustomerFinance{
    private String responseCode;
    private String description;

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

    private List<BillFinance> billFinanceList;

    public List<BillFinance> getBillFinanceList() {
        return billFinanceList;
    }

    public void setBillFinanceList(List<BillFinance> billFinanceList) {
        this.billFinanceList = billFinanceList;
    }
}
