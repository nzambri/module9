package CountEachWord;
/**

 WordOccurrences class provides functionality to count the occurrences of each word in a given string.
 @author Nick Zambri
 @version 1.0
 @since 2023-04-17
 */
import java.util.HashMap;
import java.util.Map;

public class WordOccurrences {
    /**
     * Counts the occurrences of each word in a given string.
     * @param input the input string to count the words in
     * @return a Map object containing the word counts
     */
    public static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordCounts = new HashMap<>();
        String[] words = input.split("[\\s.;,?:!()\"]+");
        for (String word : words) {
            word = word.trim();
            if (word.length() > 0) {
                if (wordCounts.containsKey(word)) {
                    wordCounts.put(word, wordCounts.get(word) + 1);
                } else {
                    wordCounts.put(word, 1);
                }
            }
        }
        return wordCounts;
    }
}