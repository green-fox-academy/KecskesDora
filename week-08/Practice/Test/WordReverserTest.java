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
    public void reverseWords_Should_ReverseCharactersInWords_When_SentenceIsGiven() throws SentenceIsMissingException{
        String sentence = "lleW ,enod taht saw ton taht drah";

        String expectedResult = "Well done, that was not that hard";

        assertEquals(expectedResult, wordReverser.reverseWords(sentence));
    }

    @Test (expected = SentenceIsMissingException.class)
    public void reverseWords_When_EmptyStringIsGiven() throws SentenceIsMissingException{

        assertEquals("", wordReverser.reverseWords(""));
    }

    @Test (expected = SentenceIsMissingException.class)
    public void reverseWords_When_StringDoesNotExist() throws SentenceIsMissingException{

        assertEquals(null, wordReverser.reverseWords(null));
    }

    @Test
    public void reverseWordsWithStringBuilder__Should_ReverseCharactersInWords_When_SentenceIsGiven() {
        String sentence = "lleW ,enod taht saw ton taht drah";

        String expectedResult = "Well done, that was not that hard";

        assertEquals(expectedResult, wordReverser.reverseWordsWithStringBuilder(sentence));
    }
}