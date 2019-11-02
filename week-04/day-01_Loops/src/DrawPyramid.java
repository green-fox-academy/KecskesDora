import java.util.Scanner;

public class DrawPyramid {
    public static void main(String[] args) {
        Scanner Scanner = new Scanner(System.in);
        System.out.println("enter a number");
        int number = Scanner.nextInt();
        int stars = 1;

            for (int rawIndex = 0; rawIndex <= (number - 1) / 2; rawIndex++) {

                for (int spaceIndex = 0; spaceIndex <= (number - stars) / 2; spaceIndex++) {
                    System.out.print(" ");
                }
                for (int starsIndex = 1; starsIndex <= stars; starsIndex++) {
                    System.out.print("*");
                }
                stars += 2;
                System.out.println();
            }
    }
}

//    *
//   ***
//  *****
// *******