package Animal;

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
//Create an Animal class
//Every animal has a hunger value, which is a whole number
//Every animal has a thirst value, which is a whole number
//when creating a new animal object these values are created with the default 50 value

//Every animal can eat() which decreases their hunger by one
//Every animal can drink() which decreases their thirst by one
//Every animal can play() which increases both by one