package AnimalProtection;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
    private int budget;
    private List<Animal> animals;
    private List<String> adoptersName;

    public AnimalShelter(){
        budget = 50;
        animals = new ArrayList<>();
        adoptersName = new ArrayList<>();
    }

    public int rescue(Animal animal) {
        animals.add(animal);
        return animals.size();
    }

    public int heal() {
        for (Animal animal : animals) {
            if (!animal.getIsHealthy() && budget >= animal.getHealCost()) {
                   animal.heal();
                   budget -= animal.getHealCost();
                   return 1;
               }
            }
        return 0;
    }

    public void addAdopter(String name) {
        adoptersName.add(name);
    }

    public String findNewOwner() {
        int randomAdoptersIndex = (int) (Math.random() * adoptersName.size());
        String newPair = adoptersName.get(randomAdoptersIndex) + " - ";
        adoptersName.remove(randomAdoptersIndex);

        Animal randomAnimal;
        do {
            randomAnimal = animals.get((int) (Math.random() * animals.size()));
            if (randomAnimal.isAdoptable()) {
            newPair += randomAnimal.getName();
            animals.remove(randomAnimal);
            }
        }
        while (!randomAnimal.isAdoptable());
        return newPair;
    }

    public int earnDonation(int amount) {
        budget += amount;
        return budget;
    }

    public String toString() {

        String result = String.format("Budget: %d €\nThere are %d animal(s) and %d potential adopters\n", budget, animals.size(), adoptersName.size());
        for (Animal animal : animals) {
            result += animal.toString();
        }
        return result;
    }
}
