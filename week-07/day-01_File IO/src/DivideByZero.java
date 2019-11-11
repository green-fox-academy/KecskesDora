import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter a number:");
        double number = scanner.nextDouble();
        divide(number);
    }
        public static void divide(double number){
            try {
                double result = 10 / number;
                System.out.println(result);
            } catch (ArithmeticException e) {
                System.out.println("fail");
            }
        }
    }


// Create a function that takes a number
// divides ten with it,
// and prints the result.
// It should print "fail" if the parameter is 0