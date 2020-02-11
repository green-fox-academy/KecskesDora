package com.greenfoxacademy.springstart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloWebController {

    /*@RequestMapping("/web/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", " World");
        return "greeting";*/

    private AtomicLong numberOfCalls = new AtomicLong();

    @RequestMapping("/web/greeting")
    public String greeting(Model model, @RequestParam String name) {

        model.addAttribute("name", name);
        model.addAttribute("numberOfCalls", numberOfCalls.incrementAndGet());
        return "greeting";
    }
}
