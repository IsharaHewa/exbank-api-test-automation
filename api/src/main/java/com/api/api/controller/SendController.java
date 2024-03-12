package com.api.api.controller;

import com.api.api.model.Send;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exbank")
//GET request controller tof get balance
public class SendController {
    @Autowired
    private Send send;

    @PostMapping("/send")
    public Send send(@RequestBody Send send){
        this.send = send;
        return send;
    }
}
