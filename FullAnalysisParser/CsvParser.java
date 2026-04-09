import java.util.*;
import java.io.*;

class CsvParser {
    public static final String COMMA_DELIMITER = ",";
    // public static ArrayList<ArrayList<String>> stringMatrix = new ArrayList<>();

    public static ArrayList<ArrayList<String>> readInStringMatrix(Scanner myScanner) {
        ArrayList<ArrayList<String>> stringMatrix = new ArrayList<>();

        while(myScanner.hasNextLine()) {
            stringMatrix.add(getRecordFromLine(myScanner.nextLine()));
        }
        return stringMatrix ;
    }

    private static ArrayList<String> getRecordFromLine(String line) {
        ArrayList<String> currentLine = new ArrayList<String>();
        try(Scanner rowScanner = new Scanner(line)){
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while(rowScanner.hasNext()){
                currentLine.add(rowScanner.next());
            }
        }
        return currentLine;
    }
}
