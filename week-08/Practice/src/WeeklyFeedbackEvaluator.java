//Write a method which can read and parse a file containing information about weekly feedback from apprentices about a mentor.
//
//The mentor is rated in 4 different metrics, those are respectively (matReview, presSkills, helpfulness, explanation) separated with 1 space:
//
//m = matReview
//p = presSkills
//h = helpfulness
//e = explanation

//the method must return a map/dictionary containing the average rating (in each metric) of the mentor.

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeeklyFeedbackEvaluator {
    public static void main(String[] args) {
        calculateAverageRating(readFile("C:\\Users\\Dóri\\Greenfox\\KecskesDora\\week-08\\Practice\\assets\\responses.txt"));
    }

    public static void calculateAverageRating(List<String> lines) {
        HashMap<String, Float> mapOfRatings = new HashMap<>();
        int m = 0;
        int p = 0;
        int h = 0;
        int e = 0;

        for (String line : lines) {
            String[] splitLine = line.split(" ");
                m += Integer.parseInt(splitLine[0]);
                p += Integer.parseInt(splitLine[1]);
                h += Integer.parseInt(splitLine[2]);
                e += Integer.parseInt(splitLine[3]);
        }
        float averageRatingOfM = (float) m / lines.size();
        float averageRatingOfP = (float) p / lines.size();
        float averageRatingOfH = (float) h / lines.size();
        float averageRatingOfE = (float) e / lines.size();

        mapOfRatings.put("matReview", averageRatingOfM);
        mapOfRatings.put("presSkills", averageRatingOfP);
        mapOfRatings.put("helpfulness", averageRatingOfH);
        mapOfRatings.put("explanation", averageRatingOfE);

        for (Map.Entry<String, Float> result : mapOfRatings.entrySet()) {
            System.out.println(result.getKey() + " : " + result.getValue());
        }
        //without HashMap:
        //System.out.println("matReview: " + averageRatingOfM + "\npresSkills: " + averageRatingOfP + "\nhelpfulness: " + averageRatingOfH + "\nexplanation: " + averageRatingOfE);

        //System.out.printf("\nmatReview: %.1f\npresSkills: %.1f\nhelpfulness: %.1f\nexplanation: %.1f", averageRatingOfM, averageRatingOfP, averageRatingOfH, averageRatingOfE);
    }

    public static List<String> readFile(String filename) {
        Path filePath = Paths.get(filename);
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(filePath);
        } catch (IOException e){
            e.printStackTrace();
        }
        return lines;
    }
}
