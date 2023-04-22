import CountEachWord.WordOccurrences;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**

 Tests class of the countWords method with a string containing application.
 @author Nick Zambri
 @version 1.0
 @since 2023-04-17
 */
import java.util.Map;

public class WordOccurrencesTest {
    /**
     * Tests the countWords method with a string containing one word.
     */
    @Test
    public void testWordCountsWithOneWord() {
        String input = "one";
        Map<String, Integer> wordCounts = WordOccurrences.countWords(input);
        assertEquals(1, wordCounts.size());
        assertEquals(1, wordCounts.get("one").intValue());
    }
    /**
     * Tests the countWords method with a string containing multiple words.
     */
    @Test
    public void testWordCountsWithMultipleWords() {
        String input = "one two one";
        Map<String, Integer> wordCounts = WordOccurrences.countWords(input);
        assertEquals(2, wordCounts.size());
        assertEquals(2, wordCounts.get("one").intValue());
        assertEquals(1, wordCounts.get("two").intValue());
    }
    /**
     * Tests the countWords method with a string containing one word.
     */
    @Test
    public void countWords() {
        String input = "one";
        Map<String, Integer> wordCounts = WordOccurrences.countWords(input);
        assertEquals(1, wordCounts.size());
        assertEquals(1, wordCounts.get("one").intValue());
    }
}