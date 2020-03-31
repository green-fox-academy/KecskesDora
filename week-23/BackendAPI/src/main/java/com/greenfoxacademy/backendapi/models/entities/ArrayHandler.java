package com.greenfoxacademy.backendapi.models.entities;

import java.util.Arrays;

public class ArrayHandler {
    private String what;
    private int[] numbers;

    public ArrayHandler(String what, int[] numbers) {
        this.what = what;
        this.numbers = numbers;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }



    @Override
    public String toString () {
        return "{" +
                "what: " + what +
                ", numbers: " + Arrays.toString(numbers) +
                "}";
    }
}

