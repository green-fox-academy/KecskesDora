import java.util.HashMap;
import java.util.HashSet;

public class MakingAnagrams {

  public static void main(String[] args) {

    System.out.println(makeAnagram("abc", "abcddef"));

  }

  static int makeAnagram(String s1, String s2) {

    HashSet<Character> charSet = new HashSet<>();
    fillSet(charSet, s1);
    fillSet(charSet, s2);

    HashMap<Character, Integer> s1Map = createMap(s1);
    HashMap<Character, Integer> s2Map = createMap(s2);

    int counter = 0;
    int s1Value;
    int s2Value;

    for (Character ch : charSet) {
      if (s1Map.get(ch) == null) {
        s1Value = 0;
      } else {
        s1Value = s1Map.get(ch);
      }
      if (s2Map.get(ch) == null) {
        s2Value = 0;
      } else {
        s2Value = s2Map.get(ch);
      }
      counter += Math.abs(s1Value - s2Value);
    }
    return counter;
  }

  static HashMap<Character, Integer> createMap(String s) {
    HashMap<Character, Integer> sMap = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (!sMap.containsKey(c)) {
        sMap.put(c, 1);
      } else {
        sMap.put(c, sMap.get(c) + 1);
      }
    }
    return sMap;
  }

  static HashSet<Character> fillSet(HashSet<Character> set, String s) {
    for (char c : s.toCharArray()) {
      set.add(c);
    }
    return set;
  }

}
