import java.util.Arrays;

public class CircularArrayRotation {

  public static void main(String[] args) {

    int[] a = {3, 4, 5};
    int k = 2;
    int[] m = {1, 2};
    System.out.println(circularArrayRotation(a, k, m));
  }

  static String circularArrayRotation(int[] a, int k, int[] queries) {
    int length = a.length;
    k = k % length;
    int last;
    for (int i = 0; i < k; i++) {
      last = a[length -1];
      for (int j = length - 1; j > 0; j--) {
        a[j] = a[j - 1];
      }
      a[0] = last;
    }
    length = queries.length;
    int[] result = new int[length];
    for (int i = 0; i < length; i++) {
      result[i] = a[queries[i]];
    }
    return Arrays.toString(result);
  }

}
