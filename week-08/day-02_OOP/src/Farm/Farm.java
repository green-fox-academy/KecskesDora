package Farm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Farm {

    ArrayList<Animal> farm;
    int slot;

    public Farm(){
        farm = new ArrayList<>();
        slot = 10;
    }

    public void add(Animal animal){
        farm.add(animal);
    }

    public void breed(Animal animal) {
        if (slot > 0) {
            farm.add(animal);
        } else {
            System.out.println("There is no slot for new animals.");
        }
    }

    public void slaughter(){
        HashMap<Animal, Integer> animalHungerMap= new HashMap<>();
        for (int i = 0; i < farm.size(); i++) {
            animalHungerMap.put(farm.get(i), farm.get(i).hungerValue);
        }
        
        Collections.max(animalHungerMap.values());
        }
    }
}
