// Write a program that asks for 5 integers in a row,
// then it should print the sum and the average of these numbers like:
//
// Sum: 22, Average: 4.4

import java.util.Scanner;

public class AverageOfInput {
    public static void main(String[] args) {

        System.out.println("Enter five integers in a row: ");
        int number1 = userInput();
        int number2 = userInput();
        int number3 = userInput();
        int number4 = userInput();
        int number5 = userInput();

        sum(number1, number2, number3, number4, number5);
        average(number1, number2, number3, number4, number5);
    }

    public static int userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void sum(int a, int b, int c, int d, int e) {
        System.out.printf("Sum: %d\n", a + b + c + d + e);
    }

    public static void average(int a, int b, int c, int d, int e) {
        System.out.printf("Average: %d", (a + b + c + d + e) / 5);
    }
}
