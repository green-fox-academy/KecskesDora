import java.util.Arrays;

public class Reverse {
    public static String main(String... args) {
        String reversed = ".eslaf eb t'ndluow ecnetnes siht ,dehctiws erew eslaf dna eurt fo sgninaem eht fI";


            char[] tempArray = reversed.toCharArray();
            int left = 0;
            int right = reversed.length() - 1;
            while (left < right) {
                char temp = tempArray[left];
                tempArray[left] = tempArray[right];
                tempArray[right] = temp;
                left++;
                right--;
            }
            reversed = Arrays.toString(tempArray);
            //return reversed;
        System.out.println(reversed);
    }
}

// Create a method that can reverse a String, which is passed as the parameter
// Use it on this reversed string to check it!
// Try to solve this using charAt() first, and optionally anything else after.