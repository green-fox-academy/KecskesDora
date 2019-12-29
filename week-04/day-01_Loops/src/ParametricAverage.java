// Write a program that asks for a number.
// It would ask this many times to enter an integer,
// if all the integers are entered, it should print the sum and average of these
// integers like:
//
// Sum: 22, Average: 4.4

import java.util.Scanner;

public class ParametricAverage {
    public static void main(String[] args) {

        int repeat = 5;
        int sum = sum(repeat);
        float average = (float) sum / repeat;

        System.out.printf("Sum: %d, Average: %.1f", sum, average);
    }

    public static int userInput() {
        System.out.println("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static int sum(int times) {
        int sum = 0;
        for (int i = 0; i < times; i++) {
            sum += userInput();
        }
        return sum;
    }
}
