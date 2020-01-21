import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex8_ConcatCharList {
    public static void main(String[] args) {
        //Write a Stream Expression to concatenate a Character list to a string!
        List<Character> letters = Arrays.asList('A', 'B', 'C', 'D');

        System.out.println(concatenate(letters));
    }

    public static String concatenate(List<Character> letters) {
        String word = letters.stream()
                .map(c -> c.toString())
                .collect(Collectors.joining(""));

        return word;
    }
}
