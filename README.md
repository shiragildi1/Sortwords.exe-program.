Author: Shira Giladi
--Sortwords.exe program--
The program does two main things:
1. Prints the most common word in file F1 and its count.
2. Sorting options: ascending or descending sorting of all words from F1 (sort -a, sort -d) and writes the result to file F2

How to run:
1. Compilation
   javac src/*.java
2. Running
   java -cp src Main "path of F1.txt file"

Description of the files-
--Main-- Reads a text file from an input file, processes it and writes sorted content to an output file.
Input file: the program takes the first argument from the command line (which is the path to the input file (F1.txt)) it reads the contents of the file using the --TextFileProcessor-- class.
After reading the content, it detects and prints the most common word and its count using the --FrequencyAnalyzer-- class.
Sorting options: asks the user to select a sorting option - ascending (sort -a) or descending (sort -d).
Output file:
Using the --WordSorter-- class based on the selected option, sorting the words and writing them to a sorted array and then writing them to an output file (F2.txt)


Thank you!,
Shira

