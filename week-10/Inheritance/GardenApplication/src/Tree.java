//The Tree
//needs water if its current water amount is less then 10
//when watering it the tree can only absorb the 40% of the water
//eg. watering with 10 the tree's amount of water should only increase with 4

public class Tree extends Plant {

    public Tree(String color) {
        super(color);
    }

    public void water(int waterAmount) {
        setCurrentWaterAmount(getCurrentWaterAmount() + waterAmount * 0.4);
        state();
    }

    public void state() {
        if (this.getCurrentWaterAmount() < 10) {
            System.out.printf("\nThe %s Tree needs water", getColor());
        } else {
            System.out.printf("\nThe %s Tree doesn't need water", getColor());
        }
    }
}



