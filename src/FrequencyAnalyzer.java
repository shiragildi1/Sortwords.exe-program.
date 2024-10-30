import java.util.HashMap;
import java.util.Map;

public class FrequencyAnalyzer
{
    // Analyzes the content to identify and print the most common word.
    public void printMostFrequentWord(String content)
    {
        String[] words = content.toLowerCase().split("\\W+");
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words)
        {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        String mostFrequentWord = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : frequencyMap.entrySet())
        {
            int count = entry.getValue();
            if (count > maxCount) {
                maxCount = count;
                mostFrequentWord = entry.getKey();
            }
        }

        if (mostFrequentWord != null)
        {
            System.out.printf("The most frequent word in the text is '%s', count: %d%n", mostFrequentWord, maxCount);
        }
    }
}
