import java.util.Arrays;

public class Reverse {
    public static void main(String... args) {
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";
        String abcde = "abcde";
        System.out.println(reverse(reversed));
        //System.out.println(reverse2(abcde));
    }
    private static String reverse(String input) {
        String concat = "";
        for (int i = 0; i < input.length(); i++) {
            concat += input.charAt(input.length() - 1 - i);
        }
        return concat;
    }
    /*OR
    private static String reverse2(String input2) {
        char[] tempArray = input2.toCharArray();
        int left = 0;
        int right = input2.length() - 1;
        while (left < right) {
            char temp = tempArray[left];
            tempArray[left] = tempArray[right];
            tempArray[right] = temp;
            left++;
            right--;
        }
        String newString = Arrays.toString(tempArray);
        return newString;
    }*/
}

// Create a method that can reverse a String, which is passed as the parameter
// Use it on this reversed string to check it!
// Try to solve this using charAt() first, and optionally anything else after.