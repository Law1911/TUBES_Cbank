package com.cbank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class activeAccount {
    
    @GetMapping("/activeAccount")
    public String CactiveAccount(Model model){
        return  "activeAccount";
    }
}