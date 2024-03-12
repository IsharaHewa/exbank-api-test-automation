package com.api.api.model;

import lombok.Builder;

@Builder
public class GetBalance {
    private String accountNumber;
    private Double balance;
    private Double limit;
    private String currency;
    public GetBalance(String accountNumber, Double balance,Double limit, String currency){
        this.accountNumber=accountNumber;
        this.balance=balance;
        this.limit=limit;
        this.currency=currency;
    }

    public String getAccountNumber(){return accountNumber;}
    public void setAccountNumber(String accountStatus) {
        this.accountNumber = accountStatus;
    }
    public Double getBalance(){return balance;}
    public void setBalance(Double amount) {
        this.balance = balance;
    }
    public Double getLimit(){return limit;}
    public void setLimit(Double amount) {
        this.limit = limit;
    }
    public String getCurrency(){return currency;}
    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
