package com.example.WebApplication.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adfeed")
public class AdFeedController {

    @GetMapping
    public String mainPage(Model model){

        return "ad_feed";
    }
}