package com.example.WebApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adds")
public class YourAddsController {

    @GetMapping
    public String mainPage(Model model){

        return "your_adds";
    }
}