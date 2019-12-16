import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {

        try {
            System.out.println(anagramTester("Alma", "a la m"));
        } catch (OneOfTheStringsIsMissingException e){
            System.out.println(e.getMessage());
        }
    }

    public static boolean anagramTester(String text, String text2) throws OneOfTheStringsIsMissingException {
        if (text == null || text2 == null || text == "" || text2 == "") {
            throw new OneOfTheStringsIsMissingException();
        }

        text = text.toLowerCase();
        text2 = text2.toLowerCase();

        String[] splitText = text.split(" ");
        String[] splitText2 = text2.split(" ");

        String textWithoutSpaces = "";
        for (String element : splitText) {
            textWithoutSpaces += element;
        }

        String text2WithoutSpaces = "";
        for (String element : splitText2) {
            text2WithoutSpaces += element;
        }

        char[] charArrayFromText = textWithoutSpaces.toCharArray();
        char[] charArrayFromText2 = text2WithoutSpaces.toCharArray();

        Arrays.sort(charArrayFromText);
        Arrays.sort(charArrayFromText2);

        return Arrays.equals(charArrayFromText, charArrayFromText2);
    }
}

