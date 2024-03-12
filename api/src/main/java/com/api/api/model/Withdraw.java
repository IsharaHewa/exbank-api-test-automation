package com.api.api.model;

import lombok.Builder;

@Builder
public class Withdraw {
    private String accountNumber;
    private Double amount;
    private String currency;
}
