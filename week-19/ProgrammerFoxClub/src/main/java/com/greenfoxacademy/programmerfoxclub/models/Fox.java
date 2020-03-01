package com.greenfoxacademy.programmerfoxclub.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fox {
    private String name;
    private List<String> tricks;
    private String food;
    private String drink;
    private List<String> actions;

    public Fox() {
        tricks = new ArrayList<>();
        actions = new ArrayList<>();
    }

    public Fox(String name) {
        this.name = name;
        tricks = new ArrayList<>();
        actions = new ArrayList<>();
    }

    public Fox(String name, String food, String drink) {
        this.name = name;
        this.food = food;
        this.drink = drink;
        tricks = new ArrayList<>();
        actions = new ArrayList<>();
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
        if (tricks.isEmpty()) {
            return 0;
        } else {
            return tricks.size();
        }
    }

    public boolean learntAllTricks() {
        if (tricks.isEmpty()) {
            return false;
        } else {
            return (tricks.size() == Arrays.asList(Food.values()).size() + 1);
        }
    }

    public List<String> tricksToLearn() {
        List<String> tricksToLearn = new ArrayList<>(Tricks.getList());

        for (String trick : tricks) {
            tricksToLearn.remove(trick);
        }
        return tricksToLearn;
    }

    public String getFood() {
        if (food == null) {
            return "no food";
        } else {
            return food;
        }
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getDrink() {
        if (drink == null) {
            return "no drink";
        } else {
            return drink;
        }
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public List<String> getActions() {
        return actions;
    }

    public void addAction(String newAction) {
        actions.add(newAction);
    }

    public int numberOfActions() {
        if (actions.isEmpty()) {
            return 0;
        } else {
            return actions.size();
        }
    }

    public List<String> lastFiveActions() {
        List<String> lastFiveActions = new ArrayList<>();
        if (actions.size() > 4) {
            for (int i = actions.size() - 5; i < actions.size(); i++) {
                lastFiveActions.add(actions.get(i));
            }
            return lastFiveActions;
        }
        return actions;
    }

    @Override
    public String toString() {
        return "This is " + name + ". Currently living on " + getFood() +
                " and " + getDrink() + ". He/She knows " + numberOfTricks() + " trick(s).";
    }
}
