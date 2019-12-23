public class F35 extends Aircraft {

    public F35(String name) {
        super(name);
        super.setMaxAmmoLevel(12);
        super.setBaseDamage(50);
        super.setPriority(true);
    }
}
