public class F16 extends Aircraft {

    public F16(String name) {
        super(name);
        super.setMaxAmmoLevel(8);
        super.setBaseDamage(30);
        super.setPriority(false);
    }
}
