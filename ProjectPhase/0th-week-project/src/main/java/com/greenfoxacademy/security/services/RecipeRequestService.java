package com.greenfoxacademy.security.services;

import com.greenfoxacademy.security.models.dtos.Recipe;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class RecipeRequestService {

    public void sendRequest() throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RecipeFinderService recipeFinderService = retrofit.create(RecipeFinderService.class);
        try {
            recipeFinderService.findRecipe().execute();
        } catch (IOException e){
            System.err.println("Error");
        }
    }

}
