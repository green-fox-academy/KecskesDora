import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SwearWords {
    public static void main(String[] args) {
        String filename = "C:\\Users\\Dóri\\Greenfox\\KecskesDora\\week-08\\Practice\\assets\\content.txt";
        String[] WordsToRemove = {"fuck", "bloody", "cock", "shit", "fucker", "fuckstick", "asshole", "dick", "piss", "cunt"};

        System.out.println(removeWords(readFile(filename), WordsToRemove));
        System.out.println(removeWordsV2(readFile(filename), WordsToRemove));
        //Not working well...
    }

    public static int removeWords(List<String> lines, String[] words) {
        int removedWords = 0;
        ArrayList<String> newLines = new ArrayList<>();
        String newLine = "";

        for (int i = 0; i < lines.size(); i++) {
            //lines.get(i).toLowerCase().replace(".", "").replace(",", "");
            newLine = lines.get(i).toLowerCase().replace(".", "");
            newLine = newLine.replace(",", "");
            String[] splitLines = newLine.split(" ");
            for (String word : words) {
                for (String splitLine : splitLines) {
                    if (splitLine.equals(word)) {
                        lines.remove(splitLine);
                        removedWords++;
                    }
                }
            }
        }
        for (String line : lines) {
            System.out.println(line);
        }
        return removedWords;
    }

    public static int removeWordsV2(List<String> lines, String[] words) {
        int removedWords = 0;
        ArrayList<String> newLines = new ArrayList<>();

        for (String line : lines) {
            line = line.toLowerCase().replace(".", "").replace(",", "");
            for (String word : words) {
                if (line.contains(word)) {
                    line = line.replace(word, "");
                    removedWords++;
                }
            }
        }
        for (String line : newLines) {
            System.out.println(line);
        }
        return removedWords;
    }

    public static List<String> readFile(String filename) {
        Path filePath = Paths.get(filename);
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.err.println("Unable to read file: " + filename);
        }
        return lines;
    }

    public void writeFile(String filename, List<String> newText) {
        try {
            Files.write(Paths.get(filename), newText);
        } catch (IOException e){
            System.err.println("Unable to write file " + filename);
        }
    }
}
