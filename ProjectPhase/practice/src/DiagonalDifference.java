import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {

  public static void main(String[] args) {

    List<Integer> arr1 = new ArrayList<>(Arrays.asList(1, 6, 9));
    List<Integer> arr2 = new ArrayList<>(Arrays.asList(7, 1, 8));
    List<Integer> arr3 = new ArrayList<>(Arrays.asList(9, 9, 1));
    List<List<Integer>> arr = new ArrayList<>(Arrays.asList(arr1, arr2, arr3));

    System.out.println(diagonalDifference(arr));
  }

  public static int diagonalDifference(List<List<Integer>> arr) {
    int a = 0;
    int b = 0;
    for (int i = 0; i < arr.size(); i++) {
      for (int j = 0; j < arr.get(i).size(); j++) {
        a = i == j ? (a + arr.get(i).get(j)) : a;
        b = (i + j == arr.size() - 1) ? (b + arr.get(i).get(j)) : b;
      }
    }
    return Math.abs(a - b);
  }

}
