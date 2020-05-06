package com.greenfoxacademy.security.services;

import com.greenfoxacademy.security.models.dtos.Recipe;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RecipeFinderService {
    @Headers({
        "x-rapidapi-host: spoonacular-recipe-food-nutrition-v1.p.rapidapi.com",
        "x-rapidapi-key: 494b0054e1msh73777c883c1e370p19df56jsn43e06e00219a"
    })
    @GET("/recipes/4632/summary")
    Call<Recipe> findRecipe();
}
