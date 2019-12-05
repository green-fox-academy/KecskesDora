public class F35 extends Aircraft {

    public F35() {
        super();
        maxAmmoLevel = 12;
        baseDamage = 50;
    }

    public void setMaxAmmoLevel() {
        super.setMaxAmmoLevel();
    }

    public boolean isPriority() {
        return true;
    }
}
