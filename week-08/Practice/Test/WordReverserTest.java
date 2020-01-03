import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class WordReverserTest {

    private static WordReverser wordReverser;

    @BeforeClass
    public static void init(){
        wordReverser = new WordReverser();
    }

    @Test
    public void reverseWords_Should_ReverseCharactersInWords_When_SentenceIsGiven() {
        String sentence = "lleW ,enod taht saw ton taht drah";

        String expectedResult = "Well done, that was not that hard";

        assertEquals(expectedResult, wordReverser.reverseWords(sentence));
    }

    @Test
    public void reverseWords_Should_ReturnEmptyString_When_EmptyStringIsGiven() {
        String sentence = "";

        String expectedResult = "";

        assertEquals(expectedResult, wordReverser.reverseWords(sentence));
    }

    @Test
    public void reverseWordsWithStringBuilder__Should_ReverseCharactersInWords_When_SentenceIsGiven() {
        String sentence = "lleW ,enod taht saw ton taht drah";

        String expectedResult = "Well done, that was not that hard";

        assertEquals(expectedResult, wordReverser.reverseWordsWithStringBuilder(sentence));
    }
}