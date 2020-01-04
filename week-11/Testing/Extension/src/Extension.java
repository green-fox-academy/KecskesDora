// Check out the folder. There's a work file and a test file.

//  -  Run the tests, all 10 should be green (passing).
//  -  The implementations though are not quite good.
//  -  Create tests that'll fail, and will show how the implementations are wrong
//      (You can assume that the implementation of join and split are good)
//  -  After creating the tests, fix the implementations
//  -  Check again, if you can create failing tests
//  -  Implement if needed

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Extension {
    int add(int a, int b) {
        return a + b;
    }

    int maxOfThree(int a, int b, int c) {
        if (a > b && a > c)
            return a;
        else if (b > c)
            return b;
        else
            return c;
    }

    float median(List<Integer> pool) {
        Collections.sort(pool);
        if (pool.size() % 2 == 1) {
            return pool.get((pool.size() - 1) / 2);
        } else {
            return ((float) (pool.get(pool.size() / 2 - 1)) + pool.get(pool.size() / 2)) / 2;
        }
    }

    boolean isVowel(char c) {
        return Arrays.asList('a', 'A', 'á', 'Á', 'u', 'U', 'ú', 'Ú', 'ü', 'Ű', 'ö', 'Ö', "Ő", 'o', 'Ó', 'e', 'E', 'é', 'É', 'i', 'Í').contains(c);
    }

    String translate(String hungarian) {
        //Still not working
        int length = hungarian.length();
        String translated = "";
        List<String> vowels = new ArrayList<>(Arrays.asList("a", "A", "á", "Á", "u", "U", "ú", "Ú", "ü", "Ű", "ö", "Ö", "Ő", "o", "Ó", "e", "E", "é", "É", "i", "Í"));
        for (int i = 0; i < vowels.size(); i++) {
            String c = vowels.get(i);
            if (hungarian.contains(c)) {
                translated = String.join(c + "v" + c, hungarian.split(c));
            }
        }
        return translated;
    }
}

