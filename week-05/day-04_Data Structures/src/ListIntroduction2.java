import java.util.ArrayList;
import java.util.Arrays;

public class ListIntroduction2 {
    public static void main(String[] args) {
        //Create a list ('List A') which contains the following values
        //Apple, Avocado, Blueberries, Durian, Lychee
        ArrayList<String> List_A = new ArrayList<>();
        List_A.add("Apple");
        List_A.add("Avocado");
        List_A.add("Blueberries");
        List_A.add("Durian");
        List_A.add("Lychee");

        //Create a new list ('List B') with the values of List A
        ArrayList<String> List_B = List_A;

        //Print out whether List A contains Durian or not
        System.out.println(List_A.contains("Durian"));

        //Remove Durian from List B
        List_B.remove("Durian");

        //Add Kiwifruit to List A after the 4th element
        List_B.add(4, "Kiwifruit");
        System.out.println(List_B);

        //Compare the size of List A and List B
        System.out.println("Size of List_A: " + List_A.size());
        System.out.println("Size of List_B: " + List_B.size());

        //Get the index of Avocado from List A
        System.out.println(List_A.indexOf("Avocado"));

        //Get the index of Durian from List B
        System.out.println(List_B.indexOf("Durian"));

        //Add Passion Fruit and Pomelo to List B in a single statement
        ArrayList<String> NewList = new ArrayList<>(Arrays.asList("Fruit", "Pomelo"));
        List_B.addAll(NewList);
        System.out.println(List_B);

        //Print out the 3rd element from List A
        System.out.println(List_A.get(2));
     }
}
