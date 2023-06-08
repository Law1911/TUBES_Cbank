package com.cbank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller

public class deposit {

    @GetMapping("/deposit.html")
    public String Cdeposit(Model model){
        return "deposit";
    }
}
