package main.java.animals;

public abstract class Animal {
    private String name;
    private int age;
    private String gender;


    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    protected abstract String breed();

    protected abstract String sound();

    protected abstract String move();
}
