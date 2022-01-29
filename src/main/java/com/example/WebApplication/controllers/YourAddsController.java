package com.example.WebApplication.controllers;
import com.example.WebApplication.entities.Ad;
import com.example.WebApplication.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/your_adds")
public class YourAddsController {

    @Autowired
    private AdService adService;

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("adds", adService.getAllAddsByID());
        model.addAttribute("adForm", new Ad());
        return "your_adds";
    }

    @PostMapping
    public String delete(@ModelAttribute("adForm") Ad adForm, Model model){
        adService.deleteAdd(adForm);
        model.addAttribute("adds", adService.getAllAddsByID());
        return "your_adds";
    }
}