import java.util.Map;
import java.util.stream.Collectors;

public class Ex9_FrequencyOfChars {
    public static void main(String[] args) {
        //Write a Stream Expression to find the frequency of characters in a given string!
        String text = "aaaAAA bbbBBB cccCCC";

        printMap(findFrequencyOfCharacters(text));
    }

    public static Map<Character, Long> findFrequencyOfCharacters(String text) {
        Map<Character, Long> frequencyOfChars = text.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> (Character) c, Collectors.counting()));

        return frequencyOfChars;
    }

    public static void printMap(Map<Character, Long> mapOfFrequency) {
        String frequencyOfChars = mapOfFrequency.entrySet().stream()
            .map(entry -> "'" + entry.getKey() + "' occurs: " + entry.getValue() + " times")
            .collect(Collectors.joining("\n"));
        System.out.println(frequencyOfChars);
    }
}
