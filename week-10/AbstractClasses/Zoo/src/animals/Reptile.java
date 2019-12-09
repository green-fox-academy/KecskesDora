package animals;

public class Reptile extends Animal {

    public Reptile (String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "laying eggs";
    }

    @Override
    public String sound() {
        return "ssssssz";
    }

    @Override
    public String move() {
        return "craw";
    }
}