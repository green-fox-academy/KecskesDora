// Create a class that represents an aircraft
//There are 2 types of aircrafts: F16 and F35
//Both aircrafts should keep track of their ammunition
//F16
//Max ammo: 8
//Base damage: 30
//F35
//Max ammo: 12
//Base damage: 50
//All aircrafts should be created with an empty ammo storage

public class Aircraft implements Comparable<Aircraft>{

    private int ammoLevel;
    private int maxAmmoLevel;
    private int baseDamage;
    private boolean isPriority;

    public Aircraft(){
        ammoLevel = 0;
    }

    public void setMaxAmmoLevel(int maxAmmoLevel) {
        this.maxAmmoLevel = maxAmmoLevel;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public int fight(){
        //It should use all the ammo (set it to 0) and it should return the damage it deals
        //The damage dealt is calculated by multiplying the base damage by the ammunition

        int damageDealt = getDealtDamage();
        ammoLevel = 0;
        return damageDealt;
    }

    public int refill(int ammo){
        //It should take a number as parameter and subtract as much ammo as possible
        //It can't have more ammo than the number or the max ammo
        // (can't get more ammo than what's coming from the parameter or the max ammo of the aircraft)
        //It should return the remaining ammo
        //Eg. Filling an empty F35 with 300 would completely fill the storage of the aircraft and would return the remaining 288

        if (ammo > getNeededAmmo()) {
            ammo -= getNeededAmmo();
            ammoLevel = maxAmmoLevel;
            return ammo;
        } else {
            ammoLevel += ammo;
            return 0;
        }
    }

    public String getStatus() {
        return String.format("Type: %s, Ammo: %d, Base Damage: %d, All Damage: %d", getType(), ammoLevel, baseDamage, getDealtDamage());
    }

    public String getType(){
        return getClass().getSimpleName();
    }

    public boolean getPriority(){
        return isPriority;
    }

    public void setPriority(boolean isPriority) {
        this.isPriority = isPriority;
    }

    public int getNeededAmmo() {
        return maxAmmoLevel - ammoLevel;
    }

    public int getDealtDamage() {
        return baseDamage * ammoLevel;
    }

    @Override
    public int compareTo(Aircraft otherAircraft) {
        return Boolean.compare(this.isPriority, otherAircraft.isPriority);
    }
}
