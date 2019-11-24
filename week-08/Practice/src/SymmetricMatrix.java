//Create a function named isSymmetric that takes an n×n integer matrix (two dimensional array/list) as a parameter
// and returns true if the matrix is symmetric or false if it is not.
//
//Symmetric means it has identical values along its diagonal axis from top-left to bottom-right, as in the first example.

public class SymmetricMatrix {
    public static void main(String[] args) {

        int n = 3;
        int[][] matrix1 = {
                {1, 0, 1},
                {0, 2, 2},
                {1, 2, 5}
        };
        int[][] matrix2 = {
                {7, 7, 7},
                {6, 5, 7},
                {1, 2, 1}
        };

        System.out.println(isSymmetric(matrix1));
        System.out.println(isSymmetric(matrix2));
    }

    public static boolean isSymmetric(int[][] matrix) {
        int isEqualCounter = 0;
        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix.length; columnIndex++) {
                if (matrix[rowIndex][columnIndex] == matrix[columnIndex][rowIndex]) {
                    isEqualCounter++;
                }
            }
        }
        if (isEqualCounter == (matrix.length * matrix.length)) {
            return true;
        } else {
            return false;
        }
    }
}
