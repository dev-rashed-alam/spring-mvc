package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    @GetMapping("/")
    public String helloWorld(Model model) {
        model.addAttribute("name","Rashed Alam");
        return "hello";
    }
}
