package AnimalProtection;

public class Parrot extends Animal{

    public Parrot(String name) {
        super(name);
        int healCost = (int) (Math.random() * 7 + 4);
        super.setHealCost(healCost);
    }
}
