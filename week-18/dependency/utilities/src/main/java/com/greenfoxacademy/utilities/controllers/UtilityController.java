package com.greenfoxacademy.utilities.controllers;

import com.greenfoxacademy.utilities.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("useful/email")
    public String validateEmail(Model model, @RequestParam(name = "email", required = false) String email) {

        if (email != null) {
            model.addAttribute("email", email);
            model.addAttribute("checkValidEmail", service.checkValidEmail(email));
        } else {
            model.addAttribute("error", "No given email");
        }
        return "email";
    }

    @GetMapping("useful/encoder")
    public String encoding(Model model, @RequestParam(name = "text", required = false) String text,
                           @RequestParam(name = "number", required = false) Integer number) {

        if (text != null && number != null) {
            model.addAttribute("newText", service.caesar(text, number));
        } else {
            model.addAttribute("error", "No text to encode");
        }
        return "caesar";
    }

    @GetMapping("useful/decoder")
    public String decoding(Model model, @RequestParam(name = "text", required = false) String text,
                           @RequestParam(value = "number", required = false) Integer number) {

        if (text != null && number != null) {
            model.addAttribute("newText", service.caesar(text, -number));
        } else {
            model.addAttribute("error", "No text to decode");
        }
        return "caesar";
    }
}
