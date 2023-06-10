package com.cbank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class suspended {
    @GetMapping("/suspended")
    public String Csuspended(Model model) {
        return "suspended";
    }
}
