import java.util.HashMap;
import java.util.Map;

public class SocketMerchant {

  static int sockMerchant(int n, int[] ar) {
    Map<Integer, Integer> numberOfColors = new HashMap<>();
    for (int color : ar) {
      if (numberOfColors.containsKey(color)) {
        numberOfColors.put(color, numberOfColors.get(color) + 1);
      } else {
        numberOfColors.put(color, 1);
      }
    }
    int counter = 0;
    for (int numberOfColor : numberOfColors.values()) {
      counter += numberOfColor / 2;
    }
    return counter;
  }

  public static void main(String[] args) {
    int n = 9;
    int[] arr = {10, 20, 20, 10, 10, 3, 50, 10, 20};

    System.out.println(sockMerchant(n, arr));
  }

}
