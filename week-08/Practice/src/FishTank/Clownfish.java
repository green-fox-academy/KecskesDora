package FishTank;

public class Clownfish extends Fish{
    private String colorOfStripes;
    private static boolean shortTermMemoryLoss = false;
    private static int weightGainsWhenFed = 1;

    public Clownfish(String name, int weight) {
        super(name, weight, weightGainsWhenFed, "orange", shortTermMemoryLoss);
    }

    @Override
    public void feed() {
        increaseWeight(1);
    }
}
