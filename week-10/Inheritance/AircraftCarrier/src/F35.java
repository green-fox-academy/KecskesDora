public class F35 extends Aircraft {

    public F35() {
        super();
        super.setMaxAmmoLevel(12);
        super.setBaseDamage(50);
        super.setPriority(true);
    }

    public boolean isPriority() {
        return true;
    }
}
