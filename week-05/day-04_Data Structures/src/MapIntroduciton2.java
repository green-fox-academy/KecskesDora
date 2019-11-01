import java.util.HashMap;
import java.util.Map;

public class MapIntroduciton2 {
    public static void main(String[] args) {
        //Create a map where the keys are strings and the values are strings
        // with the following initial values
        HashMap<String, String> table = new HashMap<>();
        table.put("978-1-60309-452-8", "A Letter to Jo");
        table.put("978-1-60309-459-7", "Lupus");
        table.put("978-1-60309-444-3", "Red Panda and Moon Bear");
        table.put("978-1-60309-461-0", "The Lab");

        //Print all the key-value pairs in the following format
        //A Letter to Jo (ISBN: 978-1-60309-452-8)
        //Lupus (ISBN: 978-1-60309-459-7)
        //Red Panda and Moon Bear (ISBN: 978-1-60309-444-3)
        //The Lab (ISBN: 978-1-60309-461-0)
        for (Map.Entry<String, String> pairs : table.entrySet()) {
            System.out.println(pairs.getValue() + " (ISBN: " + pairs.getKey() + ")");
            //OR
            System.out.printf("%s (ISBN: %s)\n", pairs.getValue(), pairs.getKey());
        }

        //Remove the key-value pair with key 978-1-60309-444-3
        table.remove("978-1-60309-444-3");

        //Remove the key-value pair with value The Lab
        String keyWeAreSearching = "";
        for (Map.Entry<String, String> pairs : table.entrySet()) {
            if (pairs.getValue() == "The Lab") {
                keyWeAreSearching = pairs.getKey();
            }
        }
        table.remove(keyWeAreSearching);

        //Add the following key-value pairs to the map
        table.put("978-1-60309-450-4", "They Called Us Enemy");
        table.put("978-1-60309-453-5", "Why Did We Trust Him?");

        //Print whether there is an associated value with key 478-0-61159-424-8 or not
        System.out.println(table.get("478-0-61159-424-8") != null);

        //Print the value associated with key 978-1-60309-453-5
        System.out.println(table.get("978-1-60309-453-5"));
        }
    }





