package com.example.WebApplication.controllers;

import com.example.WebApplication.entities.User;
import com.example.WebApplication.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegisterPageController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("userForm", new User());
        return "register";
    }

    @PostMapping
    public String newUser(@ModelAttribute ("userForm") User userForm, Model model){
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "register";
        }
        return "redirect:/main";
    }
}