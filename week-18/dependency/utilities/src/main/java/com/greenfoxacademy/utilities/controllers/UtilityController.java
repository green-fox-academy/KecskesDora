package com.greenfoxacademy.utilities.controllers;

import com.greenfoxacademy.utilities.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UtilityController {

    private UtilityService service;

    @Autowired
    public UtilityController(UtilityService service) {
        this.service = service;
    }

    @GetMapping("/useful")
    public String mainPage() {
        return "useful";
    }

    @GetMapping("/useful/colored")
    public String coloredBackground(Model model) {
        model.addAttribute("color", service.randomColor());
        return "empty";
    }
}
