import java.util.ArrayList;

public class PrintApp {
    public static void main(String[] args) {
        ArrayList<Domino> dominoes = new ArrayList<>();
        dominoes.add(new Domino(2, 5));
        dominoes.add(new Domino(4, 7));
        dominoes.add(new Domino(1, 3));
        dominoes.add(new Domino(5, 8));

        ArrayList<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Hoovering", "high"));
        todos.add(new Todo("Ironing", "low"));
        todos.add(new Todo("Buy christmas presents", "medium"));
        todos.add(new Todo("Shopping", "high"));

        for (Domino d : dominoes) {
            d.printAllFields();
        }

        for (Todo t : todos) {
            t.printAllFields();
        }
    }
}
