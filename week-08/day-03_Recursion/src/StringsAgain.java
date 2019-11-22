//Given a string, compute recursively a new string where all the 'x' chars have been removed.

public class StringsAgain {
    public static void main(String[] args) {
        System.out.println(removeX("abcxxXXabc"));
    }
    public static String removeX(String text) {
        if (text.length() == 0) {
            return text;
        }
        if (String.valueOf(text.charAt(0)).equals("x")) {
            return removeX(text.substring(1));
        } else {
            return text.charAt(0) + removeX(text.substring(1));
        }
    }
}
