import java.util.Scanner;

public class HelloUser {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("please write your name here");
            String userName = scanner.nextLine();
            System.out.println("Hello, " + userName + "!");
    }
}
// Modify this program to greet user instead of the World!
// The program should ask for the name of the user