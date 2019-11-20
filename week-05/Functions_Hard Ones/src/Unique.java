import java.util.*;

public class Unique {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as a parameter
        //  Returns a list of numbers where every number in the list occurs only once

        //  Example
        System.out.println(unique(new int[]{1, 11, 34, 11, 52, 61, 1, 34}));
        //  should print: `[1, 11, 34, 52, 61]`
    }

    private static ArrayList<Integer> unique(int[] list) {
        Arrays.sort(list);

        ArrayList<Integer> uniqueList = new ArrayList<Integer>();
        for (int i = 0; i < list.length; i++) {
            uniqueList.add(i, list[i]);
        }

        int i = 0;

        while (i < uniqueList.size()) {
            if (i + 1 < uniqueList.size()) {
                if (uniqueList.get(i) == uniqueList.get(i + 1)) {
                    uniqueList.remove(i);
                    i--;
                }
            }
            i++;
        }
        return uniqueList;
    }
}

       /* for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] == list[j]) {
                    temp = list[i];
                }
            }
            uniqueList.add(i, list[i]);
        }
        return uniqueList;*/

    /*private static List<Integer> unique(int[] list) {
        String[] stringList = new String[list.length];

        for (int i = 0; i < list.length; i++) {
            stringList[i] = String.valueOf(list[i]);
            if Collections.
        }

    }*/
    /*private static List<Integer> unique(int[] list) {
        List<Integer> sortedList = new ArrayList<Integer>();
        List<Integer> uniqueList = new ArrayList<Integer>();

        for (int i = 0; i < list.length; i++) {
            sortedList.add(i, list[i]);
        }
        Collections.sort(sortedList);

        for (int i = 0; i < sortedList.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (sortedList.get(i) == sortedList.get(j)) {
                    break;
                }
                if (i == j){
                    uniqueList.add(i, sortedList.get(i));
                }
            }
        }
        return uniqueList;
    }*/



