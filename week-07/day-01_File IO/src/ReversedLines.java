import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReversedLines {

    public static void main(String[] args) {
        // Create a method that decrypts reversed-lines.txt
        System.out.println(decryptReversed("reversed-lines.txt"));
    }
    public static String decryptReversed(String fileName){

        Path filePath = Paths.get(fileName);
        List<String> originalLines;

        try {
            originalLines = Files.readAllLines(filePath);
            String reversedLines = "";

            for (String line : originalLines){

                for (int i = originalLines.size(); i > 0 ; i++) {
                    reversedLines += line.charAt(line.length() -1 - i);
                }
                reversedLines += "\n";
            }
            return reversedLines;
        } catch (Exception e) {
            return "0";
        }
    }
}