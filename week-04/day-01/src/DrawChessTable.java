public class DrawChessTable {
    public static void main(String[] args) {

        for (int row = 1; row <= 8; row++) {

        for (int col = 1; col <= 8; col++) {
            if ((col % 2 == 0) && (row % 2 == 0)) {
                System.out.print("%");
            } else if ((col % 2 != 0) && (row % 2 == 0)) {
                System.out.print(" ");
            } else if ((col % 2 == 0) && (row % 2 != 0)) {
                System.out.print(" ");
            } else{
                System.out.print("%");
            }
            }
            System.out.println();
        }
    }
}

// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %
// % % % %
//  % % % %