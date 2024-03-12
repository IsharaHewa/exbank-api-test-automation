package com.api.api.controller;

import com.api.api.model.Deposit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exbank")
//POST request controller to deposit
public class DepositController {
    @Autowired
    private Deposit deposit;
    @PostMapping("/deposit")
    public Deposit deposit(@RequestBody Deposit deposit){
        this.deposit = deposit;
        return deposit;
    }
}

