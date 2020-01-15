package FishTank;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishes;

    public Aquarium() {
        fishes = new ArrayList<>();
    }

    public void addFish(Fish newFish) {
        fishes.add(newFish);
    }

    public void feed() {
        for (Fish fish : fishes) {
            fish.feed();
        }
    }

    public void removeFish() {
        for (Fish fish : fishes) {
            if (fish.getWeight() >= 11) {
                fishes.remove(fish);
            }
        }
    }

    public void getStatus() {
        for (Fish fish : fishes) {
            fish.getStatus();
        }
    }
}
