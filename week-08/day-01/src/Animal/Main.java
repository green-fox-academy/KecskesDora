package Animal;

public class Main {
    public static void main(String[] args) {
        Animal cat = new Animal();
        Animal dog = new Animal();

        cat.eat();
        cat.drink();
        System.out.println(cat.hungerValue + cat.thirstValue);

        dog.play();
        System.out.println(dog.hungerValue + dog.thirstValue);
    }
}

