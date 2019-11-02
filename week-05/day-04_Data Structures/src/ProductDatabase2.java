import java.util.HashMap;
import java.util.Map;

public class ProductDatabase2 {
    public static void main(String[] args) {
        HashMap<String, Integer> productsAndPrices = new HashMap<>();
        productsAndPrices.put("Eggs", 200);
        productsAndPrices.put("Milk", 200);
        productsAndPrices.put("Fish", 400);
        productsAndPrices.put("Apples", 150);
        productsAndPrices.put("Bread", 50);
        productsAndPrices.put("Chicken", 550);

        //Which products cost less than 201? (just the name)
        for (Map.Entry<String, Integer> data : productsAndPrices.entrySet()) {
            if (data.getValue() < 201) {
                System.out.println(data.getKey());
            }
        }
        //Which products cost more than 150? (name + price)
        for (Map.Entry<String, Integer> data : productsAndPrices.entrySet()) {
            if (data.getValue() > 150) {
                System.out.printf("%s : %s \n", data.getKey(), data.getValue());
            }
        }
    }
}
