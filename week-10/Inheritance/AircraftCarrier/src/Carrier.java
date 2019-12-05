//Create a class that represents an aircraft-carrier
//
//The carrier should be able to store aircrafts
//Each carrier should have a store of ammo represented as number
//The initial ammo should be given by a parameter in its constructor
//The carrier also has a health point given in its constructor as well

import java.util.ArrayList;

public class Carrier {

    public ArrayList<Aircraft> listOfAircrafts;
    public int storeOfAmmo;
    public int healthPoint;

    public Carrier(int storeOfAmmo, int healthPoint) {
        this.listOfAircrafts = new ArrayList<>();
        this.storeOfAmmo = storeOfAmmo;
        this.healthPoint = healthPoint;
    }

    public void addAircraft(Aircraft aircraft) {
        this.listOfAircrafts.add(aircraft);
    }

    public void fill() throws StoreOfAmmoIsEmptyException {
        //It should fill all the aircraft with ammo and subtract the needed ammo from the ammo storage
        // If there is not enough ammo then it should start to fill the aircrafts with priority first
        //If there is no ammo when this method is called, it should throw an exception

        if (storeOfAmmo == 0) {
            throw new StoreOfAmmoIsEmptyException();
        } else {
            if (this.getNeededAmmo() <= storeOfAmmo) {
                for (Aircraft aircraft : listOfAircrafts) {
                    aircraft.refill(aircraft.neededAmmo);
                }
                storeOfAmmo -= this.getNeededAmmo();
            } else {
                while (storeOfAmmo > 0) {
                    for (Aircraft aircraft : listOfAircrafts) {
                        if (aircraft.isPriority) {
                            aircraft.refill(storeOfAmmo);
                        } //NOT FINISHED!!!
                    }
                }
            }
        }
    }

    public int getNeededAmmo() {
        int allNeededAmmo = 0;
        for (Aircraft aircraft : listOfAircrafts) {
            allNeededAmmo += aircraft.neededAmmo;
        }
        return allNeededAmmo;
    }

    public void fight(Carrier otherCarrier) {
        //It should take another carrier as a reference parameter and fire all the ammo from the aircrafts to it,
        // then subtract all the damage from its health points

        otherCarrier.healthPoint -= getAllDamage();
    }

    public int getAllDamage() {
        int allDamage = 0;
        for (Aircraft aircraft : listOfAircrafts) {
            allDamage += aircraft.fight();
        }
        return allDamage;
    }

    public String getStatus() {
        if (healthPoint == 0) {
            return "It's dead Jim :(";
        } else {
            String status = "HP: " + healthPoint + ", Aircraft count: " + listOfAircrafts.size() + ", Ammo Storage: " + storeOfAmmo + ", Total damage: " + getAllDamage();
            status += "\nAircrafts:\n";
            for (Aircraft aircraft : listOfAircrafts) {
                status += aircraft.getStatus();
            }
            return status;
        }
    }
}