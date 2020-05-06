package com.greenfoxacademy.security.controllers;

import com.greenfoxacademy.security.models.dtos.Recipe;
import com.greenfoxacademy.security.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestAPI {

    private RequestService requestService;

    @Autowired
    public RestAPI(RequestService requestService) {
        this.requestService = requestService;
    }

    @GetMapping("/welcome")
    public String greeting() {
        return "<h1>Welcome!<h1>";
    }

    @GetMapping("/recipe")
    public ResponseEntity getResponse(@RequestBody Recipe recipe) {
        return ResponseEntity.ok().body(recipe);
    }
}
