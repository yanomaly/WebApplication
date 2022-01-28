package com.example.WebApplication.controllers;
import com.example.WebApplication.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ad_feed_unlog")
public class AdFeedUnlogController {

    @Autowired
    private AdService adService;

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("adds", adService.getAll());
        return "ad_feed_unlog";
    }
}