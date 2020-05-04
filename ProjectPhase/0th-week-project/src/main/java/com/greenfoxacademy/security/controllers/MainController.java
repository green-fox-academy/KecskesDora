package com.greenfoxacademy.security.controllers;

import com.greenfoxacademy.security.models.dtos.UserDTO;
import com.greenfoxacademy.security.models.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @GetMapping("/register")
    public String renderRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/login")
    public String renderLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser() {
        return "login";
    }

    @GetMapping("/hello")
    public String greeting() {
        return "hello";
    }
}
