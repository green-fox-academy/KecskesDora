package com.greenfoxacademy.programmerfoxclub.models;

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

    @Override
    public String toString() {
        return name;
    }
}
