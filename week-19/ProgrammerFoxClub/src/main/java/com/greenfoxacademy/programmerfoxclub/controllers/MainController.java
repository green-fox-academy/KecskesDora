package com.greenfoxacademy.programmerfoxclub.controllers;

import com.greenfoxacademy.programmerfoxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    FoxService foxService;

    @Autowired
    public MainController(FoxService foxService) {
        this.foxService = foxService;
    }

    @GetMapping("/")
    public String getMainPage(Model model, @RequestParam(value = "name", required = true) String name) {
        model.addAttribute("name", name);
        model.addAttribute("fox", foxService.find(name));
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

    @GetMapping("/nutritionStore")
    public String nutritionStore(Model model, @RequestParam(value = "name", required = true) String name) {
        model.addAttribute("name", name);
        return "nutrition";
    }

    @PostMapping("/nutritionStore")
    public String nutritionStore(@RequestParam(value = "name", required = true) String name, String food, String drink) {
        foxService.find(name).setFood(food);
        foxService.find(name).setDrink(drink);
        return "redirect:/?name=" + name;
    }
}
