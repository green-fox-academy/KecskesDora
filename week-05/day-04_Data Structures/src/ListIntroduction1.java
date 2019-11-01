import java.util.ArrayList;

public class ListIntroduction1 {
    public static void main(String[] args){
        //Create an empty list which will contain names (strings)
        ArrayList<String> nameList =new ArrayList<>();

        //Print out the number of elements in the list
        System.out.println(nameList.size());
        System.out.println();

        //Add William to the list
        nameList.add("William");
        System.out.println();

        //Print out whether the list is empty or not
        System.out.println(nameList.isEmpty());
        System.out.println();

        //Add John to the list
        nameList.add("John");

        //Add Amanda to the list
        nameList.add("Amanda");

        //Print out the number of elements in the list
        System.out.println(nameList.size());
        System.out.println();

        //Print out the 3rd element
        System.out.println(nameList.get(2));
        System.out.println();

        //Iterate through the list and print out each name
        //  William
        //  John
        //  Amanda
        for (String i : nameList) {
            System.out.println(i);
        }
        System.out.println();

        //Iterate through the list and print
        //  1. William
        //  2. John
        //  3. Amanda
        for (int i = 0; i < nameList.size(); i++) {
            System.out.printf("%d. %s \n", (i + 1), nameList.get(i));
        }

        //Remove the 2nd element
        nameList.remove(1);
        System.out.println();

        //Iterate through the list in a reversed order and print out each name
         for (int i = 0; i < nameList.size(); i++) {
            System.out.println(nameList.get(nameList.size() - 1 - i));
        }
        System.out.println();

        //Remove all elements
        nameList.removeAll(nameList);
        System.out.println(nameList.isEmpty());
    }
}

