public class Doubling {
    public static void main(String[] args) {
        int baseNum = 123;
        int doubleNum = doubleFunction(baseNum);
        System.out.println(doubleNum);
    }
    public static int doubleFunction(int baseNum) {
        int doubleNum = baseNum * 2;
        return doubleNum;
    }
}

// - Create an integer variable named `baseNum` and assign the value `123` to it
// - Create a function called `doubling` that doubles it's input parameter and returns with an integer
// - Print the result of `doubling(baseNum)`