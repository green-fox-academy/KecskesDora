package AnimalProtection;

public class Cat extends Animal{

    public Cat(String name) {
        super(name);
        int healCost = (int) (Math.random() * 7);
        super.setHealCost(healCost);
    }
}
