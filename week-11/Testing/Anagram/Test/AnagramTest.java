import org.junit.Test;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class AnagramTest {

    @Test
    public void anagramTester_Should_ReturnTrue_When_TwoWordsAreAnagrams() throws OneOfTheStringsIsMissingException {
        String text = "night";
        String text2 = "thing";

        boolean result = Anagram.anagramTester(text, text2);
        assertTrue(result);
        }

    @Test
    public void anagramTester_Should_ReturnFalse_When_TwoWordsAreNotAnagrams() throws OneOfTheStringsIsMissingException {
        String text = "apple";
        String text2 = "opple";

        boolean result = Anagram.anagramTester(text, text2);
        assertFalse(result);
    }

    @Test
    public void anagramTester_Should_ReturnFalse_When_OneOfTheWordsIsLonger() throws OneOfTheStringsIsMissingException {
        String text = "states";
        String text2 = "taste";

        boolean result = Anagram.anagramTester(text, text2);
        assertFalse(result);
    }

    @Test
    public void anagramTester_Should_ReturnTrue_When_StringsContainSpaces() throws OneOfTheStringsIsMissingException{
        String text = "a gentleman";
        String text2 = "elegant man";

        boolean result = Anagram.anagramTester(text, text2);
        assertTrue(result);
    }

    @Test
    public void anagramTester_Should_ReturnTrue_When_StringsContainUpperCases() throws OneOfTheStringsIsMissingException {
        String text = "Astronomer";
        String text2 = "Moon starer";

        boolean result = Anagram.anagramTester(text, text2);
        assertTrue(result);
    }

    @Test
    public void anagramTester_Should_ReturnTrue_When_StringsContainSpecialCharacters() throws OneOfTheStringsIsMissingException{
        String text = "an-ge%l";
        String text2 = "g-l%ean";

        boolean result = Anagram.anagramTester(text, text2);
        assertTrue(result);
    }

    @Test(expected = OneOfTheStringsIsMissingException.class)
    public void anagramTester_When_OneOfTheStringsMissing() throws OneOfTheStringsIsMissingException{
        String text = "angel";

        boolean result = Anagram.anagramTester(text, null);
    }

    @Test(expected = OneOfTheStringsIsMissingException.class)
    public void anagramTester_When_OneOfTheStringsisEmpty() throws OneOfTheStringsIsMissingException{
        String text = "angel";
        String text2 = "";

        boolean result = Anagram.anagramTester(text, text2);
    }
}

