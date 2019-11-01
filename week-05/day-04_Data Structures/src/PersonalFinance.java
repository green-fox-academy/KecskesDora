import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class PersonalFinance {
    public static void main(String[] args) {
        ArrayList<Integer> expenses = new ArrayList<Integer>(Arrays.asList(500, 1000, 1250, 175, 800, 120));

        //How much did we spend?
        int sum = 0;
        for (int i = 0; i < expenses.size(); i++) {
            sum += expenses.get(i);
        }
        System.out.println(sum);

        //Which was our greatest expense?
        System.out.println(Collections.max(expenses));

        //Which was our cheapest spending?
        System.out.println(Collections.min(expenses));

        //What was the average amount of our spendings?
        System.out.println(sum/expenses.size());
    }
}

