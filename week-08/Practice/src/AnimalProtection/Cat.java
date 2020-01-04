package AnimalProtection;

public class Cat extends Animal{

    public Cat() {
        super();
        int healCost = (int) (Math.random() * 7);
        super.setHealCost(healCost);
    }
}
