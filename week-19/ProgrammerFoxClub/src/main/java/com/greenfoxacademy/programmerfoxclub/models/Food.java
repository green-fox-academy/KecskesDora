package com.greenfoxacademy.programmerfoxclub.models;

public enum Food {
    DUCK("duck"),
    CHICKEN("chicken"),
    GOOSE("goose"),
    HAHN("hahn");

    public final String name;

    Food(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
