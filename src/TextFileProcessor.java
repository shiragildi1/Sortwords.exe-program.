import java.io.*;
import java.nio.charset.StandardCharsets;

public class TextFileProcessor {
    //Reads the file contents as a UTF-8 encoded string with line breaks.
    public String readFile(File file)
    {
        StringBuilder content = new StringBuilder();
        //FileInputStream is used to create an input stream to read data from a file, the input stream reads raw bytes from the file.
        //InputStreamReader - responsible for converting the bytes into characters using UTF-8 character encoding.
        //BufferedReader- is a Java class used to efficiently read text from a character input stream.
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                content.append(line).append(System.lineSeparator());
            }
        }
        catch (IOException e)
        {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
        return content.toString();
    }


    //Writes a given string to a file using UTF-8 encoding.
    public void writeFile(String content, File file)
    {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), StandardCharsets.UTF_8)))
        {
            writer.write(content);
        }
        catch (IOException e)
        {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}

