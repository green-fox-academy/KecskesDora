//Create a function named search palindrome following your current language's style guide.
// It should take a string, search for palindromes that at least 3 characters long
// and return a list with the found palindromes.

import java.util.ArrayList;
import java.util.List;

public class PalindromeSearcher {
    public static void main(String[] args) {

        System.out.println(searchPalindrome("abcdedcba"));
    }

    public static List<String> searchPalindrome(String input) {

        List<String> palindromeList = new ArrayList<>();
        String currentSubstring = "";
        int palindromeCounter = 0;

        for (int palLength = 3; palLength <= input.length(); palLength++) {

            for (int indexOfSubstring = 0; indexOfSubstring <= input.length() - palLength; indexOfSubstring++) {
                currentSubstring = input.substring(indexOfSubstring, (indexOfSubstring + palLength));
                if (currentSubstring.equals(reverseMaker(currentSubstring)) == true) {
                    palindromeList.add(palindromeCounter, currentSubstring);
                    palindromeCounter++;
                }
            }
        }
        return palindromeList;
    }

    public static String reverseMaker(String substring) {
        String reversed = "";
        for (int i = 0; i < substring.length(); i++) {
            reversed += substring.charAt(substring.length() - 1 - i);
        }
        return reversed;
    }
}
