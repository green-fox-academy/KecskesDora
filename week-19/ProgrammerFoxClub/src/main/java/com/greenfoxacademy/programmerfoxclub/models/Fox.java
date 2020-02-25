package com.greenfoxacademy.programmerfoxclub.models;

import java.util.ArrayList;
import java.util.List;

public class Fox {
    private String name;
    private List<String> tricks;
    private String food;
    private String drink;

    public Fox() {
        tricks = new ArrayList<>();
    }

    public Fox(String name) {
        this.name = name;
        tricks = new ArrayList<>();
    }

    public Fox(String name, String food, String drink) {
        this.name = name;
        this.food = food;
        this.drink = drink;
        tricks = new ArrayList<>();
    }

    public Fox(String name, List<String> tricks, String food, String drink) {
        this.name = name;
        this.tricks = tricks;
        this.food = food;
        this.drink = drink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTricks() {
        return tricks;
    }

    public void setTricks(List<String> tricks) {
        this.tricks = tricks;
    }

    public int numberOfTricks() {
        if (!tricks.isEmpty()) {
            return tricks.size();
        }
        return 0;
    }

    public String getFood() {
        if (food != null) {
            return food;
        }
        return "no food";
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        if (drink != null) {
            return drink;
        }
        return "no drink";
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "This is " + name + ". Currently living on " + getFood() +
                " and " + getDrink() + ". He knows " + numberOfTricks() + " tricks.";
    }
}
