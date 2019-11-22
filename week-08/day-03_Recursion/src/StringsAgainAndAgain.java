//Given a string, compute recursively a new string where all the adjacent chars are now separated by a *

public class StringsAgainAndAgain {
    public static void main(String[] args) {
        System.out.println(separateChars("Kecske ment a kiskerbe."));
    }

   public static String separateChars(String text) {
        if (text.length() == 1) {
            return text;
        } else {
            return text.charAt(0) + "*" + separateChars(text.substring(1));
        }
    }
}
