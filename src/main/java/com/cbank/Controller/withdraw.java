package com.cbank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class withdraw {
    @GetMapping("/withdraw.html")
    public String Cwithdraw(Model model) {
        return "withdraw";
    }
}
