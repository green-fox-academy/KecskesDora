package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Drink;
import com.greenfoxacademy.programmerfoxclub.models.Food;
import com.greenfoxacademy.programmerfoxclub.models.Fox;
import com.greenfoxacademy.programmerfoxclub.models.Tricks;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FoxService {
    private List<Fox> foxes;

    private FoxService() {
        foxes = new ArrayList<>();
        foxes.add(new Fox("Vuk","duck", "water"));
        foxes.add(new Fox("Csele","chicken","water"));
        foxes.add(new Fox("Karak"));
    }

    public void add(String name) {
        if (find(name) != null) {
        foxes.add(new Fox(name));
        }
    }

    /*public void add2(Fox newFox) {
        if (newFox != null) {
            foxes.add(newFox);
        }
    }*/

    public boolean check(String name) {
        for (Fox fox : foxes) {
            if (fox.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public Fox find(String name) {
        for (Fox fox : foxes) {
            if (fox.getName().equalsIgnoreCase(name)) {
                return fox;
            }
        }
        return null;
    }

    /*public Fox find(String name) {
        if(!check(name)) {
            add(name);
        }
        Fox foxToFind = null;
        for (Fox fox : foxes) {
            if (fox.getName().equalsIgnoreCase(name)) {
                foxToFind = fox;
            }
        }
        return foxToFind;
    }

    public Fox find2(String name) {
        Fox foxToFind = null;
        for (Fox fox : foxes) {
            if (fox.getName().equalsIgnoreCase(name)) {
                foxToFind = fox;
            } else {
                foxToFind = new Fox(name);
                add2(foxToFind);
            }
        }
        return foxToFind;
    }*/

    public void changeFood(String food, String name) {
        find(name).setFood(food);
    }

    public void changeDrink(String drink, String name) {
        find(name).setDrink(drink);
    }

    public void addNewTrick(String trick, String name) {
        find(name).setTricks(trick);
    }

    public List<Tricks> learnableTricks() {
        return Arrays.asList(Tricks.values());
    }

    public List<Food> listOfFood() {
        return Arrays.asList(Food.values());
    }

    public List<Drink> drinks() {
        return Arrays.asList(Drink.values());
    }
}

