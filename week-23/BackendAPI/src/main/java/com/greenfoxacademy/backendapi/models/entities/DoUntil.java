package com.greenfoxacademy.backendapi.models.entities;

public class DoUntil {
    private int until;

    public DoUntil() {
    }

    public DoUntil(int number) {
        this.until = number;
    }

    public int getUntil() {
        return until;
    }

    public void setUntil(int until) {
        this.until = until;
    }

    @Override
    public String toString() {
        return "{" +
                "until: " + until +
                "}";
    }
}
