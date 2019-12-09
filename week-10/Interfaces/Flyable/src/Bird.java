public class Bird extends Animal implements Flyable{

    public Bird (String name){
        super(name);
    }


    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }

    @Override
    public void takeOff() {

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