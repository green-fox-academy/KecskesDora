//Create a function named create palindrome following your current language's style guide.
// It should take a string, create a palindrome from it and then return it.

public class PalindromeBuilder {
    public static void main(String[] args) {
        System.out.println(createPalindrome("apa"));
    }
    public static String createPalindrome (String input) {
        String palindrome = input;
        for (int i = 0; i < input.length(); i++) {
            palindrome += input.charAt(i);
        }
        return palindrome;
    }
}
