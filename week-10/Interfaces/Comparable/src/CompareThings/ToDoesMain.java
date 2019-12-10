package CompareThings;
import java.util.ArrayList;
import java.util.Collections;

public class ToDoesMain {
    public static void main(String[] args) {
        ArrayList<ToDo> todos = new ArrayList<ToDo>();
        todos.add(new ToDo("Hoovering", false));
        todos.add(new ToDo("Ironing", false));
        todos.add(new ToDo("Buy christmas presents", false));
        todos.add(new ToDo("Shopping", true));
        todos.add(new ToDo("Cleaning windows", true));

        Collections.sort(todos);
        System.out.println(todos);
    }
}
