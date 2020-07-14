import java.util.Scanner;

public class StringsIntro {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    String A = scanner.next();
    String B = scanner.next();

    System.out.println(sumOfLength(A, B));
    System.out.println(whichIsGreater(A, B));
    System.out.println(addStrings(A, B));

  }

  private static int sumOfLength(String A, String B) {
    return A.length() + B.length();
  }

  private static String whichIsGreater(String A, String B) {
    if (A.charAt(0) > B.charAt(0)) {
      return "Yes";
    }
    return "No";
  }

  private static String addStrings(String A, String B) {
    return capitalizeFirst(A) + " " + capitalizeFirst(B);
  }

  private static String capitalizeFirst(String A) {
    return A.substring(0, 1).toUpperCase() + A.substring(1);
  }

}
