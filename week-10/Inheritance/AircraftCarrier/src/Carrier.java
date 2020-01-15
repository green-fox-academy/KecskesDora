//Create a class that represents an aircraft-carrier
//
//The carrier should be able to store aircrafts
//Each carrier should have a store of ammo represented as number
//The initial ammo should be given by a parameter in its constructor
//The carrier also has a health point given in its constructor as well

import java.util.ArrayList;
import java.util.Collections;

public class Carrier{

    private ArrayList<Aircraft> aircrafts;
    private int storeOfAmmo;
    private int healthPoint;

    public Carrier(int storeOfAmmo, int healthPoint) {
        aircrafts = new ArrayList<>();
        this.storeOfAmmo = storeOfAmmo;
        this.healthPoint = healthPoint;
    }

    public void add(Aircraft aircraft) {
        aircrafts.add(aircraft);
    }

    public void fill() throws StoreOfAmmoIsEmptyException {
        //It should fill all the aircraft with ammo and subtract the needed ammo from the ammo storage
        //If there is not enough ammo then it should start to fill the aircrafts with priority first
        //If there is no ammo when this method is called, it should throw an exception

        Collections.sort(aircrafts);

        for (Aircraft aircraft : aircrafts) {
            storeOfAmmo = aircraft.refill(storeOfAmmo);
        }
            if (storeOfAmmo == 0) {
                throw new StoreOfAmmoIsEmptyException();
        }
    }

    public void fight(Carrier otherCarrier) {
        //It should take another carrier as a reference parameter and fire all the ammo from the aircrafts to it,
        // then subtract all the damage from its health points
        otherCarrier.healthPoint -= getAllDamage();
        for (Aircraft aircraft : aircrafts) {
            aircraft.fight();
        }
    }

    public int getAllDamage() {
        int allDamage = 0;
        for (Aircraft aircraft : aircrafts) {
            allDamage += aircraft.getDealtDamage();
        }
        return allDamage;
    }

    public String getStatus() {
        if (healthPoint <= 0) {
            return "It's dead Jim :(";
        } else {
            String carrierStatus = "HP: " + healthPoint + ", Aircraft count: " + aircrafts.size() + ", Ammo Storage: " + storeOfAmmo + ", Total damage: " + getAllDamage();
            String aircraftStatus = "\nAircrafts:\n";
            for (Aircraft aircraft : aircrafts) {
                aircraftStatus += aircraft.getStatus() + "\n";
            }
            return carrierStatus + aircraftStatus;
        }
    }


}