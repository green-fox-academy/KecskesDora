package com.greenfox.finder.controller;

import com.greenfox.finder.service.UserService;
import com.greenfox.finder.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aze on 25/10/17.
 */
@Controller
@RequestMapping("/app")
public class AppController {

    @Autowired
    UserService service;

    public AppController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("users", service.getAll());
        return "index";
    }

    @PostMapping
    public String create(@ModelAttribute User newUser) {
        service.save(newUser);
        return "redirect:/app/";
    }
}