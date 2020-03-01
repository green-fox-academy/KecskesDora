package com.greenfoxacademy.programmerfoxclub.models;

import java.util.Arrays;
import java.util.List;

public enum Food {
    DUCK("duck"),
    CHICKEN("chicken"),
    GOOSE("goose"),
    HAHN("hahn");

    public final String name;

    Food(String name) {
        this.name = name;
    }

    public static List<Food> getList() {
        return Arrays.asList(values());
    }

    @Override
    public String toString() {
        return name;
    }
}
