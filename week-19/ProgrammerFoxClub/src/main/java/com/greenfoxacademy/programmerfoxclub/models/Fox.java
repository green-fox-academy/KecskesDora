package com.greenfoxacademy.programmerfoxclub.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Fox {
    private String name;
    private List<String> tricks;
    private String food;
    private String drink;

    public Fox() {
        food = "chicken";
        drink = "water";
        tricks = new ArrayList<>();
    }

    public Fox(String name) {
        this.name = name;
        food = "chicken";
        drink = "water";
        tricks = new ArrayList<>();
    }

    public Fox(String name, String food, String drink) {
        this.name = name;
        this.food = food;
        this.drink = drink;
        tricks = new ArrayList<>();
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

    public void setTricks(String newTrick) {
        if (!tricks.contains(newTrick)) {
            tricks.add(newTrick);
        }
    }

    public int numberOfTricks() {
        if (!tricks.isEmpty()) {
            return tricks.size();
        }
        return 0;
    }

    public boolean learntAllTricks() {
        if (!tricks.isEmpty()) {
            return (tricks.size() == Arrays.asList(Food.values()).size() + 1);
        }
        return false;
    }

    public List<String> tricksToLearn() {
        List<Tricks> allTricks = new ArrayList<>(Arrays.asList(Tricks.values()));
        List<String> stringTricks = allTricks.stream()
                .map(trick -> Objects.toString(trick, null))
                .collect(Collectors.toList());

        for (String trick : getTricks()) {
            stringTricks.remove(trick);
        }
        return stringTricks;
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
                " and " + getDrink() + ". He/She knows " + numberOfTricks() + " trick(s).";
    }
}
