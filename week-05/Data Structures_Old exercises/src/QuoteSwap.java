import java.util.*;

public class QuoteSwap{
    public static void main(String... args){
        ArrayList<String> list = new ArrayList<String>(Arrays.asList("What", "I", "do", "create,", "I", "cannot", "not", "understand."));
        quoteSwap(list);
    }

    public static void quoteSwap(ArrayList<String> list) {
        Collections.swap(list, 2, 5);
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%s ", list.get(i));
        }
    }
}
// Accidentally I messed up this quote from Richard Feynman.
// Two words are out of place
// Your task is to fix it by swapping the right words with code
// Create a method called quoteSwap().

// Also, print the sentence to the output with spaces in between.
