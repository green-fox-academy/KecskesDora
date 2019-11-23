// Create a method called "appendA()" that adds "a" to every string in the "far" list.
// The parameter should be a list.

import java.util.*;

public class AppendLetter{
    public static void main(String... args){
        List<String> far = Arrays.asList("bo", "anacond", "koal", "pand", "zebr");

        System.out.println(appendA(far));
    }
    public static List<String> appendA(List<String> input) {

        ArrayList<String> newList = new ArrayList<>(input.size());

        for (String element : input) {
            String newElement = element.concat("a");
            newList.add(newElement);
        }
        return newList;
    }
}
// The output should be: "boa", "anaconda", "koala", "panda", "zebra"