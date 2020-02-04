
package Pirates;

import java.util.ArrayList;
import java.util.List;

public class Armada {
    //Create an Armada class
    //Contains Ship-s as a list

    public String name;
    public List<Ship> ships = new ArrayList<>();

    public Armada() {

    }

    public Armada(String name) {
        this.name = name;
    }

    public void fillArmada() {
        //fill armada with ships, fill ships
        ships = new ArrayList<>();
        int randomSizeOfArmada = (int) ((Math.random() * 10) + 5);

        for (int i = 0; i < randomSizeOfArmada; i++) {
            ships.add(i, new Ship());
            ships.get(i).fillShip();
        }
        System.out.println(ships.size());
    }

    public void war(Armada other) {
        //Have a armada.war(other) method where two armada can engage in war
        //it should work like merge sort
        //first ship from the first armada battles the first of the other
        //the loser gets skipped so the next ship comes in play from that armada
        //whichever armada gets to the end of its ships loses the war
        //return true if this is the winner

        int attackerIndex = 0;
        int defenderIndex = 0;
        Ship attacker = ships.get(attackerIndex);
        Ship defender = other.ships.get(defenderIndex);

        for (int i = 0; i < ships.size(); i++) {
            if (i > 0 && attacker.isWinner()) {
                i--;
            }
            for (int j = 0; j < other.ships.size(); j++) {
                if (j > 0 && defender.isWinner()) {
                    j--;
                }
                attacker.winBattle(false);
                defender.winBattle(false);
                attacker = ships.get(i);
                defender = other.ships.get(j);
                attacker.battle(defender);
                if (attacker.isWinner()) {
                    attacker.winBattle(true);
                } else {
                    defender.winBattle(false);
                }
            }
        }
    }
}
/*
        ships.get(attackerIndex).battle(other.ships.get(defenderIndex));

        while (attackerIndex < this.ships.size() && defenderIndex < other.ships.size()) {

            if (ships.get(attackerIndex).isWinner()) {
                defenderIndex++;
                ships.get(attackerIndex).winBattle(false);
                ships.get(attackerIndex).battle(other.ships.get(defenderIndex));
            } else if (other.ships.get(defenderIndex).isWinner()) {
                attackerIndex++;
                other.ships.get(defenderIndex).winBattle(false);
                other.ships.get(defenderIndex).battle(ships.get(attackerIndex));
            } else {
                attackerIndex++;
                defenderIndex++;
                ships.get(attackerIndex).winBattle(false);
                other.ships.get(defenderIndex).winBattle(false);
                ships.get(attackerIndex).battle(other.ships.get(defenderIndex));
            }
        }
            if (defenderIndex == other.ships.size()) {
                System.out.println(name + " won");
            }
            if (attackerIndex == ships.size()) {
                System.out.println(other.name + " won");
            }
    }*/

        //System.out.println(this.armada.get(0).winBattle);
        //System.out.println(otherArmada.armada.get(0).winBattle);

        /*for (int i = 0; i < this.armada.size(); i++) {
            for (int j = 0; j < otherArmada.armada.size(); j++) {

                this.armada.get(i).battle(otherArmada.armada.get(j));
                if (this.armada.get(i).winBattle) {

                    break;
                }
            }
        }*/



