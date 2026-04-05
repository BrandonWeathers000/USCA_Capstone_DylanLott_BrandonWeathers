import java.util.*;
import java.io.*;

/**
 * NOTE: I have finished the string 2D ArrayList and the 1D EPSB ArrayList
 * TODO: 1D ArrayList of Jaccard, LCSM, Multi-LCSM (SuffixTree), Levenshtein info
 *
 * My plan is to create a mini database where you have a matrix of strings and then a stiched together 2D matrix of all the info EPSB, Jaccard, LCSM, etc.
 * I can then query all of this info whenever I want.
 */

public class FullAnalysisDriver {
    public static void main(String[] args) {

        // All important info matrices
        CsvParser myCsvParser = new CsvParser();
        ArrayList<ArrayList<String>> stringMatrix = new ArrayList<>();
        ArrayList<EPSB> epsbMatrix = new ArrayList<>();

        // Creating the string matrix
        try {
            Scanner myScanner = new Scanner(new File("../Datasets/DataGeneration9_16_25Part2.csv"));
            stringMatrix = myCsvParser.readInStringMatrix(myScanner);
        }catch(FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Creating the EPSB ArrayList
        epsbMatrix = EpsbMatrixMaker.getAnEpsbMatrix(stringMatrix);

        // Printing out EPSB info
        stringMatrix.get(1).forEach((word) -> System.out.println("\t- " + word));
        epsbMatrix.get(1).getInfo();
    }
}
