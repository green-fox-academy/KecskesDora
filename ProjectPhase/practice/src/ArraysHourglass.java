import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArraysHourglass {

  public static void main(String[] args) {

    int[][] arr = {
      {1, 1, 1, 0, 0, 0},
      {0, 1, 0, 0, 0, 0},
      {1, 1, 1, 0, 0, 0},
      {0, 0, 2, 4, 4, 0},
      {0, 0, 0, 2, 0, 0},
      {0, 0, 1, 2, 4, 0},
    };
    System.out.println(hourglassSum2(arr));
  }

  static int hourglassSum(int[][] arr) {
    List<Integer> sums = new ArrayList<>();
    int counter = 0;
    for (int i = 1; i < arr.length - 1; i++) {
      for (int j = 1; j < arr.length - 1; j++) {
        for (int k = i - 1; k < i + 2; k++) {
          for (int l = j - 1; l < j + 2; l++) {
            if (k == i - 1 || k == i + 1) {
              counter += arr[k][l];
            } else if (k == i && l == j) {
              counter += arr[k][l];
            }
          }
        }
        sums.add(counter);
        counter = 0;
      }
    }
    return Collections.max(sums);
  }

  //ez nem jó:
  static int hourglassSum2(int[][] arr) {
    List<Integer> sums = new ArrayList<>();
    int[][] hourGlass = new int[3][3];
    for (int i = 1; i < arr.length - 1; i++) {
      for (int j = 1; j < arr.length - 1; j++) {
        for (int k = i - 1; k < i + 2; k++) {
          for (int l = j - 1; l < j + 2; l++) {
            for (int m = 0; m < 3; m++) {
              for (int n = 0; n < 3; n++) {
                hourGlass[m][n] = arr[k][l];
              }
            }
            }
          }
        sums.add(countHourGlass(hourGlass));
        }
      }
    return Collections.max(sums);
  }

  static int countHourGlass(int[][] arr) {
    int counter = 0;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        counter += arr[i][j];
      }
    }
    return counter;
  }
}
