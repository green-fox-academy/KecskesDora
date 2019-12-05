public class Plant {
    private String color;
    private double currentWaterAmount;
    private double absorptionLevel;
    private int thirstyLevel;
    private boolean isThirsty;

    public Plant(String color) {
        this.color = color;
        currentWaterAmount = 0;
        isThirsty = true;
    }

    public String getColor() {
        return this.color;
    }

    public void setCurrentWaterAmount(double newWaterAmount) {
        this.currentWaterAmount = newWaterAmount;
    }

    public void setAbsorptionLevel(double absorptionLevel) {
        this.absorptionLevel = absorptionLevel;
    }

    public void setThirstyLevel(int thirstyLevel) {
        this.thirstyLevel = thirstyLevel;
    }

    public boolean getIsThirsty() {
        return isThirsty;
    }

    public void setIsThirsty() {
        if(currentWaterAmount < thirstyLevel) {
            isThirsty = true;
        } else {
            isThirsty = false;
        }
    }

    public void water(int waterAmount) {
        setCurrentWaterAmount(currentWaterAmount + waterAmount * absorptionLevel);
        setIsThirsty();
        state();
    }

    public void state() {
        if (getIsThirsty()) {
            System.out.printf("The %s %s needs water.\n", getColor(), getClass().getSimpleName());
        } else {
            System.out.printf("The %s %s doesn't need water.\n", getColor(), getClass().getSimpleName());
        }
    }
}
