public class Fibonacci {

    public static int fibonacciCreator(int n) throws NotPositiveIntegerException{
        if (n <= 0) throw new NotPositiveIntegerException();
        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            return fibonacciCreator(n - 1) + fibonacciCreator(n - 2);
        }
    }

}
