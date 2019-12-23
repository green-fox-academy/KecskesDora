//Create a class that represents an aircraft-carrier
//
//The carrier should be able to store aircrafts
//Each carrier should have a store of ammo represented as number
//The initial ammo should be given by a parameter in its constructor
//The carrier also has a health point given in its constructor as well

import java.util.ArrayList;

public class Carrier {

    private ArrayList<Aircraft> listOfAircraft;
    private int storeOfAmmo;
    private int healthPoint;

    public Carrier(int storeOfAmmo, int healthPoint) {
        this.listOfAircraft = new ArrayList<>();
        this.storeOfAmmo = storeOfAmmo;
        this.healthPoint = healthPoint;
    }

    public void add(Aircraft aircraft) {
        listOfAircraft.add(aircraft);
    }

    public void fill() throws StoreOfAmmoIsEmptyException {
        //It should fill all the aircraft with ammo and subtract the needed ammo from the ammo storage
        //If there is not enough ammo then it should start to fill the aircrafts with priority first
        //If there is no ammo when this method is called, it should throw an exception

                for (Aircraft aircraft : listOfAircraft) {
                    if (aircraft.getPriority()) {
                        storeOfAmmo -= aircraft.getNeededAmmo();
                        aircraft.refill(aircraft.getNeededAmmo());
                    }
                }
                for (Aircraft aircraft : listOfAircraft) {
                    if (!aircraft.getPriority()) {
                        storeOfAmmo -= aircraft.getNeededAmmo();
                        aircraft.refill(aircraft.getNeededAmmo());
                    }
                }
            if (storeOfAmmo == 0) {
            throw new StoreOfAmmoIsEmptyException();
            }
    }

    public void fight(Carrier otherCarrier) {
        //It should take another carrier as a reference parameter and fire all the ammo from the aircrafts to it,
        // then subtract all the damage from its health points
        for (Aircraft aircraft : listOfAircraft) {
            aircraft.fight();
            otherCarrier.healthPoint -= getAllDamage();
        }
    }

    public int getAllDamage() {
        int allDamage = 0;
        for (Aircraft aircraft : listOfAircraft) {
            allDamage += aircraft.getDealtDamage();
        }
        return allDamage;
    }

    public String getStatus() {
        if (healthPoint <= 0) {
            return "It's dead Jim :(";
        } else {
            String carrierStatus = "HP: " + healthPoint + ", Aircraft count: " + listOfAircraft.size() + ", Ammo Storage: " + storeOfAmmo + ", Total damage: " + getAllDamage();
            String aircraftStatus = "\nAircrafts:\n";
            for (Aircraft aircraft : listOfAircraft) {
                aircraftStatus += aircraft.getStatus() + "\n";
            }
            return carrierStatus + aircraftStatus;
        }
    }
}