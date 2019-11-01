import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProductDatabase {
    public static void main(String[] args) {
        HashMap<String, Integer> productsAndPrices = new HashMap<>();
        productsAndPrices.put("Eggs", 200);
        productsAndPrices.put("Milk", 200);
        productsAndPrices.put("Fish", 400);
        productsAndPrices.put("Apples", 150);
        productsAndPrices.put("Bread", 50);
        productsAndPrices.put("Chicken", 550);

        //How much is the fish?
        System.out.println(productsAndPrices.get("Fish"));

        //What is the most expensive product?
        System.out.println(Collections.max(productsAndPrices.values()));

        //What is the average price?
        int sum = 0;
        for (Integer prices : productsAndPrices.values()) {
            sum += prices;
        }
        System.out.println(sum / productsAndPrices.size());

        //How many products' price is below 300?
        int counter = 0;
        for (Integer prices : productsAndPrices.values()) {
            if (prices < 300) {
                counter += 1;
            }
        }
        System.out.println(counter);

        //Is there anything we can buy for exactly 125?
            for (Map.Entry<String, Integer> data : productsAndPrices.entrySet()) {
                if (data.getValue() == 125) {
                    System.out.println("Yes, " + data.getKey());
                   }
                }
            if (productsAndPrices.containsValue(125) == false) {
                System.out.println("No");
            }

        //What is the cheapest product?
        int minPrice = Collections.min(productsAndPrices.values());
        for (Map.Entry<String, Integer> list : productsAndPrices.entrySet()) {
            if (list.getValue() == minPrice) {
                System.out.println(list.getKey());
            }
        }
    }
}




