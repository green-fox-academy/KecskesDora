// Write a program that asks for two integers
// The first represents the number of chickens the farmer has
// The second represents the number of pigs owned by the farmer
// It should print how many legs all the animals have

import java.util.Scanner;

public class AnimalsAndLegs {
    public static void main(String[] args) {

        System.out.println("Enter the number of chickens:");
        int chicks = userInput();
        System.out.println("Enter the number of pigs:");
        int pigs = userInput();

        legsCalculator(chicks, pigs);
    }

    public static int userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void legsCalculator(int chicks, int pigs) {
        System.out.printf("All the legs: %d", chicks * 2 + pigs * 4);
    }
}

