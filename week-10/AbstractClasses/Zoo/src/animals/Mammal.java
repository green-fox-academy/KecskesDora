package animals;

public class Mammal extends Animal {

    public Mammal(String name) {
        super(name);
    }

    @Override
    public String breed() {
        return "pushing miniature versions out";
    }

    @Override
    public String sound() {
        return "moew, oink or whatever";
    }

    @Override
    public String move() {
        return "walk";
    }
}