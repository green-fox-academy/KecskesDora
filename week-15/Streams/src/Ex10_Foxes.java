import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Ex10_Foxes {
    public static void main(String[] args) {
        List<Fox> foxes = Arrays.asList(new Fox("Iny", "red", 5),
                new Fox("Karak", "green", 9),
                new Fox("Vuk", "red", 2),
                new Fox("Lili", "green", 3),
                new Fox("Lele", "green", 2)
        );

        System.out.println(findFoxesByColor(foxes, "green"));
        System.out.println(findFoxesByColorAndAge(foxes, "green", 5));
        printMap(findFrequencyOfFoxesByColor(foxes));
    }
    //Write a Stream Expression to find the foxes with green color!
    public static List<Fox> findFoxesByColor(List<Fox> foxes, String color) {

        List<Fox> greenFoxes = foxes.stream()
                .filter(f -> String.valueOf(f.getColor()) == color)
                .collect(Collectors.toList());

        return greenFoxes;
    }

    //Write a Stream Expression to find the foxes with green color, and age less then 5 years!
    public static List<Fox> findFoxesByColorAndAge(List<Fox> foxes, String color, int age) {

        List<Fox> greenFoxesLessThenAge = findFoxesByColor(foxes, color).stream()
                .filter(fox -> fox.getAge() < age)
                .collect(Collectors.toList());

        return greenFoxesLessThenAge;
    }

    //Write a Stream Expression to find the frequency of foxes by color!
    public static Map<String, Long> findFrequencyOfFoxesByColor(List<Fox> foxes) {

        Map<String, Long> byColor = foxes.stream()
                .collect(Collectors.groupingBy(f -> String.valueOf(f.getColor()), Collectors.counting()));

        return byColor;
    }

    public static void printMap(Map<String, Long> mapOfFoxes) {

        String frequencyByColor = mapOfFoxes.entrySet().stream()
                .map(entry -> entry.getValue() + " " + entry.getKey() + " foxes")
                .collect(Collectors.joining("\n"));
        System.out.println(frequencyByColor);
    }
}
