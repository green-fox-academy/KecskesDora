import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Lottery {

    public static void main(String[] args) {
        // Create a method that find the 5 most common lottery numbers in lottery.csv
        find5MostCommon("lottery.csv");

    }

    public static void find5MostCommon(String fileName) {

        Path filePath = Paths.get(fileName);
        List<String> eachLines = new ArrayList<>();

        try {
            eachLines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> lotteryNumbersList = new ArrayList<>();
        int a = 0;

        for (int i = 0; i < eachLines.size(); i++) {

            String[] splittedLinesArr = eachLines.get(i).split(";");

            for (int j = 11; j <= 15; j++) {
                lotteryNumbersList.add(i + a, splittedLinesArr[j]);
                a++;
            }
            a--;
        }
        System.out.println(lotteryNumbersList);
        HashMap<String, Integer> lotteryNumbersCounter = new HashMap<>();

        for (String number : lotteryNumbersList) {
            if (!lotteryNumbersCounter.containsKey(number)) {
                lotteryNumbersCounter.put(number, 1);
            } else {
                lotteryNumbersCounter.replace(number, lotteryNumbersCounter.get(number) + 1);
            }
        }
        System.out.println(lotteryNumbersCounter);

        HashMap<String, Integer> fiveMostCommon = new HashMap<>();
        //eddig jó
            for (Map.Entry<String, Integer> number : lotteryNumbersCounter.entrySet()) {
                if (fiveMostCommon == null
                        || number.getValue().compareTo(fiveMostCommon.getValue()) > 0) {
                    for (int i = 0; i < 5; i++) {
                        fiveMostCommon.put(number, i);
                    }

                }
            }
        }
    }
