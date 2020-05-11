package com.greenfoxacademy.security.controllers;

import com.greenfoxacademy.security.models.dtos.Meal;
import com.greenfoxacademy.security.models.dtos.Meals;
import com.greenfoxacademy.security.services.RecipeRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.awt.*;
import java.io.IOException;

@RestController
public class RestAPI {

    private RecipeRequestService recipeRequestService;

    @Autowired
    public RestAPI(RecipeRequestService recipeRequestService) {
        this.recipeRequestService = recipeRequestService;
    }

    @GetMapping("/welcome")
    public String greeting() {
        return "Welcome admin!";
    }

    @GetMapping(value = "/api/recipe/{a}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getRecipe(@PathVariable String a) throws IOException {
        return ResponseEntity.ok().body(recipeRequestService.sendRequest(a));
    }
}
