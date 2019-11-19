package Farm;

public class Animal {
    String name;
    int hungerValue;
    int thirstValue;

    public Animal () {
        this.name = null;
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
}