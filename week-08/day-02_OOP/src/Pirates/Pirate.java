
package Pirates;

public class Pirate {
    //Create a Pirate class. While you can add other fields and methods, you must have these methods:-
    public int IntoxicationLevel;
    public boolean isAlive;
    public boolean isPassedOut;


    public Pirate() {
        this.IntoxicationLevel = 0;
        this.isAlive = true;
        this.isPassedOut = false;
    }

    public Pirate(String captain) {
        this.IntoxicationLevel = 0;
        this.isAlive = true;
        this.isPassedOut = false;
    }

    public void drinkSomeRum() {
        //drinkSomeRum() - intoxicates the Pirate some

        if (this.isAlive) {
            this.IntoxicationLevel++;
            /*if (this.IntoxicationLevel >= 4) {
                this.passOut();
            }*/
        } else {
            System.out.println("he's dead");
        }
    }

    public void howsItGoingMate() {
        //howsItGoingMate() - when called, the Pirate replies, if drinkSomeRun was called:-
        //0 to 4 times, "Pour me anudder!"
        //else, "Arghh, I'ma Pirate. How d'ya d'ink its goin?", the pirate passes out and sleeps it off.

        if (this.isAlive) {
            if (this.IntoxicationLevel <= 4) {
                System.out.println("Pour me anudder!");
            } else {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
                this.passOut();
            }
        } else {
            System.out.println("he's dead");
        }
    }

     public void die() {
         //die() - this kills off the pirate, in which case, drinkSomeRum, etc. just result in he's dead.

        this.isAlive = false;
    }

    public void passOut() {
        this.isPassedOut = true;
        this.IntoxicationLevel = 0;
    }

    public void brawl(Pirate otherPirate) {
        //brawl(x) - where pirate fights another pirate (if that other pirate is alive)
        // and there's a 1/3 chance, 1 dies, the other dies or they both pass out.

        if ((this.isAlive && otherPirate.isAlive == true)
                && (this.isPassedOut && otherPirate.isPassedOut == false)) {
            int chance = (int) (Math.random() * 4);
            if (otherPirate.isAlive = true) {
                if (chance == 1) {
                    this.die();
                } else if (chance == 2) {
                    otherPirate.die();
                } else {
                    this.passOut();
                    otherPirate.passOut();
                }
            } else {
                System.out.println(otherPirate + " is dead");
            }
        }
    }
}

