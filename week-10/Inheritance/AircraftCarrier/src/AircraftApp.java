public class AircraftApp {
    public static void main(String[] args) {
        Carrier queenElizabeth = new Carrier(200, 2000);
        Carrier juanCarlos = new Carrier(300, 2500);

        queenElizabeth.add(new F16());
        queenElizabeth.add(new F16());
        queenElizabeth.add(new F16());
        queenElizabeth.add(new F35());
        queenElizabeth.add(new F35());
        queenElizabeth.add(new F35());

        try {
            queenElizabeth.fill();
        } catch (StoreOfAmmoIsEmptyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(queenElizabeth.getStatus());
        }

        juanCarlos.add(new F16());
        juanCarlos.add(new F16());
        juanCarlos.add(new F16());
        juanCarlos.add(new F35());
        juanCarlos.add(new F35());
        juanCarlos.add(new F35());
        juanCarlos.add(new F35());

        try {
            juanCarlos.fill();
        } catch (StoreOfAmmoIsEmptyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(juanCarlos.getStatus());
        }

        queenElizabeth.fight(juanCarlos);
        System.out.println("After fight1");
        System.out.println(queenElizabeth.getStatus());
        System.out.println(juanCarlos.getStatus());

        juanCarlos.fight(queenElizabeth);
        System.out.println("After fight2");
        System.out.println(queenElizabeth.getStatus());
        System.out.println(juanCarlos.getStatus());

        try {
            juanCarlos.fill();
        } catch (StoreOfAmmoIsEmptyException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(juanCarlos.getStatus());
        }
    }
}
