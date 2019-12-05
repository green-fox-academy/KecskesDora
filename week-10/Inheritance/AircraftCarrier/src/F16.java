public class F16 extends Aircraft {

    public F16() {
        super();
        maxAmmoLevel = 8;
        baseDamage = 30;
    }

    public void setMaxAmmolevel(){
        super.setMaxAmmoLevel();
    }

    public boolean isPriority() {
        return super.isPriority();
    }
}
