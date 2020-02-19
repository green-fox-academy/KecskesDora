package com.greenfoxacademy.bankofsymba.models;

public class BankAccount {
    private String name;
    private Integer balance;
    private String animalType;
    private Boolean isKing;
    private Boolean isGood;


    public BankAccount() {
    }

    public BankAccount(String name, Integer balance, String animalType, Boolean isKing, Boolean isGood) {
        this.name = name;
        this.balance = balance;
        this.animalType = animalType;
        //this.isKing = isKing == null ? false: true;
        //this.isGood = isGood == null ? false: true;
        this.isKing = isKing;
        this.isGood = isGood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public boolean getIsKing() {
        return isKing;
    }

    public void setIsKing(boolean king) {
        isKing = king;
    }

    public boolean getIsGood() {
        return isGood;
    }

    public void setIsGood(boolean good) {
        isGood = good;
    }
}
