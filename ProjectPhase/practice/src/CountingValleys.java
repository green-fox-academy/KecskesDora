import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingValleys {

  static int countingValleys(int n, String s) {
    int valleyCounter = 0;
    int k = 0;
    int alt = 0;
    List<Integer> levelOfSteps = new ArrayList<>();

    for (int i = 0; i < n; i++) {

      if (String.valueOf(s.charAt(i)).equals("U")) {
        alt++;
      } else {
        alt--;
      }
      levelOfSteps.add(alt);
      if (levelOfSteps.get(k) == 0 && levelOfSteps.get(k - 1) < 0) {
        levelOfSteps.clear();
        valleyCounter++;
        k = -1;
      }
      k++;
    }
    return valleyCounter;
  }

  public static void main(String[] args) {

    System.out.println(countingValleys(0, ""));

  }

}
