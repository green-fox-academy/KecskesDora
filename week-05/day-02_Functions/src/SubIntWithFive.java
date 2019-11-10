
public class SubIntWithFive {
    public static void main(String[] args) {
        int number = 5;
        int[] numbersArray = new int[]{5, 12, 55, 61, 70};

        boolean dividableByNumber = false;
        for (int i = 0; i < 5; i++) {
            if (numbersArray[i] % number == 0) {
                System.out.print(i);
                dividableByNumber = true;
            }
        }
        if (dividableByNumber == false) {
            System.out.println("[]");
        }
    }
}