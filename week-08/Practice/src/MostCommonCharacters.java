//Write a function that takes a filename as a parameter.
// Return the 2 most common characters and their occurrences in the file's content.
//
//If the file does not exist throw an exception with the following message: "File does not exist!"

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class MostCommonCharacters {
    public static void main(String[] args) {

        findCharacters("countchar.txt");
    }

    public static void findCharacters(String filename) {

        List<String> lines = new ArrayList<>();

        try {
             lines = Files.readAllLines(Paths.get(filename));
        } catch (IOException e) {
            System.out.println("File does not exist!");
        }

        String allText = "";

        for (int i = 0; i < lines.size(); i++) {
            allText += lines.get(i);
        }

        char[] charArray = allText.toCharArray();
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (char c : charArray) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }
        int memoryValue = 0;
        char memoryKey = '\0';
        HashMap<Character, Integer> twoMostCommonCharMap = new HashMap<>();

        for (int i = 0; i < 2; i++) {
            for (Map.Entry<Character, Integer> charCounters : charCountMap.entrySet()) {
                if (charCounters.getValue() == Collections.max(charCountMap.values())) {
                    memoryValue = charCounters.getValue();
                    memoryKey = charCounters.getKey();
                }
            }
            charCountMap.remove(memoryKey);
            twoMostCommonCharMap.put(memoryKey, memoryValue);
        }
        for (Map.Entry<Character, Integer> charCounters : twoMostCommonCharMap.entrySet()) {
            System.out.printf("\"%s\" : %d\n", charCounters.getKey(), charCounters.getValue());
        }
    }
}
