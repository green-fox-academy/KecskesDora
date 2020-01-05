package AnimalProtection;

public class Animal {
    private String name;
    private String ownerName;
    private boolean isHealthy;
    private int healCost;

    public Animal(String name){
        this.name = name;
    }

    public void heal() {
        isHealthy = true;
    }

    public boolean isAdoptable() {
        return isHealthy;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(isHealthy? " is healthy " : " is not healthy ");
        builder.append("(healing would cost: " + healCost + " €) and");
        builder.append(isAdoptable()? " adoptable\n" : " not adoptable\n");
        return builder.toString();
    }

    public boolean getIsHealthy() {
        return isHealthy;
    }

    public int getHealCost() {
        return healCost;
    }

    public void setHealCost(int healCost) {
        this.healCost = healCost;
    }

    public String getName() {
        return name;
    }
}
