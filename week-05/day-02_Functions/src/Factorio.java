public class Factorio {
    public static void main(String[] args) {
        int num = 4;
        System.out.println(factorioFunction(num));
    }
    public static int factorioFunction(int num) {
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
// - Create a function called `factorio`
//   that returns it's input's factorial