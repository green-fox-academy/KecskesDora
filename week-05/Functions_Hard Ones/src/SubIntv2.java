public class SubIntv2 {
    public static void main(String[] args) {
        int a = 1;
        int[] numbersArray = new int[]{1, 11, 34, 52, 61};
        subInt(a, numbersArray);
    }

    private static void subInt(int number, int[] numbersArray) {

        String[] stringNumbersArray = new String[numbersArray.length];
        String stringNumber = String.valueOf(number);

        for (int i = 0; i < numbersArray.length; i++) {
            stringNumbersArray[i] = String.valueOf(numbersArray[i]);
        }

        //print the elements of the array:
        //System.out.println(Arrays.toString(stringNumbersArray));
        //System.out.println(Arrays.toString(numbersArray));

        boolean containsNumber = false;

        for (int i = 0; i < stringNumbersArray.length; i++) {
        String indices = "";
            if (stringNumbersArray[i].contains(stringNumber) == true) {
                indices += (i);
                containsNumber = true;
            }
        }
        if (containsNumber == false) {
            System.out.println("[]");
        }
        return;
    }
}

//.contains()
//.contentEquals
// -1 az érték akkor nincs benne az a karakter
//System.out.println(stringNumbers[0].contentEquals("1"));
//integer.toString

//  Create a function that takes a number and an array of integers as a parameter
//  Returns the indices of the integers in the array of which the first number is a part of
//  Or returns an empty array if the number is not part of any of the integers in the array

//  Example:
//System.out.println(subInt(1, new int[] {1, 11, 34, 52, 61}));
//  should print: `[0, 1, 4]`
// System.out.println(subInt(9, new int[] {1, 11, 34, 52, 61}));
//  should print: '[]'