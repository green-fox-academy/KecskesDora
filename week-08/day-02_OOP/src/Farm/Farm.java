package Farm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Farm {

    ArrayList<Animal> listOfAnimals;
    int slot;

    public Farm(){
        listOfAnimals = new ArrayList<>();
        slot = 5;
    }
    public void add(Animal animal){
        listOfAnimals.add(animal);
    }

    public void breed(String type) {
        Animal newAnimal = new Animal(type);
        if ( 0 < slot && slot < 11) {
            listOfAnimals.add(newAnimal);
            slot--;
        } else {
            System.out.println("There is no slot for new animals.");
        }
    }

    public void slaughter(){
        HashMap<Integer, Integer> animalHungerMap = new HashMap<>();

        for (int i = 0; i < listOfAnimals.size(); i++) {
            animalHungerMap.put(i, listOfAnimals.get(i).hungerValue);
        }
        int killIndex = 0;
        for(Map.Entry<Integer, Integer> animalHungerValue : animalHungerMap.entrySet()) {

            if (animalHungerValue.getValue() == Collections.min(animalHungerMap.values())) {
                killIndex = animalHungerValue.getKey();
            }
        }
        listOfAnimals.remove(killIndex);

        slot++;
        //System.out.println(animalHungerMap);
    }

    /*public void slaughter3() {
        Animal temp;
        for (int i = 0; i < farm.size(); i++) {
            for (int j = i + 1; j < farm.size(); j++) {
               if (farm.get(i).hungerValue < farm.get(j).hungerValue) {
                   temp = farm.get(i);
                   farm.get(i)= farm.get(j);
                   farm.get(j) = temp;
               }
            }
        }
    }*/

    public void slaughter2() {
        int killIndex = 0;
        for (int i = 1; i < listOfAnimals.size(); i++) {
            if (listOfAnimals.get(killIndex).hungerValue > listOfAnimals.get(i).hungerValue) {
                killIndex = i;
            }
        }
        slot++;
        listOfAnimals.remove(killIndex);
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < listOfAnimals.size(); i++) {
            result += listOfAnimals.get(i) + " ";
        }
        return result;
    }
}
