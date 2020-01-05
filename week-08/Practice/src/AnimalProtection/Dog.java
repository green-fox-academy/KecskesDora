package AnimalProtection;

public class Dog extends Animal{

    public Dog(String name) {
        super(name);
        int healCost = (int) (Math.random() * 8 + 1);
        super.setHealCost(healCost);
    }
}
