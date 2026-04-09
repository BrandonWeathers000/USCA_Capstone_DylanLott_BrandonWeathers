import java.util.*;
import java.io.*;

/**
 * @version 1.0
 * @author Dylan Lott
 * @author Brandon Weathers
 * <hr>
 * NOTE: I have finished the string 2D ArrayList and the 1D EPSB ArrayList and Jaccard, Multi-LCSM (SuffixTree), and Levenstein dist
 *
 * My plan is to create a mini database where you have a matrix of strings and then a stiched together 2D matrix of all the info EPSB, Jaccard, LCSM, etc.
 * I can then query all of this info whenever I want.
 *
 * I am currently finished with finding all common substrings in a given database line.
 * I have iternated thoruh all of the database's lines to find the single common substring amoung each user's entry
 */

public class FullAnalysisDriver {
    public static void main(String[] args) {
        // All important info matrices
        CsvParser myCsvParser = new CsvParser();
        ArrayList<ArrayList<String>> stringMatrix = new ArrayList<>();
        ArrayList<EPSB> epsbList = new ArrayList<>();
        ArrayList<Double> jacList = new ArrayList<>();
        ArrayList<String> lcsmList = new ArrayList<>();
        ArrayList<Double> levList = new ArrayList<>();

        // Sample database "../Datasets/Synthetic300000PwPairsV2.csv"
        init(
             myCsvParser,
             "../Datasets/Synthetic300000PwPairsV2.csv",
             stringMatrix,
             epsbList,
             jacList,
             lcsmList,
             levList,
             1
            );
    }

    static void init(CsvParser myCsvParser, String inputDatabase, ArrayList<ArrayList<String>> stringMatrix, ArrayList<EPSB> epsbList, ArrayList<Double> jacList, ArrayList<String> lcsmList, ArrayList<Double> levList, int caseNumber) {
        // Filling in and printing (the first line) the string matrix 2D ArrayList
        try {
            Scanner myScanner = new Scanner(new File(inputDatabase));
            System.out.println("Reading in file...");
            stringMatrix = myCsvParser.readInStringMatrix(myScanner);
            System.out.println("File read complete ✓\n");
        }catch(FileNotFoundException e) {
            System.out.println("File not found. ✗\n");
        }
        printSingleLine(stringMatrix.get(caseNumber));

        // Filling in and printing (the first line) the EPSB ArrayList
        epsbList = EPSB.getAnEpsbList(stringMatrix);
        epsbList.get(caseNumber).getInfo();

        // Filling in and printing (the first line) the Jaccard ArrayList
        jacList = Jaccard.getJacList(stringMatrix);
        System.out.printf("The rounded jac is: %.1f\n", jacList.get(caseNumber));

        // Filling in and printing (the first line) the LCSM ArrayList
        lcsmList = TranslatedSuffixTree.getTranslatedSuffixTreeList(stringMatrix);
        System.out.println("The longest common substring is: " + lcsmList.get(caseNumber));

        // Filling in and printing (the first line) the Lev ArrayList
        levList = Levenshtein.getLevList(stringMatrix);
        System.out.printf("Lev distance: %.1f\n", levList.get(caseNumber));
    }

    static void printSingleLine(ArrayList<String> inputArrayList) {
        System.out.println("Here is the content of the array list");
        inputArrayList.forEach((word) -> System.out.println("\t- " + word));
    }
}
