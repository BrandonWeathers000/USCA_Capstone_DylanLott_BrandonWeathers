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

        // Filling in and printing (the first line) the string matrix 2D ArrayList
        try {
            Scanner myScanner = new Scanner(new File("../Datasets/DataGeneration9_16_25Part2.csv"));
            System.out.println("Reading in file...");
            stringMatrix = myCsvParser.readInStringMatrix(myScanner);
            System.out.println("File read complete ✓");
        }catch(FileNotFoundException e) {
            System.out.println("File not found. ✗");
        }

        // printSingleLine(stringMatrix.get(1));
        lcsmList = getLcsmList(stringMatrix);
        for(int i = 0; i < stringMatrix.size(); i++) {
            printSingleLine(stringMatrix.get(i));
            System.out.println(lcsmList.get(i));
        }

        // Filling in and printing (the first line) the EPSB ArrayList
        // epsbList = EpsbListMaker.getAnEpsbList(stringMatrix);
        // epsbList.get(0).getInfo();

        // Filling in and printing (the first line) the Jaccard ArrayList
        // jacList = JacListMaker.getJacList(stringMatrix);
        // System.out.printf("The rounded jac is: %.2f", jacList.get(0));

        // Filling in and printing (the first line) the LCSM ArrayList
    }

    static void printSingleLine(ArrayList<String> inputArrayList) {
        System.out.println("Here is the content of the array list");
        inputArrayList.forEach((word) -> System.out.println("\t- " + word));
    }

    static ArrayList<String> getLcsmList(ArrayList<ArrayList<String>> stringMatrix) {
        ArrayList<String> returnList = new ArrayList<>();

        for(ArrayList<String> currentLine : stringMatrix) {
            TranslatedSuffixTree tree = new TranslatedSuffixTree();
            tree.size1 = tree.lengthOfFirstInput(currentLine.get(0) + "#" + currentLine.get(1) + "$");
            tree.setInputString(currentLine.get(0) + "#" + currentLine.get(1) + "$");
            tree.buildSuffixTree();
            String currentMatch = tree.getLongestCommonSubstring();

            TranslatedSuffixTree tree2 = new TranslatedSuffixTree();
            tree.size1 = tree.lengthOfFirstInput(currentMatch + "#" + currentLine.get(2) + "$");
            tree.setInputString(currentMatch + "#" + currentLine.get(2) + "$");
            tree.buildSuffixTree();
            currentMatch = tree.getLongestCommonSubstring();
            returnList.add(currentMatch);
        }

        return returnList;
    }
}
