import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void fibonacciCreator_ShouldWork_When_PositiveIntegerIsGiven() throws NotPositiveIntegerException{
        int n = 6;
        int expectedResult = 5;

        int result = Fibonacci.fibonacciCreator(n);

        assertEquals(expectedResult, result);
    }

    @Test (expected = NotPositiveIntegerException.class)
    public void fibonacciCreator_When_NegativeIntegerIsGiven() throws NotPositiveIntegerException{
        Fibonacci.fibonacciCreator(-5);
    }
}