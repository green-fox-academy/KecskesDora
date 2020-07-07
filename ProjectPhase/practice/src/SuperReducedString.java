import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SuperReducedString {

  public static void main(String[] args) {

    System.out.println(superReducedString3("baaab"));

  }

  static String superReducedString3(String s) {
    List<Character> characters = new ArrayList<>();
    for (char c : s.toCharArray()) {
      characters.add(c);
    }
    int i = 0;
    do {
      if (characters.get(i).equals(characters.get(i + 1))) {
        characters.remove(i);
        characters.remove(i);
        if (i > 0) {
          i--;
        }
      } else {
        i++;
      }
    } while (i < characters.size() - 1);

    if (characters.isEmpty()) {
      return "Empty String";
    }
    StringBuilder builder = new StringBuilder();
    for (char c : characters) {
      builder.append(c);
    }
    return builder.toString();
  }

  static String superReducedString(String s) {
    Map<Integer, Long> map = s.chars().boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    StringBuilder result = new StringBuilder();
    for (Map.Entry<Integer, Long> chars : map.entrySet()) {
      int i;
      if (chars.getValue() % 2 == 1) {
        i = chars.getKey();
        result.append((char)i);
      }
    }
    return result.toString();
  }

  static String superReducedString2(String s) {
    Map<Character, Integer> map = fillMap(s);
    return characterBuilder(map);
  }

  static Map<Character, Integer> fillMap(String s) {
    Map<Character, Integer> map = new HashMap<>();
    for (Character c : s.toCharArray()) {
      if (!map.containsKey(c)) {
        map.put(c, 1);
      } else {
        map.put(c, map.get(c) + 1);
      }
    }
    return map;
  }

  static String characterBuilder(Map<Character, Integer> map) {
    StringBuilder result = new StringBuilder();
    for (Map.Entry<Character, Integer> chars : map.entrySet()) {
      if (chars.getValue() % 2 == 1) {
        Character c = chars.getKey();
        result.append(c);
      }
    }
    return result.toString();
  }
}
