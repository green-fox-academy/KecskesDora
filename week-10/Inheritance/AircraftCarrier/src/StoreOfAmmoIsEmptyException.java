public class StoreOfAmmoIsEmptyException extends NullPointerException {

    public StoreOfAmmoIsEmptyException() {
        super("Store of ammo is empty, you can't fill any of your aircrafts.");
    }
}
