import java.util.Arrays;

public class LeftRotation {

  public static void main(String args[]) {

    int[] a = {1, 2, 3, 4};
    System.out.println(Arrays.toString(rotLeft(a, 1)));

  }

  static int[] rotLeft(int[] a, int d) {

    int l = a.length;
    d = d % l;

    for (int i = 0; i < d; i++) {
      int first = a[0];
      int j;
      for (j = 0; j < l - 1; j++) {
        a[j] = a[j + 1];
      }
      a[j] = first;
    }
    return a;
  }

}
