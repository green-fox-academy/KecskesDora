import org.junit.Test;

import static org.junit.Assert.*;

public class ApplesTest {

    @Test
    public void getApple_shouldReturnApple() {
        Apples apple = new Apples();
        String expectedResult = "apple";

        String result = apple.getApple();

        assertEquals(expectedResult, result);
    }
}