public class AircraftApp {
    public static void main(String[] args) {
        Carrier queenElizabethClass = new Carrier(200, 500);
        Carrier nimitzClass = new Carrier(250, 600);
        Carrier juanCarlos = new Carrier(300, 550);

        F16 eagle = new F16();
        F16 sparrow = new F16();
        F35 hawk = new F35();
        F35 falcon = new F35();

        queenElizabethClass.addAircraft(eagle);
        queenElizabethClass.addAircraft(sparrow);
        queenElizabethClass.addAircraft(hawk);
        queenElizabethClass.addAircraft(falcon);

        System.out.println(queenElizabethClass.getStatus());


        try {
            queenElizabethClass.fill();
        } catch (StoreOfAmmoIsEmptyException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(queenElizabethClass.getStatus());

        System.out.println(falcon.getStatus());
        falcon.refill(10);
        System.out.println(falcon.getStatus());
        falcon.fight();
        System.out.println(falcon.getStatus());
    }
}
