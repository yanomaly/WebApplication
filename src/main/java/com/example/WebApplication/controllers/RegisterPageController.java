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

import java.util.regex.Pattern;

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
        if(!Pattern.compile(".{6,}").matcher(userForm.getPassword()).find())
            model.addAttribute("weakPassword", "Weak password!\nIt's length should be at least 6 symbols.");
        if (!userService.saveUser(userForm)){
            model.addAttribute("usernameError", "User with this name already exists!");
            return "register";
        }
        return "register";
    }
}