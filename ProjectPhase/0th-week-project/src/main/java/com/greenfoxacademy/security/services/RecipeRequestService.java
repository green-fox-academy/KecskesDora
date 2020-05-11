package com.greenfoxacademy.security.services;

import com.greenfoxacademy.security.models.dtos.Meals;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class RecipeRequestService {

    public Meals sendRequest(String a) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.themealdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RecipeFinderService recipeFinderService = retrofit.create(RecipeFinderService.class);

        Call<Meals> retrofitCall = recipeFinderService.findRecipe(a);
        Response<Meals> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null ? response.errorBody().string() : "Unknown error");
        }
        return response.body();
    }
}
