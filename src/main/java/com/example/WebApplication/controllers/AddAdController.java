package com.example.WebApplication.controllers;
import com.example.WebApplication.entities.Ad;
import com.example.WebApplication.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/add_ad")
public class AddAdController {

    @Autowired
    private AdService adService;

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("adForm", new Ad());
        return "ad";
    }

    @PostMapping
    public String createAd(@ModelAttribute("adForm") Ad adForm, Model model) {
           if (!adService.saveAd(adForm)){
            model.addAttribute("error", "Something bruuuuh with yours ad!");
            return "ad";
        }
        return "redirect:/main";
    }
}