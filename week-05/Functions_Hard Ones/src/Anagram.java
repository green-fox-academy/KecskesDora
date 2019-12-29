//Create a function named is anagram following your current language's style guide.
//It should take two strings and return a boolean value depending on whether its an anagram or not.

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {

        System.out.println(isAnagram("Apple", "a Le pp"));
    }

    public static boolean isAnagram(String textA, String textB) {

        String[] splitTextA = textA.split(" ");
        String[] splitTextB = textB.split(" ");

        StringBuilder builderA = new StringBuilder();
        for (String element : splitTextA) {
            builderA.append(element);
        }
        String textAWithoutSpaces = builderA.toString();

        StringBuilder builderB = new StringBuilder();
        for (String element : splitTextB) {
            builderB.append(element);
        }
        String textBWithoutSpaces = builderB.toString();

        char[] lettersOfTextA = textAWithoutSpaces.toLowerCase().toCharArray();
        char[] lettersOfTextB = textBWithoutSpaces.toLowerCase().toCharArray();

        Arrays.sort(lettersOfTextA);
        Arrays.sort(lettersOfTextB);

        return Arrays.equals(lettersOfTextA, lettersOfTextB);
    }
}
