package AnimalProtection;

import java.util.ArrayList;
import java.util.List;

public class AnimalShelter {
    private int budget;
    private List<Animal> animals;
    private List<String> adopters;

    public AnimalShelter(){
        int budget = 50;
        animals = new ArrayList<>();
        adopters = new ArrayList<>();
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
        adopters.add(name);
    }

    public String findNewOwner() {
        int randomAdoptersIndex = (int) (Math.random() * adopters.size());

        List<Animal> healthyAnimals = new ArrayList<>();
        for (Animal animal : animals) {
            if (animal.isAdoptable()) {
                healthyAnimals.add(animal);
            }
        }
        int randomAnimalsIndex = (int) (Math.random() * healthyAnimals.size());
        Animal randomAnimal = healthyAnimals.get(randomAnimalsIndex);
        randomAnimal.setOwnerName(adopters.get(randomAdoptersIndex));

        animals.remove(randomAnimal);
        adopters.remove(randomAdoptersIndex);

        return randomAnimal.getOwnerName() + " - " + randomAnimal.getClass().getSimpleName();
    }

    public int earnDonation(int amount) {
        budget += amount;
        return budget;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("There are " + animals.size() + " animal(s) and " + adopters.size() + " potential adopters\n");
        for (Animal animal : animals) {
            builder.append(animal.toString());
        }
        return builder.toString();
    }
}
