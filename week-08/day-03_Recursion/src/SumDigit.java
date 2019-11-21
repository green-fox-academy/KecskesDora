//Given a non-negative integer n,
// return the sum of its digits recursively (without loops).

public class SumDigit {
    public static void main(String[] args) {
        System.out.println(sumOfDigits(3456));
    }
    public static int sumOfDigits(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n % 10 + sumOfDigits(n / 10);
        }
    }
}
