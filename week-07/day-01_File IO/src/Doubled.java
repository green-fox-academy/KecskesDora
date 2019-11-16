import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Doubled {

    public static void main(String[] args) {
        // Create a method that decrypts the duplicated-chars.txt
        System.out.println(decryptDuplications("duplicated-chars.txt"));
    }

    public static String decryptDuplications(String fileName) {

        Path filepath = Paths.get(fileName);
        List<String> originalLines;

        try {
            originalLines = Files.readAllLines(filepath);
        } catch (Exception e) {
            return "0";
        }
        String decryptedLines = "";

        for (String line : originalLines) {

            for (int i = 0; i < line.length(); i += 2) {
                decryptedLines += line.charAt(i);
            }
            decryptedLines += "\n";
        }
        return decryptedLines;
    }
}