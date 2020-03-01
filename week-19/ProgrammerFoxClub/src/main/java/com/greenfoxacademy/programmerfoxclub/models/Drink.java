package com.greenfoxacademy.programmerfoxclub.models;

import java.util.Arrays;
import java.util.List;

public enum Drink {
    WATER("water"),
    BLOOD("blood"),
    MILK("milk");

    public final String name;

    Drink(String name) {
        this.name = name;
    }

    public static List<Drink> getList() {
        return Arrays.asList(values());
    }

    @Override
    public String toString() {
        return name;
    }
}
