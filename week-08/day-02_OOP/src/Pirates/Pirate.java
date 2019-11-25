package Pirates;

public class Pirate {
    public int toxicLevel;
    public boolean isAlive;
    public boolean passedOut;
    public boolean haveParrot;
    public boolean isCaptain;

    public Pirate() {
        this.toxicLevel = 0;
        this.isAlive = true;
        this.passedOut = false;
        this.haveParrot = false;
        this.isCaptain = false;
    }

    public Pirate(String captain) {
        this.toxicLevel = 0;
        this.isAlive = true;
        this.passedOut = false;
        this.haveParrot = true;
        this.isCaptain = true;
    }

    public void drinkSomeRum() {
        if (this.isAlive = true) {
            toxicLevel++;
        } else {
            System.out.println("he's dead");
        }
    }

    public void howsItGoingMate() {
        if (this.isAlive = true) {
            if (this.toxicLevel <= 4) {
                System.out.println("Pour me anudder!");
            } else {
                System.out.println("Arghh, I'ma Pirate. How d'ya d'ink its goin?");
                passedOut = true;
            }
        } else {
            System.out.println("he's dead");
        }
    }

     public void die() {
        this.isAlive = false;
    }

    public void brawl(Pirate otherPirate) {
        int chance = (int)(Math.random() * 3 + 1);
        if (otherPirate.isAlive = true) {
            if (chance == 1) {
                this.isAlive = false;
            } else if (chance == 2) {
                otherPirate.isAlive = false;
            } else {
                this.passedOut = true;
                otherPirate.passedOut = true;
            }
        } else {
            System.out.println(otherPirate + " is dead");
        }
    }

    public void addParrot() {
        this.haveParrot = true;
    }

    }

