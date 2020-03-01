package com.greenfoxacademy.programmerfoxclub.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public enum Tricks {
    RUNNING("running"),
    JUMPING("jumping"),
    SWIMMING("swimming"),
    HUNTING("hunting"),
    TEACHING("teaching");

    public final String name;

    Tricks(String name) {
        this.name = name;
    }

    public static List<String> getList() {
        List<Tricks> allTricks = new ArrayList<>(Arrays.asList(values()));
        List<String> stringTricks = allTricks.stream()
                .map(trick -> Objects.toString(trick, null))
                .collect(Collectors.toList());
        return stringTricks;
    }

    @Override
    public String toString() {
        return name;
    }
}
