import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        ArrayList<String> shoppingList = new ArrayList<>(Arrays.asList("Eggs", "milk", "fish", "apples", "bread", "chicken"));
        //Do we have milk on the list?
        //Do we have bananas on the list?
        Scanner Scanner = new Scanner(System.in);
        System.out.println("Check your shopping list!");
        String item = Scanner.nextLine();
            if (shoppingList.contains(item) == true) {
                System.out.println("Yes, we have " + item + " on the list.");
            } else {
                System.out.println("No, we don't. You should add it to the list.");
            }
    }
}


