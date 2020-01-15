package FishTank;

public abstract class Fish{
    private String name;
    private int weight;
    private int weightGainsWhenFed;
    private String color;
    private boolean shortTermMemoryLoss;

    public Fish(String name, int weight, int weightGainsWhenFed, String color, Boolean shortTermMemoryLoss) {
        this.name = name;
        this.weight = weight;
        this.weightGainsWhenFed = weightGainsWhenFed;;
        this.color = color;
        this.shortTermMemoryLoss = shortTermMemoryLoss;
    }

    public abstract void feed();

    public void increaseWeight(int weight) {
        this.weight += weight;
    }

    public int getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return String.format("%s, weight: %d, color: %s, short-term memory loss: %b\n", name, weight, color, shortTermMemoryLoss);
    }

    public void getStatus() {
        System.out.println(this);
    }
}
