import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Exercise4 {
    public static void main(String[] args) {
        //Write a Stream Expression to get the average value of the odd numbers from the following list:
        List<Integer> numbers = Arrays.asList(1, 3, -2, -4, -7, -3, -8, 12, 19, 6, 9, 10, 14);

        OptionalDouble averageOfOddNumbers = numbers.stream()
                .filter(n -> n % 2 == 1 || n % 2 == -1)
                .mapToInt(n -> n)
                .average();

        if (averageOfOddNumbers.isPresent()) {
            System.out.println(averageOfOddNumbers);
        } else {
            System.out.println("empty list");
        }

    }
}
