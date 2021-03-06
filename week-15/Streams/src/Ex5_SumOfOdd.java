import java.util.Arrays;
import java.util.List;

public class Ex5_SumOfOdd {
    public static void main(String[] args) {
        //Write a Stream Expression to get the sum of the odd numbers in the following list:
        List<Integer> numbers = Arrays.asList(5, 9, 1, 2, 3, 7, 5, 6, 7, 3, 7, 6, 8, 5, 4, 9, 6, 2);

        long sumOfOddNumbers = numbers.stream()
                .filter(n -> n % 2 == 1)
                .mapToInt(n -> n)
                .sum();
        System.out.println(sumOfOddNumbers);

        int sumOfOddNumbers2 = numbers.stream()
                .filter(n -> n % 2 == 1)
                .reduce(0, (summa, n) -> summa + n);
                //.reduce(0, Integer::sum);
        System.out.println(sumOfOddNumbers2);
    }
}
