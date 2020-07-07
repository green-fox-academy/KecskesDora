import java.util.*;

public class BirthdayCakeCandles {

  public static void main(String[] args) {

    int[] arr = {1, 2, 4, 4};
    System.out.println(birthdayCakeCandles(arr));

  }

  static int birthdayCakeCandles(int[] arr) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int n : arr) {
      if (!map.containsKey(n)) {
        map.put(n, 1);
      } else {
        map.put(n, map.get(n) + 1);
      }
    }
    return Collections.max(map.values());
  }

}
