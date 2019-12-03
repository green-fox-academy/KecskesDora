public class Flower extends Plant {

    public Flower() {
        super();
    }

    public Flower(String color) {
        super(color);
    }

    public void water(int waterAmount) {
        setCurrentWaterAmount(getCurrentWaterAmount() + waterAmount * 0.75);
        state();
    }

    public void state() {
        if (this.getCurrentWaterAmount() < 5) {
            System.out.printf("\nThe %s Flower needs water", getColor());
        } else {
            System.out.printf("\nThe %s Flower doesn't need water", getColor());
        }
    }
}
