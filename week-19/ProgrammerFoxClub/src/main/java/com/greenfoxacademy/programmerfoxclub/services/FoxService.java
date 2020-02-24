package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Fox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FoxService {
    private List<Fox> foxes;

    private FoxService() {
        foxes = new ArrayList<>();
        foxes.add(new Fox("Vuk", Arrays.asList("running", "jumping"), "duck", "water"));
        foxes.add(new Fox("Csele", Arrays.asList("running", "jumping"), "chicken", "water"));
        foxes.add(new Fox("Karak"));
    }

    public void add(Fox newFox) {
        foxes.add(newFox);
    }

    public boolean check(String name) {
        for (Fox fox : foxes) {
            if (fox.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
