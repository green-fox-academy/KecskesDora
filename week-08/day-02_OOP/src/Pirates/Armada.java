
package Pirates;

import java.util.ArrayList;
import java.util.List;

public class Armada {
    //Create an Armada class
    //Contains Ship-s as a list

    public String name;
    public List<Ship> armada = new ArrayList<>();

    public Armada() {

    }

    public Armada(String name) {
        this.name = name;
    }

    public void fillArmada() {
        //fill armada with ships, fill ships
        this.armada = new ArrayList<Ship>();
        int randomSizeOfArmada = (int) ((Math.random() * 10) + 5);

        for (int i = 0; i < randomSizeOfArmada; i++) {
            this.armada.add(i, new Ship());
            this.armada.get(i).fillShip();
        }
        System.out.println(this.armada.size());
    }

    public void war(Armada otherArmada) {
        //Have a armada.war(otherArmada) method where two armada can engage in war
        //it should work like merge sort
        //first ship from the first armada battles the first of the other
        //the loser gets skipped so the next ship comes in play from that armada
        //whichever armada gets to the end of its ships loses the war
        //return true if this is the winner

        int armadaIndex = 0;
        int OtherarmadaIndex = 0;
        Ship Ship1 = this.armada.get(armadaIndex);
        Ship Ship2 = otherArmada.armada.get(OtherarmadaIndex);

        this.armada.get(armadaIndex).battle(otherArmada.armada.get(OtherarmadaIndex));

        while (armadaIndex < this.armada.size() && OtherarmadaIndex < otherArmada.armada.size()) {

            if (this.armada.get(armadaIndex).winBattle) {
                OtherarmadaIndex++;
                this.armada.get(armadaIndex).winBattle = false;
                this.armada.get(armadaIndex).battle(otherArmada.armada.get(OtherarmadaIndex));
            } else if (otherArmada.armada.get(OtherarmadaIndex).winBattle) {
                armadaIndex++;
                otherArmada.armada.get(OtherarmadaIndex).winBattle = false;
                otherArmada.armada.get(OtherarmadaIndex).battle(this.armada.get(armadaIndex));
            } else {
                armadaIndex++;
                OtherarmadaIndex++;
                this.armada.get(armadaIndex).winBattle = false;
                otherArmada.armada.get(OtherarmadaIndex).winBattle = false;
                this.armada.get(armadaIndex).battle(otherArmada.armada.get(OtherarmadaIndex));
            }
        }
            if (OtherarmadaIndex == otherArmada.armada.size()) {
                System.out.println(this.name + " won");
            }
            if (armadaIndex == this.armada.size()) {
                System.out.println(otherArmada.name + " won");
            }
    }

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
    }


