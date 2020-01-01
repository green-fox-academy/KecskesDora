import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TicTacToe {

    public static void main(String[] args) {
        // Write a function that takes a filename as a parameter
        // The file contains an ended Tic-Tac-Toe match
        // We have provided you some example files (draw.txt, win-x.txt, win-o.txt)
        // Return "X", "O" or "Draw" based on the input file

        System.out.println(ticTacResult("C:\\Users\\Dóri\\Greenfox\\KecskesDora\\week-07\\day-03_File IO_Optional\\assets\\win-o.txt"));
        // Should print "O"

        System.out.println(ticTacResult("C:\\Users\\Dóri\\Greenfox\\KecskesDora\\week-07\\day-03_File IO_Optional\\assets\\win-x.txt"));
        // Should print "X"

        System.out.println(ticTacResult("C:\\Users\\Dóri\\Greenfox\\KecskesDora\\week-07\\day-03_File IO_Optional\\assets\\draw.txt"));
        // Should print "Draw"
    }

    public static String ticTacResult(String filename) {
        List<String> linesOfMatch = readFile(filename);

        String[][] matrixOfMatch = new String[linesOfMatch.size()][];
        for (int i = 0; i < linesOfMatch.size(); i++) {
            matrixOfMatch[i] = linesOfMatch.get(i).split("");
        }

        String result = "";
        for (int i = 0; i < matrixOfMatch.length; i++) {
            if (matrixOfMatch[i][0].equals(matrixOfMatch[i][1]) && matrixOfMatch[i][0].equals(matrixOfMatch[i][2])) {
                result = matrixOfMatch[i][0];
                break;
            } else if (matrixOfMatch[0][i].equals(matrixOfMatch[1][i]) && matrixOfMatch[0][i].equals(matrixOfMatch[2][i])) {
                result = matrixOfMatch[0][i];
                break;
            } else if (matrixOfMatch[0][0].equals(matrixOfMatch[1][1]) && matrixOfMatch[0][0].equals(matrixOfMatch[2][2])) {
                result = matrixOfMatch[0][0];
                break;
            } else if (matrixOfMatch[0][2].equals(matrixOfMatch[1][1]) && matrixOfMatch[i][2].equals(matrixOfMatch[2][0])) {
                result = matrixOfMatch[0][2];
                break;
            } else {
                result = "Draw";
                break;
            }
        }
        return result;
    }

    public static List<String> readFile (String filename){
        Path filePath = Paths.get(filename);
        List<String> lines = new ArrayList<>();
        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }
}

