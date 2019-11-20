package Farm;

public class Animal {
    public String type;
    public int hungerValue;
    public int thirstValue;

    /*public Animal () {
        this.hungerValue = 50;
        this.thirstValue = 50;
    }*/

    public Animal (String type) {
        this.type = type;
        this.hungerValue = 50;
        this.thirstValue = 50;
    }

    public void eat() {
        hungerValue --;
    }

    public void drink() {
        thirstValue --;
    }

    public void play() {
        hungerValue ++;
        thirstValue ++;
    }
    @Override
    public String toString() {
        return type;
    }
}