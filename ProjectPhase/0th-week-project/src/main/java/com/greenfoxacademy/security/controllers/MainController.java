package com.greenfoxacademy.security.controllers;

import com.greenfoxacademy.security.models.Role;
import com.greenfoxacademy.security.models.dtos.UserDTO;
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

   /*@GetMapping("/login")
    public String renderLoginForm(Model model, @ModelAttribute UserDTO user) {
        //model.addAttribute("user", user);
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute UserDTO user) {

        return "login";
    }

    @GetMapping("/register")
    public String renderRegistrationForm(Model model, @ModelAttribute UserDTO user) {
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/login";
    }*/
}
