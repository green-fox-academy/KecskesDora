public class Matrix {
    public static void main(String[] args) {

        int[][] matrix = new int[4][4];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else {
                    matrix[i][j] = 0;
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
//   1 0 0 0
//   0 1 0 0
//   0 0 1 0
//   0 0 0 1

      /*  int j2 =0;
        int[][] matrix2 = new int[4][4];

        for (int i2 = 0; i2 < 4; i2++) {

                if (i2 == j2) {
                    matrix2[i2][j2] = 1;
                } else {
                    matrix2[i2][j2] = 0;
                }

                System.out.print(matrix2[i2][j2] + " ");

                if (i2 == 3 && j2 < 3) {
                System.out.println();
                i2=0;
                }

                j2=j2+1;
        }
    }
}*/