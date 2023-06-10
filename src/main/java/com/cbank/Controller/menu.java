package com.cbank.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

@Controller
public class menu {

    @GetMapping("/menu")
    public String Cmenu(Model model) {

        // model.addAttribute("dri", arrmenu);
        return "menu";
    }
}
