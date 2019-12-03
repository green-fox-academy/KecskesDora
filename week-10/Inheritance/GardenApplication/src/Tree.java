public class Tree extends Plant {

    public Tree() {
        super();
    }

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



