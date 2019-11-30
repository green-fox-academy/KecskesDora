package Pirates;

public class BattleApp {
    public static void main(String[] args) {

        Ship ship1 = new Ship("ship1");
        Ship ship2 = new Ship("ship2");

        ship1.fillShip();
        ship2.fillShip();

        ship1.crew.get(5).howsItGoingMate();
        ship1.crew.get(5).drinkSomeRum();
        for (int i = 0; i <= 5 ; i++) {
            ship1.crew.get(3).drinkSomeRum();
            System.out.println(ship1.crew.get(3).IntoxicationLevel);
        }
        ship1.crew.get(3).howsItGoingMate();
        ship1.captain.howsItGoingMate();
        ship1.captain.drinkSomeRum();
        ship2.captain.howsItGoingMate();
        System.out.println();

        ship1.representShip();
        System.out.println();
        ship2.representShip();
        System.out.println();

        ship1.battle(ship2);

        ship1.representShip();
        System.out.println();
        ship2.representShip();
        System.out.println();

        ship1.crew.get(5).howsItGoingMate();
        ship1.captain.howsItGoingMate();
        ship2.crew.get(3).howsItGoingMate();
        ship2.captain.howsItGoingMate();

        ship1.crew.get(2).brawl(ship2.crew.get(3));
        System.out.println(ship1.crew.get(2).isAlive);
        System.out.println(ship1.crew.get(2).isPassedOut);
        System.out.println(ship2.crew.get(3).isAlive);
        System.out.println(ship2.crew.get(3).isPassedOut);
    }
}
