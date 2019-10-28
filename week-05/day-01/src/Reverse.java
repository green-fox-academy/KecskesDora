public class Reverse {
    public static void main(String[] args) {
        int[] aj = {3, 4, 5, 6, 7};
        int l = 0;
        int r = aj.length - 1; // = 4
        while (l < r) {
            int temp = aj[l];
            aj[l] = aj[r];
            aj[r] = temp;
            l++;
            r--;
        }
        for (int i = 0; i < aj.length; i++) {
            System.out.println(aj[i]);
        }
    }
}
// - Create an array variable named `aj`
//   with the following content: `[3, 4, 5, 6, 7]`
// - Reverse the order of the elements in `aj`
// - Print the elements of the reversed `aj`