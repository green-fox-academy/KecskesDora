//Create a function named rotateMatrix that takes an n×n integer matrix (array of arrays) as parameter
// and returns a matrix which elements are rotated 90 degrees clockwise.

public class MatrixRotate {
    public static void main(String[] args) {
        
        printMatrix(createMatrix(5));
        System.out.println();
        printMatrix(rotateMatrix(createMatrix(5)));
    }

    public static int[][] rotateMatrix(int[][] matrix) {

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix.length; columnIndex++) {
                matrix[rowIndex][columnIndex] = matrix [matrix.length - 1 - columnIndex][columnIndex];
            }
        }
        return matrix;
    }

    public static int[][] createMatrix(int size) {

        int[][] matrix = new int[size][size];

        for (int rawIndex = 0; rawIndex < size; rawIndex++) {
            for (int columnIndex = 0; columnIndex < size; columnIndex++) {
                matrix[rawIndex][columnIndex] = rawIndex;
            }
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {

        for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < matrix[rowIndex].length; columnIndex++) {
                System.out.print(matrix[rowIndex][columnIndex] + " ");
            }
            System.out.println();
        }
    }
}
