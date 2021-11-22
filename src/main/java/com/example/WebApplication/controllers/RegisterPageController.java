package com.example.WebApplication.controllers;

import com.example.WebApplication.entities.User;
import com.example.WebApplication.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterPageController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String mainPage(Model model){
        return "register";
    }

    @PostMapping
    public String newUser(User user, Model model){
        User us = userRepository.findByUsername(user.getUsername());
        if(us != null){
            model.addAttribute("exists", "User exists!");
            return "register";
        }
        else {
            model.addAttribute("exists", "");
            userRepository.save(user);
            return "redirect:/main";
        }
    }
}