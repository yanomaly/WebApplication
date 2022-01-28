package com.example.WebApplication.controllers;
import com.example.WebApplication.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/your_adds")
public class YourAddsController {

    @Autowired
    private AdService adService;

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("adds", adService.getAllAddsByID());
        return "your_adds";
    }

    @PostMapping
    public String delete(Model model){

        return "your_adds";
    }
}