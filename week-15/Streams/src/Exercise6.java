import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise6 {
    public static void main(String[] args) {
        //Write a Stream Expression to find the uppercase characters in a string!
        String text = "AbcDefGhiJ";
        char[] lettersOfText = text.toCharArray();

        List<Character> letters = new ArrayList<>();
        for (char letter : lettersOfText) {
            letters.add(letter);
        }

        List<Character> uppercaseLetters = letters.stream()
                //.filter(l -> Character.isUpperCase(l))
                .filter(Character::isUpperCase)
                .collect(Collectors.toList());

        System.out.println(uppercaseLetters);
    }
}
