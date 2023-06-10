package com.cbank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cbank.Model.Account;
import com.cbank.Model.User;
import com.cbank.Repository.AccountRepository;
import com.cbank.Repository.UserRepository;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

@Controller
public class transfer {

    @Autowired
    AccountRepository accountRepo;

    @GetMapping("/transfer.html")
    public String Ctrasfer(Model model, HttpServletRequest session) {
        User user = (User) session.getSession().getAttribute("user");

        if (user != null) {
            model.addAttribute("user", user);
            model.addAttribute("norekTujuan", "");
            return "transfer";
        } else {
            return "login";
        }
    }

    @PostMapping("/toNextTransfer")
    public String toNextTransfer(Model model, HttpServletRequest session,
            @RequestParam("norekTujuan") String norekTujuan) {
        User user = (User) session.getSession().getAttribute("user");
        System.out.println("norek tujuan : " + norekTujuan);

        Account accountTujuan = accountRepo.findByNorek(norekTujuan);
        if (user != null) {
            if (accountTujuan != null) {
                model.addAttribute("user", user);
                model.addAttribute("nominal", (double) 0);
                model.addAttribute("norekTujuan", "");
                model.addAttribute("accountTujuan", accountTujuan);
                return "transferNext";
            } else {
                return "transfer.html";
            }

        } else {
            return "login";
        }
    }

    @PostMapping("/doTransfer")
    public String doTransfer(Model model, HttpServletRequest session, @RequestParam("nominal") double nominal,
            @RequestParam("norekTujuan") String norekTujuan) {
        User user = (User) session.getSession().getAttribute("user");
        System.out.println("nominal : " + nominal);
        System.out.println("Norek tujuan : " + norekTujuan);
        if (user != null) {
            Account accountTujuan = accountRepo.findByNorek(norekTujuan);
            if (accountTujuan != null) {
                Account updateAccountTujuan = user.getAccount().transfer(nominal, accountTujuan);
                // kalo uang nya kurang, updateAccountTujuan akan null, jika uangnya cukup maka
                // return account penerima
                if (updateAccountTujuan != null) {
                    // update akun penerima ke database
                    accountRepo.save(updateAccountTujuan);
                    // update akun pengirim (yang login saat ini)
                    accountRepo.save(user.getAccount());
                    return "redirect:/transfer.html";
                } else {
                    return "transfer.html";
                }
            } else {
                return "transfer.html";
            }
        } else {
            return "login";
        }
    }

}
