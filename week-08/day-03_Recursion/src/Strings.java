//Given a string, compute recursively (no loops) a new string
// where all the lowercase 'x' chars have been changed to 'y' chars.

public class Strings {
    public static void main(String... args) {
        System.out.println(newStringMaker("abcdxxxXabcd"));
        System.out.println("abcdxxxXabcd".replace("x", "y"));
    }
    
    public static String newStringMaker(String text) {
        if (text.contains("x") == false) {
            return text;
        }
        return newStringMaker(text.replaceFirst("x", "y"));
    }
}
