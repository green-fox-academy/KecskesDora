package FishTank;

public class Kong extends Fish{
    private static boolean shortTermMemoryLoss = false;
    private static int weightGainsWhenFed = 2;

    public Kong(String name, int weight, String color) {
        super(name, 2, weightGainsWhenFed, color, shortTermMemoryLoss);
    }

    @Override
    public void feed() {
        increaseWeight(2);
    }
}
