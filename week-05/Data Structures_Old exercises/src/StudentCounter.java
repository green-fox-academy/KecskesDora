
import java.util.*;

public class StudentCounter {
    public static void main(String... args) {
        List<Map<String, Object>> listOfMaps = new ArrayList<>();

        // Given this list of hash maps...

        Map<String, Object> row0 = new HashMap<>();
        row0.put("name", "Theodor");
        row0.put("age", 9.5);
        row0.put("candies", 2);
        listOfMaps.add(row0);

        Map<String, Object> row1 = new HashMap<>();
        row1.put("name", "Paul");
        row1.put("age", 10);
        row1.put("candies", 1);
        listOfMaps.add(row1);

        Map<String, Object> row2 = new HashMap<>();
        row2.put("name", "Mark");
        row2.put("age", 7);
        row2.put("candies", 3);
        listOfMaps.add(row2);

        Map<String, Object> row3 = new HashMap<>();
        row3.put("name", "Peter");
        row3.put("age", 12);
        row3.put("candies", 5);
        listOfMaps.add(row3);

        Map<String, Object> row4 = new HashMap<>();
        row4.put("name", "Olaf");
        row4.put("age", 12);
        row4.put("candies", 7);
        listOfMaps.add(row4);

        Map<String, Object> row5 = new HashMap<>();
        row5.put("name", "George");
        row5.put("age", 3);
        row5.put("candies", 2);
        listOfMaps.add(row5);

        // Display the following things:
        //  - The names of students who have more than 4 candies

        String namesWithMoreThan4Can = "";
        double sumOfAgeWithLessThan5Can = 0.0;

        for (int i = 0; i < listOfMaps.size(); i++) {
            // convert the object(value) pairs of "candies"(keys) to integer:
            int valuesOfCandies = (int) listOfMaps.get(i).get("candies");

            if (valuesOfCandies > 4) {
                namesWithMoreThan4Can += listOfMaps.get(i).get("name") + "\n";

            // - The sum of the age of people who have less than 5 candies
            } else if (valuesOfCandies < 5) {
                try {
                    sumOfAgeWithLessThan5Can += (double) listOfMaps.get(i).get("age");
                } catch (Exception e){
                    sumOfAgeWithLessThan5Can += (int) listOfMaps.get(i).get("age");
                }
            }
        }
        System.out.println("They had more than 4 candies: " + "\n" + namesWithMoreThan4Can);
        System.out.println("Sum of the age of people who have less than 5 candies: " +  sumOfAgeWithLessThan5Can);
    }
}