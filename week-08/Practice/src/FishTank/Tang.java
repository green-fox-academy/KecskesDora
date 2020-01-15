package FishTank;

public class Tang extends Fish{
    private static boolean shortTermMemoryLoss = true;
    private static int weightGainsWhenFed = 1;

    public Tang(String name, int weight, String color) {
        super(name, weight, weightGainsWhenFed, color, shortTermMemoryLoss);
    }

    @Override
    public void feed() {
        increaseWeight(weightGainsWhenFed);
    }
}
