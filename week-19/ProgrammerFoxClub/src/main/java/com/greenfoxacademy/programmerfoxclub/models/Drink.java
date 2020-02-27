package com.greenfoxacademy.programmerfoxclub.models;

public enum Drink {
    WATER("water"),
    BLOOD("blood"),
    MILK("milk");

    public final String name;

    Drink(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
