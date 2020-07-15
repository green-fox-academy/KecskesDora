import java.text.DecimalFormat;

public class PlusMinus {

  public static void main(String[] args) {

    int[] arr = {1, 1, 0, -1, -1};
    plusMinus(arr);
  }

  static void plusMinus(int[] arr) {
    int positives = 0;
    int zero = 0;
    int negatives = 0;

    for (int number : arr) {
      if (number > 0) {
        positives++;
      } else if (number < 0) {
        negatives++;
      } else {
        zero++;
      }
    }
    int l = arr.length;
    System.out.printf("%.5f%n%.5f%n%.5f", (double) positives / l, (double) negatives / l, (double) zero / l);
  }

}
