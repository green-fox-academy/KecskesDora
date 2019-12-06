
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DominoesMain {
    public static void main(String[] args) {

            List<Domino> dominoes = new ArrayList<>();
            dominoes.add(new Domino(5, 2));
            dominoes.add(new Domino(5, 6));
            dominoes.add(new Domino(5, 5));
            dominoes.add(new Domino(6, 7));
            dominoes.add(new Domino(2, 4));
            dominoes.add(new Domino(7, 1));

        Collections.sort(dominoes);
        System.out.println(dominoes);
        }
    }
