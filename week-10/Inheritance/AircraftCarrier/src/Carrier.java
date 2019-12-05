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

    public void addAircraft(Aircraft aircraft){
        this.listOfAircrafts.add(aircraft);
    }

    public void fill(int ammo){


    }
}
