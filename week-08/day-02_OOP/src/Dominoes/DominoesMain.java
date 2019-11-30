package Dominoes;

import java.util.ArrayList;
import java.util.List;

public class DominoesMain {
    public static void main(String[] args) {
        List<Domino> dominoes = initializeDominoes();
        // You have the list of Dominoes
        // Order them into one snake where the adjacent dominoes have the same numbers on their adjacent sides
        // eg: [2, 4], [4, 3], [3, 5] ...

        System.out.println(dominoes);

        List<Domino> newDominoes = new ArrayList<>();
        int firstIndex = (int)(Math.random() * dominoes.size());

        newDominoes.add(0, dominoes.get(firstIndex));
        dominoes.remove(dominoes.get(firstIndex));

        while (dominoes.size() > 0) {
            for (int i = 0; i < dominoes.size(); i++) {
                if (newDominoes.get(newDominoes.size() - 1).getRightSide() == dominoes.get(i).getLeftSide()) {
                    newDominoes.add(newDominoes.size(), dominoes.get(i));
                    dominoes.remove(i);
                    // if you want to build snake in both directions:
                } else if (newDominoes.get(0).getLeftSide() == dominoes.get(i).getRightSide()) {
                    newDominoes.add(0, dominoes.get(i));
                    dominoes.remove(i);
                }
            }
        }
        System.out.println(newDominoes);
    }

    static List<Domino> initializeDominoes() {
        List<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(5, 2));
        dominoes.add(new Domino(4, 6));
        dominoes.add(new Domino(1, 5));
        dominoes.add(new Domino(6, 7));
        dominoes.add(new Domino(2, 4));
        dominoes.add(new Domino(7, 1));
        return dominoes;
    }
}