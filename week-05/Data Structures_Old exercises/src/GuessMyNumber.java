//Write a program where the program chooses a number between 1 and 100.
// The player is then asked to enter a guess. If the player guesses wrong,
// then the program gives feedback and ask to enter an other guess until the guess is correct.
//
//Make the range customizable (ask for it before starting the guessing).
//You can add lives. (optional)
//Example
//I've the number between 1-100. You have 5 lives.
//> 20
//Too high. You have 4 lives left.
//> 10
//Too low. You have 3 lives left.
//> 15
//Congratulations. You won!

import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter two numbers in ascending order: ");
        int min = scanner.nextInt();
        int max = scanner.nextInt();
        int number = (int) (Math.random() * (max - min)) + min;
        int guess = 0;
        int lives = 5;
        System.out.println("I have a number between "  + min + " and " + max + ". You have " + lives + " lives. Guess my number!");

        while (guess != number || lives == 0) {
        guess = scanner.nextInt();

                if (guess > number) {
                    lives--;
                    if (lives > 0) {
                        System.out.println("Too high. Guess again. You have " + lives + " lives left.");
                    } else {
                        System.out.println("Sorry, you don't have any lives left. Game is over.");
                        break;
                    }
                } else if (guess < number) {
                    lives--;
                    if (lives > 0) {
                        System.out.println("Too low. Guess again. You have " + lives + " lives left.");
                    } else {
                    System.out.println("Sorry, you don't have more lives. Game is over.");
                    break;
                    }
                } else {
                System.out.println("Congratulations. You won!");
                break;
            }
        }
    }
}
