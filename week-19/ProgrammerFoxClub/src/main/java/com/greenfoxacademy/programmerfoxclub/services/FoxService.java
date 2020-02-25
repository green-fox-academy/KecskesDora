package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class FoxService {
    private List<Fox> foxes;

    private FoxService() {
        foxes = new ArrayList<>();
        foxes.add(new Fox("Vuk", Arrays.asList("running", "jumping"), "duck", "water"));
        foxes.add(new Fox("Csele", Arrays.asList("running", "jumping"), "chicken", "water"));
        foxes.add(new Fox("Karak", "hahn", "water"));
    }

    public void add(String name) {
        foxes.add(new Fox(name));
    }

    public boolean check(String name) {
        for (Fox fox : foxes) {
            if (fox.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public Fox find(String name) {
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
}

