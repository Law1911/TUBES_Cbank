package com.cbank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller

public class addAccount {

    @GetMapping("/addAccount")
    public String CaddAccount(Model model) {
        return "addAccount";
    }
}
