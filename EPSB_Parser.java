import java.util.*;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Map;

import java.util.*;
import java.io.*;

class EPSB_Parser{
    public static final String COMMA_DELIMITER = ",";
    public static void main(String[] args){
        // Parsing the CSV into the 2D linked list
        ArrayList<ArrayList<String>> dataset1 = new ArrayList<>(), dataset2 = new ArrayList<>(), dataset3 = new ArrayList<>();
        try{
            Scanner myScanner1 = new Scanner(new File("DataGeneration9_16_25Part1.cvs"));
            while(myScanner1.hasNextLine()){
                dataset1.add(getRecordFromLine(myScanner1.nextLine()));
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }

        // Adding a line of the CSV to a coresponding EPSB, which then
        // does stastical analysis.
        EPSB EPSB1 = new EPSB();

        for(String currentPassword : dataset1.get(0)){
            // System.out.print(currentPassword + ",");
            EPSB1.addNewPassword(currentPassword);
        }

        System.out.println("The passwords are:");
        EPSB1.passwords.forEach((line) -> System.out.println(line));

        System.out.println();
        System.out.println("CAPITALS:");
        System.out.println("     Minimum number of capitals are: " + EPSB1.getMin(     EPSB1.capitals));
        System.out.println("     Max number of capitals are: " +     EPSB1.getMax(     EPSB1.capitals));
        System.out.printf ("     Average number of capitals are: %.2f\n",  EPSB1.getAverage( EPSB1.capitals));
        System.out.println("     Median number of capitals are: " +  EPSB1.getMedian(  EPSB1.capitals));
        System.out.println("     Mode number of capitals are: " +    EPSB1.getMode(    EPSB1.capitals));

        System.out.println("LOWER CASE:");
        System.out.println("     Minimum number of lower case letters are: " + EPSB1.getMin(     EPSB1.lowerCase));
        System.out.println("     Max number of lower case letters are: " +     EPSB1.getMax(     EPSB1.lowerCase));
        System.out.printf ("     Average number of lower case letters are: %.2f\n", EPSB1.getAverage( EPSB1.lowerCase));
        System.out.println("     Median number of lower case letters are: " +  EPSB1.getMedian(  EPSB1.lowerCase));
        System.out.println("     Mode number of lower case letters are: " +    EPSB1.getMode(    EPSB1.lowerCase));

        System.out.println("LETTERS:");
        System.out.println("     Minimum number of letters are: " + EPSB1.getMin(     EPSB1.letters));
        System.out.println("     Max number of letters are: " +     EPSB1.getMax(     EPSB1.letters));
        System.out.printf ("     Average number of letters are: %.2f\n", EPSB1.getAverage( EPSB1.letters));
        System.out.println("     Median number of letters are: " +  EPSB1.getMedian(  EPSB1.letters));
        System.out.println("     Mode number of letters are: " +    EPSB1.getMode(    EPSB1.letters));

        System.out.println("NUMBERS:");
        System.out.println("     Minimum number of numbers are: " + EPSB1.getMin(     EPSB1.numbers));
        System.out.println("     Max number of numbers are: " +     EPSB1.getMax(     EPSB1.numbers));
        System.out.printf ("     Average number of numbers are: %.2f\n", EPSB1.getAverage( EPSB1.numbers));
        System.out.println("     Median number of numbers are: " +  EPSB1.getMedian(  EPSB1.numbers));
        System.out.println("     Mode number of numbers are: " +    EPSB1.getMode(    EPSB1.numbers));

        System.out.println("SYMBOLS:");
        System.out.println("     Minimum number of symbols are: " + EPSB1.getMin(     EPSB1.symbols));
        System.out.println("     Max number of symbols are: " +     EPSB1.getMax(     EPSB1.symbols));
        System.out.printf ("     Average number of symbols are: %.2f\n", EPSB1.getAverage( EPSB1.symbols));
        System.out.println("     Median number of symbols are: " +  EPSB1.getMedian(  EPSB1.symbols));
        System.out.println("     Mode number of symbols are: " +    EPSB1.getMode(    EPSB1.symbols));

        System.out.println("LENGTH:");
        System.out.println("     Minimum length is: " + EPSB1.getMin(     EPSB1.length));
        System.out.println("     Max length is: " +     EPSB1.getMax(     EPSB1.length));
        System.out.printf ("     Average length is: %.2f\n", EPSB1.getAverage( EPSB1.length));
        System.out.println("     Median length is: " +  EPSB1.getMedian(  EPSB1.length));
        System.out.println("     Mode length is: " +    EPSB1.getMode(    EPSB1.length));
    }

    private static ArrayList<String> getRecordFromLine(String line){
        ArrayList<String> currentLine = new ArrayList<String >();
        try(Scanner rowScanner = new Scanner(line)){
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while(rowScanner.hasNext()){
                currentLine.add(rowScanner.next());
            }
        }
        return currentLine;
    }
}
