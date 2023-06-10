package com.cbank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class updateAccountInfo {
    @GetMapping("/updateAccountInfo")
    public String CupdateAccountInfo(Model model) {
        return "updateAccountInfo";
    }
}
