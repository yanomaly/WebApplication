package com.example.WebApplication.controllers;
import com.example.WebApplication.entities.Order;
import com.example.WebApplication.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ad_feed")
public class AdFeedController {

    @Autowired
    private AdService adService;

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("adds", adService.getAll(3));
        model.addAttribute("order", new Order());
        return "ad_feed";
    }

    @PostMapping
    public String sorted(@ModelAttribute("order") Order order, Model model){
        model.addAttribute("adds", adService.getAll(order.getOrder()));
        return "ad_feed";
    }
}