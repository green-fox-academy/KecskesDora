
package Pirates;
import java.util.ArrayList;
import java.util.List;

public class Ship {
    //Create a Ship class.
    //The Ship stores Pirate-s instances in a list as the crew and has one captain who is also a Pirate.
    //When a ship is created it doesn't have a crew or a captain.

    String name;
    List<Pirate> crew;
    Pirate captain;
    boolean winBattle;

    public Ship() {

    }

    public Ship(String name) {
        this.name = name;
        this.winBattle = true;
    }

    public void fillShip() {
        //The ship can be filled with pirates and a captain via fillShip() method.
        //Filling the ship with a captain and random number of pirates.

        this.captain = new Pirate();
        this.crew = new ArrayList<Pirate>();
        int randomSizeOfCrew = (int) ((Math.random() * 30) + 5);

        for (int i = 1; i < randomSizeOfCrew; i++) {
            this.crew.add(new Pirate());
        }
    }

    public void representShip() {
        //Ships should be represented in a nice way on command line including information about
        //captains consumed rum, state (passed out / died)

        System.out.println("State of " + this.name + ":");
        System.out.println("Captain consumed " + captain.IntoxicationLevel + " pint rum.");

        if (this.captain.isAlive) {
            if (this.captain.isPassedOut) {
                System.out.println("Captain passed out.");
            } else {
                System.out.println("Captain is alive and awake");
            }
        } else {
            System.out.println("Captain is dead.");
        }
        //number of alive pirates in the crew
        System.out.println(this.alivePiratesCounter() + " pirates is alive in the crew");
    }

    public int alivePiratesCounter() {
        int aliveCounter = 0;
        for (int i = 1; i < this.crew.size(); i++) {
            if (this.crew.get(i).isAlive) {
                aliveCounter++;
            }
        }
        return aliveCounter;
    }

    public int calculateScore() {
        //calculate score: Number of Alive pirates in the crew - Number of consumed rum by the captain
        int calcScore = 0;
        calcScore = alivePiratesCounter() - captain.IntoxicationLevel;
        return calcScore;
    }

    public boolean battle(Ship otherShip) {
        //Ships should have a method to battle other ships: ship.battle(otherShip)
        //should return true if the actual ship (this) wins
        //the ship should win if its calculated score is higher

        if (this.calculateScore() > otherShip.calculateScore()) {
            this.party();
            otherShip.deaths();
            this.winBattle = true;
            otherShip.winBattle = false;
            return this.winBattle;

        } else if (this.calculateScore() < otherShip.calculateScore()) {
            this.deaths();
            otherShip.party();
            this.winBattle = false;
            otherShip.winBattle = true;
            return this.winBattle;
        } else {
            this.deaths();
            otherShip.deaths();
            this.winBattle = false;
            otherShip.winBattle = false;
            return this.winBattle;
        }
    }

    public void deaths() {
        //The loser crew has a random number of losses (deaths).
        if (this.captain.isAlive) {
            if ((int) (Math.random() * 2) == 1) {
                this.captain.die();
            }
        }

        for (int i = 0; i < this.crew.size(); i++) {
            if (this.crew.get(i).isAlive) {
                if (((int) (Math.random() * 2)) == 1) {
                    this.crew.get(i).die();
                }
            }
        }
    }

    public void party () {
        //The winner captain and crew has a party, including a random number of rum :)

        int randomRumForCaptain = (int) (Math.random() * 5);
        for (int i = 0; i <= randomRumForCaptain; i++) {
            if (captain.isAlive && !captain.isPassedOut) {
                this.captain.drinkSomeRum();
            }
        }

        for (int i = 0; i < this.crew.size(); i++) {
            if (this.crew.get(i).isAlive && !this.crew.get(i).isPassedOut) {
                int randomRumForCrew = (int) (Math.random() * 5);
                for (int numberOfDrinks = 0; numberOfDrinks <= randomRumForCrew; numberOfDrinks++) {
                    this.crew.get(i).drinkSomeRum();
                }
            }
        }
    }
}


