package com.api.api.controller;

import com.api.api.model.Withdraw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exbank")
public class WithdrawController {
    @Autowired
    private Withdraw withdraw;
    @PostMapping("/withdraw")
    //POST request controller to withdraw
    public Withdraw deposit(@RequestBody Withdraw withdraw){
        this.withdraw = withdraw;
        return withdraw;
    }

}
