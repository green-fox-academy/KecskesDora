import java.util.Arrays;

public class SubInt {
    public static void main(String[] args) {
        int number = 1;
        int[] numbersArray = new int[] {1, 11, 34, 52, 61};
        subInt(number, numbersArray);
        System.out.println();
    }

    public static int[] subInt(int number, int[] numbersArray) {
        String[] stringNumberArray = new String[numbersArray.length];
        String stringNumber = String.valueOf(number);

        for (int i = 0; i < numbersArray.length ; i++) {
            stringNumberArray[i] = String.valueOf(numbersArray[i]);
        }
        System.out.println(Arrays.toString(stringNumberArray));

        boolean containsNumber = false;
        for (int i = 0; i < stringNumberArray.length; i++) {
            boolean arrayElementContainsNumber;
            if (stringNumberArray[i].contains(stringNumber) == true) {

                System.out.print(i + ", ");
                containsNumber = true;
             }
                //.contains()
                //.contentEquals
        }
        if (containsNumber == false) {
            System.out.println("[]");
        }
        return numbersArray;
            // -1 az érték akkor nincs benne az a karakter
        }
        //System.out.println(stringNumbers[0].contentEquals("1"));
}
       /* boolean dividableByNumber = false;
        for (int i = 0; i < 5; i++) {

            if (numbers[i] % number == 0) {
                System.out.print(i);
                dividableByNumber = true;
            }
        }
        if (dividableByNumber == false) {
            System.out.println("[]");
        }
        //System.out.println(dividableByNumber);
        return;
        //integer.toString*/


       //  Create a function that takes a number and an array of integers as a parameter
        //  Returns the indices of the integers in the array of which the first number is a part of
        //  Or returns an empty array if the number is not part of any of the integers in the array

        //  Example:
        //System.out.println(subInt(1, new int[] {1, 11, 34, 52, 61}));
        //  should print: `[0, 1, 4]`
       // System.out.println(subInt(9, new int[] {1, 11, 34, 52, 61}));
        //  should print: '[]'