package com.api.api.model;

import lombok.Builder;
@Builder
public class Deposit {
    private String accountNumber;
    private Double amount;
    private String currency;
    public Deposit(){

    }
    public Deposit(String accountNumber, Double amount, String currency){
        this.accountNumber=accountNumber;
        this.amount=amount;
        this.currency=currency;
    }
    public String getAccountNumber(){return accountNumber;}
    public void setAccountNumber(String accountStatus) {
        this.accountNumber = accountStatus;
    }
    public Double getAmount(){return amount;}
    public void setAmount(Double amount) {
        this.amount = amount;
    }
    public String getCurrency(){return currency;}
    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
