import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoStrings {

  public static void main(String[] args){
    System.out.println(twoStrings("alma", "almafa"));
    System.out.println(twoStrings2("alma", "almafa"));
  }
  // Complete the twoStrings function below.
  static String twoStrings(String s1, String s2) {
    char[] s1Arr = s1.toCharArray();
    char[] s2Arr = s2.toCharArray();

    for (char c1 : s1Arr) {
      for (char c2 : s2Arr) {
        if (c1 == c2) {
          return "YES";
        }
      }
    }
    return "NO";
  }

  static String twoStrings2(String s1, String s2) {
    for (char ch : s1.toCharArray()) {
      String stringCh = String.valueOf(ch);
      if (s2.contains(stringCh)) {
        return "YES";
      }
    }
    return "NO";
  }

  static String twoStrings3(String s1, String s2) {
    String shorter;
    String longer;
    if (s1.length() > s2.length()) {
      longer = s1;
      shorter = s2;
    } else {
      longer = s2;
      shorter = s1;
    }

    Set<Character> set = new HashSet<>();
    for (char c : shorter.toCharArray()) {
      set.add(c);
    }
    for (int i = 0; i < longer.length(); i++) {
      if (set.contains(longer.charAt(i))) {
        return "YES";
      }
    }
    return "NO";
  }

}