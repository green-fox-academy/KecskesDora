public class AircraftApp {
    public static void main(String[] args) {
        Carrier queenElizabeth = new Carrier(200, 2000);
        Carrier juanCarlos = new Carrier(300, 2500);

        queenElizabeth.add(new F16("eagle"));
        queenElizabeth.add(new F16("sparrow"));
        queenElizabeth.add(new F35("hawk"));
        queenElizabeth.add(new F35("falcon"));

        try {
            queenElizabeth.fill();
        } catch (StoreOfAmmoIsEmptyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(queenElizabeth.getStatus());

        juanCarlos.add(new F16("tiger"));
        juanCarlos.add(new F16("cougar"));
        juanCarlos.add(new F35("lion"));
        juanCarlos.add(new F35("bear"));
        juanCarlos.add(new F35("leopard"));

        try {
            juanCarlos.fill();
        } catch (StoreOfAmmoIsEmptyException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(juanCarlos.getStatus());

        queenElizabeth.fight(juanCarlos);
        System.out.println("After fight");
        System.out.println(queenElizabeth.getStatus());
        System.out.println(juanCarlos.getStatus());
    }
}
