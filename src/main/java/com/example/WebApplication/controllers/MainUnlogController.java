package com.example.WebApplication.controllers;
import com.example.WebApplication.entities.Ad;
import com.example.WebApplication.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class MainUnlogController {

    @Autowired
    private AdService adService;

    @GetMapping
    public String mainPage(Model model){
        List<Ad> a = adService.getThreeLast();
        model.addAttribute("adds", a);
        return "main_unlog";
    }
}