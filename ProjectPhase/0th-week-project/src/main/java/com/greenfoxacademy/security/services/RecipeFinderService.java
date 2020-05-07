package com.greenfoxacademy.security.services;

import com.greenfoxacademy.security.models.dtos.Meal;
import com.greenfoxacademy.security.models.dtos.Meals;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface RecipeFinderService {

    @GET("/api/json/v1/1/search.php")
    Call<Meals> findRecipe(@Query("f") String a);
}
