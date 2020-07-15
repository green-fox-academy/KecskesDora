import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class EqualizeArray {

  public static void main(String[] args) {

    int[] arr = {3, 3, 2, 1, 3};
    System.out.println(equalizeArray(arr));

  }

  static int equalizeArray(int[] arr) {
    Map<Integer, Integer> intMap = new HashMap<>();
    for (Integer number : arr) {
      if (intMap.containsKey(number)) {
        intMap.put(number, intMap.get(number) + 1);
      } else {
        intMap.put(number, 1);
      }
    }
    return arr.length - Collections.max(intMap.values());
  }

}
