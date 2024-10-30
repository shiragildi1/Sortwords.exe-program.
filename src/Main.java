import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        // Expect to receive one argument on the command line (the path to the F1 file) and if more or less than one argument is passed, an error is returned
        if (args.length != 1)
        {
            System.out.println("Please enter one argument, the argument should be the path to the F1.txt file");
            return;
        }

        // Sending to the class responsible for opening the input file
        String inputFilePath = args[0];
        File inputFile = new File(inputFilePath);
        TextFileProcessor textFileProcessor = new TextFileProcessor();

        // Reading the content from the input file
        String content = textFileProcessor.readFile(inputFile);
        if (content == null)
        {
            System.out.println("Failed to read the file.");
            return;
        }

        // Sending to the class that prints the most common word.
        FrequencyAnalyzer wordFrequency = new FrequencyAnalyzer();
        wordFrequency.printMostFrequentWord(content);

        // Prints sorting options for the user.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your options:\nsort -a (ascending)\nsort -d (descending)");
        String option = scanner.nextLine();

        // Sort the words based on user option
        WordSorter wordSorter = new WordSorter();
        String outputFilePath = "F2.txt";

        switch (option) {
            case "sort -a":
                wordSorter.sortWords(content, outputFilePath, true);
                System.out.println("The file F2 has been created.");
                break;
            case "sort -d":
                wordSorter.sortWords(content, outputFilePath, false);
                System.out.println("The file F2 has been created.");
                break;
            default:
                System.out.println("Invalid option- Please enter one of these 2 options:(sort -a/sort -d)");
                break;
        }

        scanner.close();
    }
}
