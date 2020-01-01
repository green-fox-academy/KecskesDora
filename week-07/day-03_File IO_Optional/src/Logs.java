// Read all data from 'log.txt'.
// Each line represents a log message from a web server
// Write a function that returns an array with the unique IP adresses.
// Write a function that returns the GET / POST request ratio.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Logs {
    public static void main(String[] args) {
        findUniqueIP("C:\\Users\\Dóri\\Greenfox\\KecskesDora\\week-07\\day-03_File IO_Optional\\assets\\log.txt");
        calculateRatio("C:\\Users\\Dóri\\Greenfox\\KecskesDora\\week-07\\day-03_File IO_Optional\\assets\\log.txt");
    }

    public static void findUniqueIP (String fileName) {

        Path filePath = Paths.get(fileName);
        List<String> eachLines = new ArrayList<>();

        try {
            eachLines = Files.readAllLines(filePath);
        } catch (IOException e){
            e.printStackTrace();
        }

        List<String> IPAddresses = new ArrayList<>();           // ArrayList for IP address list below

        for (int i = 0; i < eachLines.size(); i++) {
            String[] splitLines = eachLines.get(i).split(" ");   // split each line by spaces
            IPAddresses.add(i, splitLines[8]);                         // add the IP addresses into an empty Array
            }                                                             // (IP address is the 8. element of the splitted line)

        HashSet<String> setOfUniqueIPAddresses = new HashSet<>(IPAddresses); // HashSet<> contains unique elements only
                                                                            // put IP Adresses into a HashSet
        String[] uniqueIPAddresses = new String[setOfUniqueIPAddresses.size()]; // define a String[], which size equals to HashSet's size

        uniqueIPAddresses = setOfUniqueIPAddresses.toArray(uniqueIPAddresses); // convert HashSet<> to Array
        System.out.println(Arrays.toString(uniqueIPAddresses));
    }

    public static void calculateRatio(String fileName) {

        Path filePath = Paths.get(fileName);
        List<String> eachLines = new ArrayList<>();

        try {
            eachLines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int numberOfGET = 0;
        int numberOfPOST = 0;

        for (int i = 0; i < eachLines.size(); i++) {

            if (eachLines.get(i).contains("GET")) {
                numberOfGET += 1;
            } else if (eachLines.get(i).contains("POST")){
                numberOfPOST += 1;
            }
        }
        System.out.println(numberOfGET + " / " + numberOfPOST);
    }
}
