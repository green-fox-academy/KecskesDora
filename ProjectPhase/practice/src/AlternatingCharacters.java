import java.util.*;
public class AlternatingCharacters {

  public static void main(String[] args){
    System.out.println(alternatingCharacters("AABBCC"));
  }

  private static int alternatingCharacters(String s) {
    char[] sArr = s.toCharArray();
    String s2 = s.substring(1);
    char[] s2Arr = s2.toCharArray();

    List<Character> charDeleted = new ArrayList<>();

    for (int i = 0; i < s2Arr.length; i++) {
      if (sArr[i] == s2Arr[i]) {
        charDeleted.add(sArr[i]);
      }
    }
    return charDeleted.size();
  }

}

