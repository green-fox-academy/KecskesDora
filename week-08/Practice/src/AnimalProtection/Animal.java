package AnimalProtection;

public class Animal {
    private String ownerName;
    private boolean isHealthy;
    private int healCost;

    public Animal(){
    }

    public void heal() {
        isHealthy = true;
    }

    public boolean isAdoptable() {
        return isHealthy;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getClass().getSimpleName());
        builder.append(isHealthy? " is healthy " : " is not healthy ");
        builder.append("(healing would cost: " + healCost + " €) and");
        builder.append(isAdoptable()? " adoptable" : " not adoptable");
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

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
