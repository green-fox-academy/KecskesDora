import java.util.HashMap;
import java.util.Map;

public class ShoppingList2 {
    public static void main(String[] args) {
        HashMap<String, Double> priceList = new HashMap<>();
        priceList.put("Milk", 1.07);
        priceList.put("Rice", 1.59);
        priceList.put("Eggs", 3.14);
        priceList.put("Cheese", 12.60);
        priceList.put("Chicken Breasts", 9.40);
        priceList.put("Apples", 2.31);
        priceList.put("Tomato", 2.58);
        priceList.put("Potato", 1.75);
        priceList.put("Onion", 1.10);

        HashMap<String, Integer> bobsList = new HashMap<>();
        bobsList.put("Milk", 3);
        bobsList.put("Rice", 2);
        bobsList.put("Eggs", 2);
        bobsList.put("Cheese", 1);
        bobsList.put("Chicken Breasts", 4);
        bobsList.put("Apples", 1);
        bobsList.put("Tomato", 2);
        bobsList.put("Potato", 1);

        HashMap<String, Integer> alicesList = new HashMap<>();
        alicesList.put("Rice", 1);
        alicesList.put("Eggs", 5);
        alicesList.put("Chicken Breasts", 2);
        alicesList.put("Apples", 1);
        alicesList.put("Tomato", 10);

        //How much does Bob pay?
        double sumBob = 0.0;
        for (Map.Entry<String, Integer> list : bobsList.entrySet()) {
            sumBob += priceList.get(list.getKey()) * list.getValue();
        }
        System.out.println("Bob paied: " + sumBob);

        //How much does Alice pay?
        double sumAlice = 0.0;
        for (Map.Entry<String, Integer> list : alicesList.entrySet()) {
            sumAlice += priceList.get(list.getKey()) * list.getValue();
        }
        System.out.println("Alice paied: " + sumAlice);

        //Who buys more Rice?
        if (bobsList.get("Rice") > alicesList.get("Rice")) {
            System.out.println("Bob brougth more rice.");
        } else if (bobsList.get("Rice") < alicesList.get("Rice")) {
            System.out.println("Alice brougth more rice.");
        } else {
            System.out.println("They brought the same amount of rice.");
        }

        //Who buys more Potato?
        if (bobsList.containsKey("Potato") && alicesList.containsKey("Potato") == true) {
            if (bobsList.get("Potato") > alicesList.get("Potato")) {
                System.out.println("Bob brougth more Potato");
            } else if (bobsList.get("Potato") < alicesList.get("Potato")) {
                System.out.println("Alice brougth more Potato");
            } else if (bobsList.get("Potato") == alicesList.get("Potato")) {
                System.out.println("They brought the same amount.");
            }
        } else if (bobsList.containsKey("Potato") == false) {
            System.out.println("Bob didn't buy any potato, so Alice brought more.");
        } else if (alicesList.containsKey("Potato") == false) {
            System.out.println("Alice didn't buy any potato, so Bob brought more.");
        }

        //Who buys more different products?
        if (bobsList.size() > alicesList.size()) {
            System.out.println("Bob brought more types of products.");
        } else if (bobsList.size() < alicesList.size()) {
            System.out.println("Alice brought more types of products.");
        } else if (bobsList.size() == alicesList.size()) {
            System.out.println("They brought the same types of products.");
        }

        //Who buys more products? (piece)
        int sumPiecesOfBobsList = 0;
        for (Integer pieceCounter : bobsList.values()) {
            sumPiecesOfBobsList += pieceCounter;
        }
        int sumPiecesOfAlicesList = 0;
        for (Integer pieceCounter : alicesList.values()) {
            sumPiecesOfAlicesList += pieceCounter;
        }
        if (sumPiecesOfAlicesList > sumPiecesOfBobsList) {
            System.out.println("Alice brought more products.");
        } else if (sumPiecesOfAlicesList < sumPiecesOfBobsList) {
            System.out.println("Bob brought more products.");
        } else {
            System.out.println("They brought the same amount of products.");
        }
    }
}


