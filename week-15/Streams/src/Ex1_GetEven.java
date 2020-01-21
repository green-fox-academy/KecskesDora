import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Ex1_GetEven {
    public static void main(String[] args) {
        //Write a Stream Expression to get the even numbers from the following list:
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNumbers);

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n));

        numbers.stream()
                .filter(n -> n % 2 == 0)
                .forEach(System.out::println);
    }
}
