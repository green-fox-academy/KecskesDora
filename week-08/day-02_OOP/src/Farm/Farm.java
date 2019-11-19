package Farm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Farm {

    ArrayList<Animal> farm;
    int slot;

    public Farm(){
        farm = new ArrayList<>();
        slot = 5;
    }

    public void add(Animal animal){
        farm.add(animal);
        slot--;
    }

    public void breed(Animal animal) {
        if ( 0 < slot && slot < 11) {
            farm.add(animal);
            slot--;
        } else {
            System.out.println("There is no slot for new animals.");
        }
    }

    public void slaughter(){
        HashMap<Integer, Integer> animalHungerMap = new HashMap<>();

        for (int i = 0; i < farm.size(); i++) {
            animalHungerMap.put(i, farm.get(i).hungerValue);
        }
        int killIndex = 0;
        for(Map.Entry<Integer, Integer> animalHungerValue : animalHungerMap.entrySet()) {

            if (animalHungerValue.getValue() == Collections.min(animalHungerMap.values())) {
                killIndex = animalHungerValue.getKey();
            }
        }
        farm.remove(killIndex);

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
        for (int i = 1; i < farm.size(); i++) {
            if (farm.get(killIndex).hungerValue > farm.get(i).hungerValue) {
                killIndex = i;
            }
        }
        slot++;
        farm.remove(killIndex);
    }

    @Override
    public String toString() {
        String result = "";
        for(int i = 0; i < farm.size(); i++) {
            result += farm.get(i) + " ";
        }
        return result;
    }
}
