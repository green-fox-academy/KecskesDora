//Find the greatest common divisor of two numbers using recursion.

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(findCommonDiv(42, 68));
    }
    public static int findCommonDiv(int a, int b) {
        if (a > b) {
            if (b == 0) {
                return a;
            } else {
                return findCommonDiv(b, a % b);
            }
        } else if (a < b) {
            if (a == 0) {
                return b;
            } else {
                return findCommonDiv(a, b % a);
            }
        } else {
            return a;
        }
    }
}
