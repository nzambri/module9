package CountEachWord;

/**
 * This class represents a GUI application for counting the occurrences of each word in a text file.
 * It extends the JFrame class and contains a JTextArea for displaying the results and a JButton for
 * triggering the counting process. The class also includes methods for reading the text file, counting
 * the occurrences of each word, and displaying the results in the JTextArea.
 *
 * @author Nick Zambri
 * @version 1.0
 * @since 2023-04-17
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serial;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class gui extends JFrame {
    /**
     * A serial version UID for this class.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * A JTextArea for displaying the results.
     */
    private final JTextArea textArea;

    /**
     * A map for storing the word counts.
     */
    private final Map<String, Integer> wordCounts = new HashMap<>();

    /**
     * Constructs a new GUI object and initializes the components.
     */
    public gui() {
        super("Word Occurrences");

        textArea = new JTextArea();
        JButton countButton = new JButton("Count Words");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(countButton);

        JScrollPane scrollPane = new JScrollPane(textArea);

        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        countButton.addActionListener(e -> {
            try {
                countWords();
                displayResults();
            } catch (IOException ex) {
                textArea.setText("Error reading file.");
            }
        });

        setPreferredSize(new Dimension(600, 400));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    /**
     * Reads the text file and counts the occurrences of each word.
     *
     * @throws IOException if an I/O error occurs while reading the file.
     */
    private void countWords() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\nick\\eclipse-workspace\\WordOccurrences\\bin\\TheProjectGutenbergeBook.txt"));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] words = line.split("[\\s.;,?:!()\"]+");
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
        }
        bufferedReader.close();
    }
    /**
     * Displays the results in the JTextArea.
     */
    private void displayResults() {
        Map<String, Integer> sortedWordCounts = wordCounts.entrySet().stream()
                .sorted(Collections.reverseOrder(Entry.comparingByValue()))
                .collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        textArea.setText(String.format("%-20s%15s\n", "Word", "Frequency"));
        textArea.append(String.format("%-20s%15s\n", "====", "========="));

        for (Map.Entry<String, Integer> entry : sortedWordCounts.entrySet()) {
            textArea.append(String.format("%-20s%10s\n", entry.getKey(), entry.getValue()));
        }
    }
    /**
     * The main method of the application.
     *
     * @param args the command-line arguments.
     */

    public static void main(String[] args) {
        new gui();
    }
}