package com.greenfoxacademy.programmerfoxclub.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @GetMapping("/")
    public String getMainPage(Model model, @RequestParam(value = "name", required = true) String name) {
        model. addAttribute("name", name);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(String name) {
        return "redirect:/?name=" + name;
    }
}
