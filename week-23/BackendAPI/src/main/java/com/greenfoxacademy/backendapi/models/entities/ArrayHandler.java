package com.greenfoxacademy.backendapi.models.entities;

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

    public int sumElements() {
        int sum = 0;
        for (int element : numbers) {
            sum += element;
        }
        return sum;
    }

    public int multiplyElements() {
        int multiplication = 1;
        for (int element : numbers) {
            multiplication *= element;
        }
        return multiplication;
    }

    public int[] doubleElements() {
        int[] doubled = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            doubled[i] = numbers[i] * 2;
        }
        return doubled;
    }
}

