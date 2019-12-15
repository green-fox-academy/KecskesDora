import java.util.HashMap;
import java.util.Map;

public class CountLetters {

    /*public static void main(String[] args) {

        System.out.println(showHashmap(letterCounter("Christmas is coming soon")));
    }*/

    public static HashMap<String, Integer> letterCounter(String text) throws Exception {
        HashMap<String, Integer> letterCount = new HashMap<>();

        if (text == null || text == "") throw new Exception("String does not exist!");

        String[] textCharacters = text.split("");

        for (String letter : textCharacters) {
            if (!letterCount.containsKey(letter)) {
                letterCount.put(letter, 1);
            } else {
                letterCount.replace(letter, letterCount.get(letter) + 1);
            }
        }
        return letterCount;
    }

    public static String showHashmap(HashMap<String, Integer> letterCount) {
        String dictionaryOfLetters = "";
        for (Map.Entry<String, Integer> counter : letterCount.entrySet()) {
            dictionaryOfLetters += String.format("Letter \"%s\" occurs %d times\n", counter.getKey(), counter.getValue());
        }
         return dictionaryOfLetters;
    }
}
