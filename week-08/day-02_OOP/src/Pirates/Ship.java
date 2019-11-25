package Pirates;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    List<Pirate> ship;

    public Ship() {
       ship = new ArrayList<>();
    }

    public void fillShip() {
        Pirate captain = new Pirate("captain");
        ship.add(0, captain);

        Pirate pirate = new Pirate();
        for (int i = 1; i < (int)(Math.random() * 100); i++) {
            ship.add(i, pirate);
        }
    }

    public void shipsState() {
        System.out.println("Captain consumed " + ship.get(0).toxicLevel + " pint rum.");

        if (ship.get(0).isAlive == true) {
            if (ship.get(0).passedOut == true) {
                System.out.println("Captain passed out.");
            } else {
                System.out.println("Captain is awake");
            }
        } else {
            System.out.println("Captain is dead.");
        }
    }

    public int alivePiratesCounter() {
        int aliveCounter = 0;
        for (int i = 1; i < ship.size(); i++) {
            if (ship.get(i).isAlive == true) {
                aliveCounter++;
            }
        }
        //System.out.println(aliveCounter + " pirates is alive in the crew");
        return aliveCounter;
    }

    public void battle(Ship othership) {

        if (alivePiratesCounter(this.ship) - this.ship.get(0).toxicLevel)
    }
}
