import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class WordSorter
{

    // Sorts the unique words from the provided content and writes the result to the F2 file
    // The function receives 3 parameters:
    // The text content from which words can be extracted and sorted.
    // The path to the output file where sorted words will be written. (F2 file path)
    // ascending if true, sorts words in ascending order; If false, sorts in descending order.
    // In addition, normalizes the input text to lowercase letters, splits it into words, removes duplicates,
    // Sorts the unique words in the specified order, and writes the sorted list to the output file.
    public void sortWords(String content, String outputFilePath, boolean ascending)
    {
        // Normalize the content to lowercase and split into words
        String[] words = content.toLowerCase().split("\\W+");

        // Remove duplicates using a set + using a hash table to access directly to check for duplicates.
        Set<String> uniqueWords = new LinkedHashSet<>(Arrays.asList(words));
        String[] sortedWords = uniqueWords.toArray(new String[0]);

        // Sort the words
        Arrays.sort(sortedWords);
        if (!ascending)
        {
            // Make the order descending
            for (int i = 0; i < sortedWords.length / 2; i++)
            {
                String temp = sortedWords[i];
                sortedWords[i] = sortedWords[sortedWords.length - 1 - i];
                sortedWords[sortedWords.length - 1 - i] = temp;
            }
        }

        // Writing the words in a sorted manner to an input file
        String result = String.join(", ", sortedWords);
        TextFileProcessor fileHandler = new TextFileProcessor();
        fileHandler.writeFile(result, new File(outputFilePath));
    }
}