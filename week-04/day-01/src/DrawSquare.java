import java.util.Scanner;

public class DrawSquare {
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("size of your square: ");

            int size = scanner.nextInt();

            for (int i = 0; i < size; i++) {
                System.out.print("%");
            }
            System.out.println();
            for (int r = 0; r < (size - 2); r++) {
                System.out.print("%");
                for (int j = 0; j < (size - 2); j++) {
                    System.out.print(" ");
            }
            System.out.print("%");
            System.out.println();
            }
            for (int l = 0; l < size; l++) {
                System.out.print("%");
            }
        }
}
