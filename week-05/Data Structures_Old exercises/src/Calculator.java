import java.util.Scanner;

public class Calculator {
    public static void main(String... args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type in the expression:");
        String expressionInput = scanner.nextLine();

        calculate(expressionInput);
    }

    public static int calculate(String expression) {
        String[] splittedExpression = expression.split(" ", 3);
        String operation = splittedExpression[0];
        int operand1 = Integer.valueOf(splittedExpression[1]);
        int operand2 = Integer.valueOf(splittedExpression[2]);
        int value = 0;

        if (operation.equals("+")) {
            value = operand1 + operand2;
        } else if (operation.equals("-")) {
            value = operand1 - operand2;
        } else if (operation.equals("*")) {
            value = operand1 * operand2;
        } else if (operation.equals("%")) {
            value = operand1 % operand2;
        } else if (operation.equals("/")) {
            value = operand1 / operand2;
        }
        return value;
    }
}
           /*switch (operation) {
            case "+":
                value = operand1 + operand2;
                break;
            case "-":
                value = operand1 - operand2;
                break;
            case "*":
                value = operand1 * operand2;
                break;
            case "%":
                value = operand1 % operand2;
                break;
            case "/":
                value = operand1 / operand2;
                break;

            default:
                System.out.println("Please type again the expression.");
        }
        System.out.println(value);*/

// Create a simple calculator application which reads the parameters from the prompt
// and prints the result to the prompt.
// It should support the following operations,
// create a method named "calculate()":
// +, -, *, /, % and it should support two operands.
// The format of the expressions must be: {operation} {operand} {operand}.
// Examples: "+ 3 3" (the result will be 6) or "* 4 4" (the result will be 16)

// You can use the Scanner class
// It should work like this:

// Start the program
// It prints: "Please type in the expression:"
// Waits for the user input
// Print the result to the prompt
// Exit