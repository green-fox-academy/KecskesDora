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

    public int sum() {
        int counter = 0;
        for (int i = 1; i <= until ; i++) {
           counter += i;
        }
        return counter;
    }

    public int factor() {
        int factorial = 1;
        for (int i = 1; i <= until; i++) {
            factorial *= i;
        }
        return factorial;
    }
}