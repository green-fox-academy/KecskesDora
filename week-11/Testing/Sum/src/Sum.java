import java.util.ArrayList;

public class Sum {

    public int sum(ArrayList<Integer> listOfNumbers) {
        if (listOfNumbers == null || listOfNumbers.size() == 0) {
            System.err.println("empty list");
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < listOfNumbers.size(); i++) {
            sum += listOfNumbers.get(i);
        }
        return sum;
    }
}
