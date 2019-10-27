import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter your number: ");

        int totalSize = scanner.nextInt();
        int numberOfStars = 1;

        for (int raw = 0; raw < totalSize; raw++) {
            for (int i = 0; i < numberOfStars; i++) {
                System.out.print("*");
            }
            numberOfStars++;
            System.out.println();
        }
        /*while (row < size) {
            System.out.print("*");

            int col = 0;
            while (col < row) {
                System.out.print("*");
                col++;
            }
            System.out.println();
            row++;
        }*/
        }
    }


// Write a program that reads a number from the standard input, then draws a
// triangle like this:
//
// *
// **
// ***
// ****
//
