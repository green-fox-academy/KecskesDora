package main.java.animals;

public class Bird extends Animal{

    public Bird (String name){
        super(name);
    }

    @Override
    public String breed() {
        return "laying eggs";
    }

    @Override
    public String sound() {
        return "chip-chip";
    }

    @Override
    public String move() {
        return "fly";
    }
}