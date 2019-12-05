public class Aircraft {

    public int ammoLevel;
    public int maxAmmoLevel;
    public int baseDamage;

    public Aircraft(){
        this.ammoLevel = 0;
    }

    public int refill(int ammo){
        int remainingAmmo = 0;
        if (ammo > this.maxAmmoLevel - this.ammoLevel) {
            remainingAmmo = ammo - (this.maxAmmoLevel - this.ammoLevel);
            this.ammoLevel = this.maxAmmoLevel;
        } else if (ammo <= this.maxAmmoLevel - this.ammoLevel) {
            this.ammoLevel += ammo;
            remainingAmmo = 0;
        }
        return remainingAmmo;
    }

    public int fight(Aircraft otherAircraft){
        int damageDealt = 0;
        damageDealt = this.baseDamage * this.ammoLevel;
        this.ammoLevel = 0;
        return damageDealt;
    }

    public void setMaxAmmoLevel() {
        if (this.ammoLevel < 0 || this.ammoLevel > this.maxAmmoLevel) return;
    }

    public int getAmmoLevel() {
         return this.ammoLevel;
    }

    public String getType() {
        String typeName = this.getClass().getSimpleName();
        return typeName;
    }

    public String getStatus() {
        String status = "Type: " + this.getClass().getSimpleName() + ", Ammo: "
                + this.ammoLevel + ", Base Damage: " + this.baseDamage
                + ", All Damage: " + this.baseDamage * this.ammoLevel;
        return status;
    }

    public boolean isPriority() {
        return false;
    }
}
