package com.example.WebApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageUnloginedController {

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("message", "Main page!");
        return "main_unlog";
    }
}
