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
    // All important info matrices
    static CsvParser myCsvParser = new CsvParser();
    static ArrayList<ArrayList<String>> stringMatrix = new ArrayList<>();
    static ArrayList<EPSB> epsbList = new ArrayList<>();
    static ArrayList<Double> jacList = new ArrayList<>();
    static ArrayList<String> lcsmList = new ArrayList<>();
    static ArrayList<Double> levList = new ArrayList<>();

    public static void main(String[] args) {

        // Sample database "../Datasets/Synthetic300000PwPairsV2.csv"
        init("../Datasets/Synthetic300000PwPairsV2.csv");
        printAnEntry(1);
    }

    // Represents the line number of passwords you want to analyze
    static void printAnEntry(int entryNumber) {
        // Printing out various info
        entryNumber--;
        printSingleLine(stringMatrix.get(entryNumber));
        epsbList.get(entryNumber).getInfo();
        System.out.println("The longest common substring is: " + lcsmList.get(entryNumber));
        System.out.printf("The rounded jac is: %.2f\n", jacList.get(entryNumber));
        System.out.printf("Lev distance: %.2f\n", levList.get(entryNumber));
    }

    // static void init(int entryNumber, CsvParser myCsvParser, String inputDatabase, ArrayList<ArrayList<String>> stringMatrix, ArrayList<EPSB> epsbList, ArrayList<Double> jacList, ArrayList<String> lcsmList, ArrayList<Double> levList) {
    static void init(String inputDatabase) {
        // Filling in and printing (the first line) the string matrix 2D ArrayList
        try {
            Scanner myScanner = new Scanner(new File(inputDatabase));
            System.out.println("Reading in file...");
            stringMatrix = myCsvParser.readInStringMatrix(myScanner);
            System.out.println("File read complete ✓");
        }catch(FileNotFoundException e) {
            System.out.println("File not found. ✗");
        }

        System.out.println("===========================");

        System.out.println("Loading EPSB list...");
        epsbList = EPSB.getAnEpsbList(stringMatrix);
        System.out.println("EPSB list complete ✓");

        System.out.println("Loading LCSM...");
        lcsmList = TranslatedSuffixTree.getTranslatedSuffixTreeList(stringMatrix);
        System.out.println("LCSM list complete ✓");

        System.out.println("Loading Jaccard list...");
        jacList = Jaccard.getJacList(stringMatrix);
        System.out.println("Jaccard list complete ✓");

        System.out.println("Loading Levenshtein list...");
        levList = Levenshtein.getLevList(stringMatrix);
        System.out.println("Levenshtein list complete ✓");

        System.out.println("===========================");

    }

    static void printSingleLine(ArrayList<String> inputArrayList) {
        System.out.println("Here is the content of the array list");
        inputArrayList.forEach((word) -> System.out.println("\t- " + word));
    }
}
