package com.greenfoxacademy.security.controllers;

import com.greenfoxacademy.security.models.dtos.Recipe;
import com.greenfoxacademy.security.services.RecipeFinderService;
import com.greenfoxacademy.security.services.RecipeRequestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RestAPI {

    private RecipeRequestService recipeFinderRequestService;

    @Autowired
    public RestAPI(RecipeRequestService recipeFinderRequestService) {
        this.recipeFinderRequestService = recipeFinderRequestService;
    }

    @GetMapping("/welcome")
    public String greeting() {
        return "<h1>Welcome!<h1>";
    }

    @GetMapping("/api/recipe")
    public ResponseEntity getRecipe(@RequestBody Recipe recipe) throws IOException {
        recipeFinderRequestService.sendRequest();
        return ResponseEntity.ok().body(recipe);
    }
}
