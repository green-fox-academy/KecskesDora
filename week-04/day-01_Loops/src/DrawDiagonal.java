import java.util.Scanner;

public class DrawDiagonal {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("size of your square: ");

        int size = scanner.nextInt();
        int x = 0;

        for (int i = 0; i < size; i++) {
            System.out.print("%");
        }
        System.out.println();
        for (int r = 0; r < size - 2; r++) {
            System.out.print("%");
            for (int j = 0; j < (size - 2); j++) {
                if (j == x) {
                    System.out.print("%");
                    } else {
                    System.out.print(" ");
                }
            }
                    System.out.print("%");
        System.out.println();
        x++;
        }
        for (int l = 0; l < size; l++) {
            System.out.print("%");
        }
    }
}
// Write a program that reads a number from the standard input, then draws a
// square like this:
//
//
// %%%%%
// %%  %
// % % %
// %  %%
// %%%%%
//
// The square should have as many lines as the number was