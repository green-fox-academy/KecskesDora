package com.greenfoxacademy.security.controllers;

import com.greenfoxacademy.security.models.entities.User;
import com.greenfoxacademy.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    private UserService userService;

    @Autowired
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String renderRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(Model model, @ModelAttribute User user) {
        userService.save(user);
        return "hello";
    }

    /*@GetMapping("/login")
    public String renderLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/login")
    public String loginUser() {

        return "login";
    }*/

    @GetMapping("/hello")
    public String greeting() {
        return "hello";
    }
}
