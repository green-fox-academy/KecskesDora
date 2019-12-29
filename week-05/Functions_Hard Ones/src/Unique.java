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

        ArrayList<Integer> uniqueList = new ArrayList<>();
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


