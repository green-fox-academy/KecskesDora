import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.util.Arrays.asList;

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
        HashMap<String, Integer> lotteryNumberCountersMap = new HashMap<>();

        for (String number : lotteryNumbersList) {
            if (!lotteryNumberCountersMap.containsKey(number)) {
                lotteryNumberCountersMap.put(number, 1);
            } else {
                lotteryNumberCountersMap.replace(number, lotteryNumberCountersMap.get(number) + 1);
            }
        }
        System.out.println(lotteryNumberCountersMap);

        //eddig jó

        HashMap<String, Integer> fiveMostCommon = new HashMap<>();

        int memoryValue = 0;
        String memoryKey = "";

        for (int i = 0; i < 7; i++) {

        for (Map.Entry<String, Integer> lotteryNumberCounter : lotteryNumberCountersMap.entrySet()) {
            if (lotteryNumberCounter.getValue() == Collections.max(lotteryNumberCountersMap.values())) {
                memoryValue = lotteryNumberCounter.getValue();
                memoryKey = lotteryNumberCounter.getKey();
            break;
            }
        }
        lotteryNumberCountersMap.remove(memoryKey, memoryValue);
        fiveMostCommon.put(memoryKey, memoryValue);
        
       }
        System.out.println(fiveMostCommon);
    }
}



