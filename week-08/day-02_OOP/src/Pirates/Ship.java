
package Pirates;
import java.util.List;

public class Ship {
    //Create a Ship class.
    //The Ship stores Pirate-s instances in a list as the crew and has one captain who is also a Pirate.
    //When a ship is created it doesn't have a crew or a captain.
    
    List<Pirate> crew;
    Pirate captain;

    public Ship() {
    }

    public void fillShip() {
        //The ship can be filled with pirates and a captain via fillShip() method.
        //Filling the ship with a captain and random number of pirates.
        
        Pirate captain = new Pirate();

        for (int i = 1; i < (int)(Math.random() * 20); i++) {
            crew.add(new Pirate());
        }
    }

    public void representShip() {
        //Ships should be represented in a nice way on command line including information about
        //captains consumed rum, state (passed out / died)

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

    public boolean battle(Ship othership) {
        //Ships should have a method to battle other ships: ship.battle(otherShip)
        //should return true if the actual ship (this) wins
        //the ship should win if its calculated score is higher

        if (this.calculateScore() > othership.calculateScore()){
            this.party();
            othership.deaths();
            return true;
        } else if (this.calculateScore() < othership.calculateScore()){
            this.deaths();
            othership.party();
            return false;
        } else {
            this.deaths();
            othership.deaths();
            return false;
        }
    }

    public void deaths(){
        //The loser crew has a random number of losses (deaths).

        for (int i = 0; i <(int)(Math.random() * this.alivePiratesCounter()); i++) {
            while (this.crew.get(i).isAlive) {
                this.crew.get(i).die();
            }
        }
    }

    public void party(){
        //The winner captain and crew has a party, including a random number of rum :)

        for (int i = 0; i < (int)(Math.random() * 4); i++) {
            this.captain.drinkSomeRum();
        }
        for (int i = 0; i < (int)(Math.random() * this.alivePiratesCounter()); i++) {
            if (this.crew.get(i).isAlive) {
                for (int j = 0; j < (int) (Math.random() * 4); j++) {
                    this.crew.get(i).drinkSomeRum();
                }
            }
        }
    }
}
