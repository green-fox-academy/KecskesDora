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

public class Aircraft {

    private int ammoLevel;
    private int maxAmmoLevel;
    private int baseDamage;
    private boolean isPriority;

    public Aircraft(){
        this.ammoLevel = 0;
    }

    public int getAmmoLevel() {
        return this.ammoLevel;
    }

    public void setAmmoLevel(int newAmmoLevel) {
        this.ammoLevel = newAmmoLevel;
    }

    public int getMaxAmmoLevel(){
        return this.maxAmmoLevel;
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
        int damageDealt = 0;
        damageDealt = getDealtDamage();
        this.ammoLevel = 0;
        return damageDealt;
    }

    public int refill(int ammo){
        //It should take a number as parameter and subtract as much ammo as possible
        //It can't have more ammo than the number or the max ammo
        // (can't get more ammo than what's coming from the parameter or the max ammo of the aircraft)
        //It should return the remaining ammo
        //Eg. Filling an empty F35 with 300 would completely fill the storage of the aircraft and would return the remaining 288

        int remainingAmmo = ammo;
        if (ammo > this.getNeededAmmo()) {
            remainingAmmo = ammo - this.getNeededAmmo();
            this.ammoLevel = this.maxAmmoLevel;
        } else {
            this.ammoLevel += ammo;
            remainingAmmo = 0;
        }
        return remainingAmmo;
    }

    public String getStatus() {
        //It should return a string like: Type F35, Ammo: 10, Base Damage: 50, All Damage: 500
        String status = "Type: " + getType() + ", Ammo: " + this.ammoLevel + ", Base Damage: " + this.baseDamage + ", All Damage: " + getDealtDamage();
        return status;
    }

    public String getType(){
        return this.getClass().getSimpleName();
    }

    public boolean getPriority(){
        return this.isPriority;
    }

    public void setPriority(boolean isPriority) {
        //It should return if the aircraft is priority in the ammo fill queue.
        // It's true for F35 and false for F16
        this.isPriority = isPriority;
    }

    public int getNeededAmmo() {
        return this.maxAmmoLevel - this.ammoLevel;
    }

    public int getDealtDamage() {
        return this.baseDamage * this.ammoLevel;
    }

}