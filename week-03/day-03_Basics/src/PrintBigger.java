// Write a program that asks for two numbers and prints the bigger one

import java.util.Scanner;

public class PrintBigger {
    public static void main(String[] args) {

        System.out.println("Enter two numbers: ");

        findBigger(userInput(), userInput());
    }

    public static int userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void findBigger(int a, int b) {
        if (a > b) {
            System.out.println("The bigger number is: " + a);
        } else if (a < b) {
            System.out.println("The bigger number is: " + b);
        } else {
            System.out.println("The numbers are equal.");
        }
    }
}