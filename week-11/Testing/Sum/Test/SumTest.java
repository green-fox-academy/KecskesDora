import org.junit.BeforeClass;
import org.junit.Test;
import java.util.ArrayList;
import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;

public class SumTest {

    private static Sum s;

    @BeforeClass
    public static void init() {
        s = new Sum();
    }

    @Test
    public void sum_should_addElements_when_integerArrayListIsGiven() {
        ArrayList<Integer> numbers = new ArrayList<>(asList(1, 2, 3, 4));
        ArrayList<Integer> numbers2 = new ArrayList<>(asList(5, 6, 7, 8));
        int expectedResult = 10;
        int expectedResult2 = 26;

        int result = s.sum(numbers);
        int result2 = s.sum(numbers2);

        assertEquals(expectedResult, result);
        assertEquals(expectedResult2, result2);
    }

    @Test
    public void sum_should_return0_when_emptyArrayListIsGiven() {
        ArrayList<Integer> numbers = new ArrayList<>();
        int expectedResult = 0;

        int result = s.sum(numbers);

        assertEquals(expectedResult, result);
    }

    @Test
    public void sum_should_returnWithTheElement_when_OneElementIsInArrayList() {
        ArrayList<Integer> numbers = new ArrayList<>(asList(5));
        int expectedResult = numbers.get(0);

        int result = s.sum(numbers);

        assertEquals(expectedResult, result);
    }

    @Test
    public void sum_should_return0_when_nullIsGiven() {
        ArrayList<Integer> numbers = null;
        int expectedResult = 0;

        int result = s.sum(numbers);

        assertEquals(expectedResult, result);
    }
}