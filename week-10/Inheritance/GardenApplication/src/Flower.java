//The Flower
//needs water if its current water amount is less then 5
//when watering it the flower can only absorb the 75% of the water
//eg. watering with 10 the flower's amount of water should only increase with 7.5

public class Flower extends Plant {

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
