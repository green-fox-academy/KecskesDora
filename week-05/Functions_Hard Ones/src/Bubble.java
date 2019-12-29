import java.util.*;

public class Bubble {
    public static void main(String[] args) {
        //  Create a function that takes a list of numbers as parameter
        //  Returns a list where the elements are sorted in ascending numerical order
        //  Make a second boolean parameter, if it's `true` sort that list descending

        //  Example:
        System.out.println(bubble(new int[] {34, 12, 24, 9, 5}));
        //  should print [5, 9, 12, 24, 34]
        System.out.println(advancedBubble(new int[] {34, 12, 24, 9, 5}, true));
        //  should print [34, 24, 12, 9, 5]
    }
    private static List<Integer> bubble(int[] list) {
        int temp;
        List<Integer> ascendingList = new ArrayList<Integer>();

        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if (list[i] > list[j]) {
                    temp = list[i];
                    list[i] = list[j];
                    list[j] = temp;
                }
            }
            ascendingList.add(i, list[i]);
        }
        return ascendingList;
    }

    private static List<Integer> advancedBubble(int[] list, boolean descending) {

        if (!descending) {
            return bubble(list);
        } else {
            List<Integer> descendingList = new ArrayList<>();
            int temp;

            for (int i = 0; i < list.length; i++) {
                for (int j = i + 1; j < list.length; j++) {
                    if (list[i] < list[j]) {
                        temp = list[i];
                        list[i] = list[j];
                        list[j] = temp;
                    }
                }
                descendingList.add(i, list[i]);
            }
            return descendingList;
        }
    }
}