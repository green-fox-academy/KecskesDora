import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CopyFile {
    public static void main(String[] args) {

        System.out.println(copyContent("my-file.txt", "my-file2.txt"));
    }

    public static boolean copyContent(String fileName1, String fileName2) {
        Path filePath1 = Paths.get(fileName1);
        Path filePath2 = Paths.get(fileName2);

        List<String> content1;
        List<String> content2;

        try {
            content1 = Files.readAllLines(filePath1);
            content2 = Files.readAllLines(filePath2);

            for (int i = 0; i < content2.size(); i++) {
              content1.add(content2.get(i));
              //OR:
              //Files.copy(Paths.get(fileName1), Paths.get(fileName2)));
            }
            Files.write(filePath1, content1);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}
// Write a function that copies the contents of a file into another
// It should take the filenames as parameters
// It should return a boolean that shows if the copy was successful