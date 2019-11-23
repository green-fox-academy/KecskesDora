import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Guess a number:");
        int n = 42;
        int guess = 0;

       while (guess != n) {

           guess = scanner.nextInt();
           if (guess > n) {
               System.out.println("The stored number is lower. Guess again.");
           } else if (guess < n) {
               System.out.println("The stored number is higher. Guess again.");
           } else {
               System.out.println("You found the number: " + n);
           }
       }

    }
}

// Write a program that stores a number, and the user has to figure it out.
// The user can input guesses, after each guess the program would tell one
// of the following:
//
// The stored number is higher
// The stried number is lower
// You found the number: 8