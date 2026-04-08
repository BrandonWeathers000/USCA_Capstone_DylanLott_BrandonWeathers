import java.util.*;
import java.io.*;

/**
 * NOTE: I have finished the string 2D ArrayList and the 1D EPSB ArrayList and Jaccard, Multi-LCSM (SuffixTree)
 * TODO: Levenshtein info
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
        Double levInfo = new Double(-1.0);

        // Filling in and printing (the first line) the string matrix 2D ArrayList
        try {
            Scanner myScanner = new Scanner(new File("../Datasets/DataGeneration9_16_25Part2.csv"));
            System.out.println("Reading in file...");
            stringMatrix = myCsvParser.readInStringMatrix(myScanner);
            System.out.println("File read complete ✓");
        }catch(FileNotFoundException e) {
            System.out.println("File not found. ✗");
        }
        printSingleLine(stringMatrix.get(0));

        // Filling in and printing (the first line) the EPSB ArrayList
        epsbList = EpsbListMaker.getAnEpsbList(stringMatrix);
        epsbList.get(0).getInfo();

        // Filling in and printing (the first line) the Jaccard ArrayList
        jacList = JacListMaker.getJacList(stringMatrix);
        System.out.printf("The rounded jac is: %.2f\n", jacList.get(0));

        // Filling in and printing (the first line) the LCSM ArrayList
        lcsmList = TranslatedSuffixTreeListMaker.getTranslatedSuffixTreeList(stringMatrix);
        System.out.println("The longest common substring is: " + lcsmList.get(0));

        // Filling in and printing (the first line) the Lev ArrayList
        levInfo = getLevList(stringMatrix, 0);
        System.out.printf("Lev distance: %.2f\n", levInfo);
    }

    static void printSingleLine(ArrayList<String> inputArrayList) {
        System.out.println("Here is the content of the array list");
        inputArrayList.forEach((word) -> System.out.println("\t- " + word));
    }

    // This method is SOOO resource intensive that its time complexity is...
    // O(number of databse entires * number of passwords in an entry ^ length of longest password)
    // I can't even parse the second entry in a resonable amout of time
    // But can I with other entries
    // So I'm not going to go through each line of the databse; it would take days.
    static Double getLevList(ArrayList<ArrayList<String>> stringMatrix, int entryToBeAnalyzed) {
        Double levInfo = Levenshtein.multiLev(stringMatrix.get(entryToBeAnalyzed));

        return levInfo;
    }
}
