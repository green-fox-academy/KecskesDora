import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReversedOrder {

    public static void main(String[] args) {
        // Create a method that decrypts reversed-order.txt
        System.out.println(decryptReversedOrder("reversed-order.txt"));
    }
    public static String decryptReversedOrder(String fileName){

        Path filePath = Paths.get(fileName);
        List<String> originalText;
        String reversedOrderedText = "";

        try {
            originalText = Files.readAllLines(filePath);

        } catch (Exception e){
        return "0";
        }
        for (int i = originalText.size() - 1; i >= 0; i--) {
            reversedOrderedText += originalText.get(i) + "\n";
        }
        return reversedOrderedText;
    }
}