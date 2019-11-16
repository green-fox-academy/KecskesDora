import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CountLines {
    public static void main(String[] args) {
        // Write a function that takes a filename as string,
        // then returns the number of lines the file contains.
        // It should return zero if it can't open the file, and
        // should not raise any error.

        //Scanner scanner = new Scanner(System.in);
        //System.out.println("enter a filename");
        //String filename = scanner.next();
        String filename = "my-file.txt";

        numberOfLines(filename);
    }
    public static void numberOfLines(String filename) {

        Path filePath = Paths.get(filename);
        List<String> lines;
        try {
            lines = Files.readAllLines(filePath);
            System.out.println(lines.size());
        } catch (IOException e) {
            System.out.println("0");
        }
    }
}

