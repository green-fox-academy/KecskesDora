import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;


public class Births {
    public static void main(String[] args){


        yearOfMostBirths("births.csv.txt");
    }

    public static void yearOfMostBirths(String fileName) {

        Path filePath = Paths.get(fileName);
        List<String> eachLines = new ArrayList<String>();

        try {
            eachLines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> datesOfBirthList = new ArrayList<>();

        for (int i = 0; i < eachLines.size(); i++) {
            String[] splitLinesArr = eachLines.get(i).split(";");
            datesOfBirthList.add(i, splitLinesArr[1]);
        }
        List<String> listOfYears = new ArrayList<>();

        for (int i = 0; i < datesOfBirthList.size(); i++) {
            String[] splitDatesArr = datesOfBirthList.get(i).split("-");
            listOfYears.add(i, splitDatesArr[0]);
        }

        Map<String, Integer> yearCounterMap = new HashMap<>();

        for(String year : listOfYears) {
            if (!yearCounterMap.containsKey(year)) {
                yearCounterMap.put(year, 1);
            } else {
                yearCounterMap.replace(year, yearCounterMap.get(year) + 1);
            }
        }

        int maxCounter = Collections.max(yearCounterMap.values());

        for (Map.Entry<String, Integer> yearCount : yearCounterMap.entrySet()) {
            if (yearCount.getValue() == maxCounter) {
                System.out.println(yearCount.getKey());
            }
        }
    }
}
// Create a function that
// - takes the name of a CSV file as a parameter,
//   - every row is in the following format: <person name>;<birthdate in YYYY-MM-DD format>;<city name>
// - returns the year when the most births happened.
//   - if there were multiple years with the same number of births then return any one of them

// You can find such a CSV file in this directory named births.csv
// If you pass "births.csv" to your function, then the result should be either 2006, or 2016.