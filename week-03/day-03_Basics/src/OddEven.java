import java.util.Scanner;
public class OddEven {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter your number here");
        int usersNumber = scanner.nextInt();
        if (usersNumber % 2 == 1) {
            System.out.println("Odd");
        } else {
            System.out.println("Even");
        }
    }
}
// Write a program that reads a number from the standard input,
// Then prints "Odd" if the number is odd, or "Even" if it is even.