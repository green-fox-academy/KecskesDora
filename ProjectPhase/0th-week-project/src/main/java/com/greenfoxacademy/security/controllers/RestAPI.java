package com.greenfoxacademy.security.controllers;

import com.greenfoxacademy.security.models.dtos.Meal;
import com.greenfoxacademy.security.models.dtos.Meals;
import com.greenfoxacademy.security.services.RecipeRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class RestAPI {

    private RecipeRequestService recipeRequestService;

    @Autowired
    public RestAPI(RecipeRequestService recipeRequestService) {
        this.recipeRequestService = recipeRequestService;
    }

    @GetMapping("/welcome")
    public String greeting() {
        return "<h1>Welcome!<h1>";
    }

    @GetMapping("/api/recipe")
    public ResponseEntity getRecipe() throws IOException {
        return ResponseEntity.ok().body(recipeRequestService.sendRequest("a"));
    }
}
