// Write a method that checks if the arrayList contains "7" if it contains return "Hoorray" otherwise return "Noooooo"
// The output should be: "Noooooo"
// Do this again with a different solution using different list methods!

import java.util.*;

public class ElementFinder {
    public static void main(String... args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        int number = 7;
        containsSeven(arrayList, number);
        containsSevenv2(arrayList, number);
    }

    public static void containsSeven(ArrayList<Integer> listOfNumbers, int n) {

        if (listOfNumbers.contains(n)) {
            System.out.println("Hoorray");
        } else {
            System.out.println("Noooo");
        }
    }

    public static void containsSevenv2(ArrayList<Integer> listOfNumbers, Integer n) {
        boolean contains = false;
        for (int i = 0; i < listOfNumbers.size(); i++) {
            if (listOfNumbers.get(i).equals(n)) {
                contains = true;
                break;
            }
        }
        if (contains == true) {
            System.out.println("Hoorray");
        } else {
            System.out.println("Noooo");
        }
    }
}