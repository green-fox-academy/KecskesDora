public class Sum {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(sumFunction(num));
    }

    public static int sumFunction(int num) {
        int sum = 0;
        for (int i = 1; i <= num; i++) {
            sum = sum + i;
        }
        return sum;
    }
}


// Write a function called `sum` that returns the sum of numbers from zero to the given parameter