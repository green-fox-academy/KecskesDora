//The Garden
//is able to hold unlimited amount of flowers or trees
//when watering it should only water those what needs water with equally divided amount amongst them
//eg. watering with 40 and 4 of them need water then each gets watered with 10

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
        System.out.printf("\nWatering with %d\n", waterAmount);

        int needWaterCounter = 0;

        for (Plant plant : listOfPlants) {
            if (plant.getIsThirsty())
                needWaterCounter++;
        }

        for (Plant plant : listOfPlants) {
            plant.water(waterAmount / needWaterCounter);
        }
    }

    public void state(){
        for (Plant plant : listOfPlants) {
            plant.state();
        }
    }
}
