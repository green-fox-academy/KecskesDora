import java.util.ArrayList;

public class Garden {
    private ArrayList<Plant> listOfPlants;

    public Garden() {
        this.listOfPlants = new ArrayList<>();
    }

    public void addPlant(Plant newPlant){
        listOfPlants.add(newPlant);
    }

    public void water(int waterAmount){
        System.out.printf("\nWatering with %d", waterAmount);
        int needWaterCounter = 0;
        for (Plant plant : listOfPlants) {
            if (plant instanceof Flower && plant.getCurrentWaterAmount() < 5) {
                needWaterCounter++;
            } else if (plant instanceof Tree && plant.getCurrentWaterAmount() < 10) {
                needWaterCounter++;
            }
        }
        for (Plant plant : listOfPlants) {
            if (plant instanceof Flower) {
                ((Flower) plant).water(waterAmount / needWaterCounter);
            } else if (plant instanceof Tree) {
                ((Tree) plant).water(waterAmount / needWaterCounter);
            }
        }
    }

    public void state(){
        for (Plant plant : listOfPlants) {
            if (plant instanceof Flower) {
                ((Flower) plant).state();
            } else if (plant instanceof Tree) {
                ((Tree) plant).state();
            }
        }
    }


    /*private ArrayList<Flower> flowers;
    private ArrayList<Tree> trees;

    public Garden(){
        this.flowers = new ArrayList<>();
        this.trees = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        this.flowers.add(flower);
    }

    public void addTree(Tree tree) {
        this.trees.add(tree);
    }*/
}
