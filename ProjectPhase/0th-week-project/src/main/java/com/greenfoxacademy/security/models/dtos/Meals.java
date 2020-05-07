package com.greenfoxacademy.security.models.dtos;

import java.util.List;

public class Meals {
    private List<Meal> meals;

    public Meals() {
    }

    public Meals(List<Meal> meals) {
        this.meals = meals;
    }

    public List<Meal> getMeals() {
        return meals;
    }

    public void setMeals(List<Meal> meals) {
        this.meals = meals;
    }
}
