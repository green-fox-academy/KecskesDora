import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ex6_FindUppercase {
    public static void main(String[] args) {
        //Write a Stream Expression to find the uppercase characters in a string!
        String text = "AbcDefGhiJ";
        char[] lettersOfText = text.toCharArray();

        List<Character> letters = new ArrayList<>();
        for (char letter : lettersOfText) {
            letters.add(letter);
        }

        //streaming list:
        List<Character> uppercaseLetters = letters.stream()
                //.filter(l -> Character.isUpperCase(l))
                .filter(Character::isUpperCase)
                .collect(Collectors.toList());

        System.out.println(uppercaseLetters);

        //streaming array:
        List<Character> uppercaseLetters2 = text.chars()
                .filter(Character::isUpperCase)
                .mapToObj(c -> (char) c)
                .collect(Collectors.toList());

        System.out.println(uppercaseLetters2);

        List<String> uppercaseLetters3 = text.chars()
                .filter(Character::isUpperCase)
                .mapToObj(c -> (String.valueOf(Character.toChars(c))))
                .collect(Collectors.toList());

        System.out.println(uppercaseLetters3);
    }
}
