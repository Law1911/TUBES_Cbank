package com.cbank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class listCustomers {
    @GetMapping("/listCustomers")
    public String ClistCustomers(){
        return "listCustomers";
    }
}
