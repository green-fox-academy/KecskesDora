import java.util.Scanner;

public class DrawTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("size of your triangle: ");
        int size = scanner.nextInt();
        int row = 0;

        while (row < size) {
            System.out.print("*");

            int col = 0;
            while (col < row) {
                System.out.print("*");
                col++;
            }
            System.out.println();
            row++;
        }
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
