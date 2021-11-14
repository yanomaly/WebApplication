package com.example.WebApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add_ad")
public class AddAdController {

    @GetMapping
    public String mainPage(Model model){

        return "ad";
    }
}