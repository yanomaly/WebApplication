package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ad")
public class AddAdController {

    @GetMapping
    public String mainPage(Model model){
        model.addAttribute("message", "Main page!");
        return "ad";
    }
}