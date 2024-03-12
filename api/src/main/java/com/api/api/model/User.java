package com.api.api.model;


import lombok.Builder;

import java.util.List;

@Builder
public class User {

    private int id;
    private String name;
    private int age;
    private String email;
    private String accountNumber;
    private String accountStatus;
    private String accountType;
    private String currency;
//    public List<User> User;
//    private String userSet;

    public User() {
    }

    public User(int id, String name, int age, String email, String accountNumber, String accountStatus, String accountType, String currency){
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.accountNumber = accountNumber;
        this.accountStatus = accountStatus;
        this.accountType = accountType;
        this.currency = currency;

    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    public String getAccountNumber(){return accountNumber;}
    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }
    public String getAccountStatus(){return accountStatus;}
    public void setAccountType(String accountType) {
        this.accountStatus = accountStatus;
    }
    public String getAccountType(){return accountType;}
    public void setCurrency(String currency) {
        this.accountStatus = accountStatus;
    }
    public String getCurrency(){return currency;}

}
