package com.cbank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class index {
    @GetMapping("/index")
    public String Cindex(Model model){
        return "index";
    }
}
