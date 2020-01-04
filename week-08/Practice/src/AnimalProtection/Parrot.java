package AnimalProtection;

public class Parrot extends Animal{

    public Parrot() {
        super();
        int healCost = (int) (Math.random() * 7 + 4);
        super.setHealCost(healCost);
    }
}
