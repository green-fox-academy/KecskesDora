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

        boolean containsNumber = false;

        for (int i = 0; i < stringNumbersArray.length; i++) {
        String indices = "";
            if (stringNumbersArray[i].contains(stringNumber)) {
                indices += (i);
                containsNumber = true;
            }
        }
        if (!containsNumber) {
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
