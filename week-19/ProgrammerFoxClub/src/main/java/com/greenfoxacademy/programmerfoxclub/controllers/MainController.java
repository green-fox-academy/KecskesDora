package com.greenfoxacademy.programmerfoxclub.controllers;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.services.FoxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    public String getMainPage(Model model, @RequestParam(value = "name", required = false) String name) {
        //if (!foxService.check(name) || name.equals("") || name == null) {
          //  return "redirect:/login";
        //} else {
            model.addAttribute("fox", foxService.find(name));
        //}
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("name") String name) {
        /*if (name.equals("")) {
            return "redirect:/login";
        }*/
        foxService.add(name);
        return "redirect:/?name=" + name;
    }

    @GetMapping("/add-new")
    public String loginWithMessage(Model model) {
        //model.addAttribute("error", "You have provided a name that has not been used before, add it as a new one!");
        return "add-new";
    }

    @PostMapping("/add-new")
    public String loginWithMessage(@RequestParam(value = "name") String name) {
        foxService.add(name);
        return "redirect:/?name=" + name;
    }
}
