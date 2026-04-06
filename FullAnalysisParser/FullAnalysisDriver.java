import java.util.*;
import java.io.*;

/**
 * NOTE: I have finished the string 2D ArrayList and the 1D EPSB ArrayList and Jaccard
 * TODO: 1D ArrayList of LCSM, Multi-LCSM (SuffixTree), Levenshtein info
 *
 * My plan is to create a mini database where you have a matrix of strings and then a stiched together 2D matrix of all the info EPSB, Jaccard, LCSM, etc.
 * I can then query all of this info whenever I want.
 */

public class FullAnalysisDriver {
    public static void main(String[] args) {

        // All important info matrices
        CsvParser myCsvParser = new CsvParser();
        ArrayList<ArrayList<String>> stringMatrix = new ArrayList<>();
        ArrayList<EPSB> epsbList = new ArrayList<>();
        ArrayList<Double> jacList = new ArrayList<>();

        // Filling in and printing (the first line) the string matrix 2D ArrayList
        try {
            Scanner myScanner = new Scanner(new File("../Datasets/DataGeneration9_16_25Part2.csv"));
            System.out.println("Reading in file...");
            stringMatrix = myCsvParser.readInStringMatrix(myScanner);
            System.out.println("File read complete ✓");
        }catch(FileNotFoundException e) {
            System.out.println("File not found. ✗");
        }
        printSingleLine(stringMatrix.get(1));

        // Filling in and printing (the first line) the EPSB ArrayList
        // epsbList = EpsbListMaker.getAnEpsbList(stringMatrix);
        // epsbList.get(0).getInfo();

        // Filling in and printing (the first line) the Jaccard ArrayList
        // jacList = JacListMaker.getJacList(stringMatrix);
        // System.out.printf("The rounded jac is: %.2f", jacList.get(0));
    }

    static void printSingleLine(ArrayList<?> inputArrayList) {
        System.out.println("Here is the content of the array list");
        inputArrayList.forEach((word) -> System.out.println("\t- " + word));
    }

}
