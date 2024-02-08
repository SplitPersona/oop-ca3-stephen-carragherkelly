import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *  Name: Stephen Carragher Kellu
 *  Class Group: GD2A
 */

public class CA3_Question3
{
    public static void readFile(String fileName) throws FileNotFoundException
    {
        File javaFile = new File(fileName);
        Scanner scanner = new Scanner(javaFile);

        Map<String, StringBuilder> identifymap = new HashMap<>();
        int lineNum = 0;

        while(scanner.hasNextLine())
        {
            String nextLine = scanner.nextLine();
            lineNum++;
            Scanner lineScan = new Scanner(nextLine);
            lineScan.useDelimiter("[^A-Za-z0-9_]+");

            while(scanner.hasNextLine())
            {
                String identify = lineScan.next();
                if(identifyValid(identify))
                {
                    identifymap.computeIfAbsent(identify, k -> new StringBuilder()).append("Line ").append(lineNum).append(", ");
                }
            }

        }

        for(Map.Entry<String, StringBuilder> entry: identifymap.entrySet())
        {
            System.out.println("Identifer: " + entry.getKey());
            System.out.println("Occurrences: " + entry.getValue());
        }

        scanner.close();
    }

    private static boolean identifyValid(String identify)
    {
        return identify.matches("[A-Za-z0-9_]+");
    }

    public static void main(String[] args) throws FileNotFoundException {
        readFile("src/CA3_Question1.java");
    }
}
