package com.greenfoxacademy.backendapi.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String renderIndex() {
        return "index";
    }

    @org.springframework.web.bind.annotation.RestController
    public static class RestController {

    }
}
