package com.greenfoxacademy.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI {

    @GetMapping("/welcome")
    public String greeting() {
        return "<h1>Welcome!<h1>";
    }
}
