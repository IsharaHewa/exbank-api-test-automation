package com.api.api.model;

import lombok.Builder;

@Builder
public class Send {
    private String sendAccountNumber;
    private String receiveAccountNumber;
    private Double amount;
    private String currency;

    public Send(){

    }
    public Send(String sendAccountNumber, String receiveAccountNumber, Double amount, String currency){
        this.sendAccountNumber = sendAccountNumber;
        this.receiveAccountNumber = receiveAccountNumber;
        this.amount = amount;
        this.currency = currency;
    }
    public String getSendAccountNumber() {
        return sendAccountNumber;
    }

    public void setSendAccountNumber(String sendAccountNumber) {
        sendAccountNumber = sendAccountNumber;
    }

    public String getReceiveAccountNumber() {
        return receiveAccountNumber;
    }

    public void setReceiveAccountNumber(String receiveAccountNumber) {
        receiveAccountNumber = receiveAccountNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
