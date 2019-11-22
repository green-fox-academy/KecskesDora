// Check if list contains all of the following elements: 4,8,12,16
// Create a method that accepts list as an input
// it should return "true" if it contains all, otherwise "false"

import java.util.*;

public class IsInList{
    public static void main(String... args){
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16));
        checkNums(list);
    }
    public static void checkNums(ArrayList<Integer> listOfNumbers) {
        boolean contains = false;
        if (listOfNumbers.contains(4) && listOfNumbers.contains(8)
        && listOfNumbers.contains(12) && listOfNumbers.contains(16)) {
        contains = true;
        }
        System.out.println(contains);
    }
}