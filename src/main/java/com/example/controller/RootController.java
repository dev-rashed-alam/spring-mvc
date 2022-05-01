package com.example.controller;

import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @Autowired
    AccountService accountService;

    @GetMapping("/")
    public String helloWorld(Model model) {
        System.out.println(accountService.getAccountDetails());
        model.addAttribute("name","Rashed Alam");
        return "hello";
    }
}
