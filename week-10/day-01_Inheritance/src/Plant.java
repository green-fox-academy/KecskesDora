public class Plant {
    private String color;
    private double currentWaterAmount;
    private boolean needWater;

    public Plant() {

    }

    public Plant(String color) {
        this.color = color;
        this.currentWaterAmount = 0;
    }

    public double getCurrentWaterAmount() {
        return this.currentWaterAmount;
    }

    public void setCurrentWaterAmount(double newWaterAmount) {
        this.currentWaterAmount = newWaterAmount;
    }

    public String getColor() {
        return this.color;
    }
}
