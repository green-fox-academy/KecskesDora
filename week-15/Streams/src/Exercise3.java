import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Exercise3 {
    public static void main(String[] args) {
        //Write a Stream Expression to find which number squared value is more then 20 from the following list:
        List<Integer> numbers = Arrays.asList(3, 9, 2, 8, 6, 5);

        List<Integer> result = numbers.stream()
                .map(n -> (int) Math.pow(n , 2))
                .filter(n -> n > 20)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
