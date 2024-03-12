package com.api.api.controller;

import com.api.api.model.GetBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/exbank")

//GET request controller to get balance
public class BalanceController {
    @Autowired
    private GetBalance getBalance;
    @GetMapping("/getBalance/{user}")
    public GetBalance getBalance(@RequestBody GetBalance getBalance){
        this.getBalance = getBalance;
        return getBalance;
    }
}
