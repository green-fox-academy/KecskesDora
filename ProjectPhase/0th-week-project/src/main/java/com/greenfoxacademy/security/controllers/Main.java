package com.greenfoxacademy.security.controllers;

import com.greenfoxacademy.security.services.RecipeFinderService;
import com.greenfoxacademy.security.services.RecipeRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class Main {

    private RecipeRequestService recipeRequestService;

    @Autowired
    public Main(RecipeRequestService recipeRequestService) {
        this.recipeRequestService = recipeRequestService;
    }

    @GetMapping("/api/send")
    public String sendRequest() throws IOException {
        recipeRequestService.sendRequest("a");
        return "redirect:/api/recipe";
    }
}
