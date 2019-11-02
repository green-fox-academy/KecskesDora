import java.util.Scanner;

public class MileToKmConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("mile - km converter");
        System.out.println("please enter your distance here in miles");
        double miles = scanner.nextDouble();
        scanner.nextLine();
        System.out.println( "= " + miles * 1.609344 + " m");

        // Write a program that asks for a double that is a distance in miles,
        // then it converts that value to kilometers and prints it
    }
}
