import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CountLettersTest {

    @Test
    public void letterCounter_IsWorking() throws Exception {
        String text = "tree";

        HashMap<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put("t", 1);
        expectedResult.put("r", 1);
        expectedResult.put("e", 2);

        assertEquals(expectedResult, CountLetters.letterCounter(text));
    }

    @Test
    public void letterCounter_countsSpaces() throws Exception {
        String text = "pine tree";

        HashMap<String, Integer> expectedResult = new HashMap<>();
        expectedResult.put(" ", 1);
        expectedResult.put("p", 1);
        expectedResult.put("i", 1);
        expectedResult.put("n", 1);
        expectedResult.put("e", 3);
        expectedResult.put("t", 1);
        expectedResult.put("r", 1);

        assertEquals(expectedResult, CountLetters.letterCounter(text));
    }

    @Test (expected = Exception.class)
    public void letterCounter_shouldReturnEmptyMap_when_StringIsEmpty() throws Exception{
        String text = "";

        HashMap<String, Integer> expectedResult = new HashMap<String, Integer>(){{}};

        assertEquals(expectedResult, CountLetters.letterCounter(text));
    }
}