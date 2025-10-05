// Author(s): Brandon Weathers
// Last updated: 10/05/2025 2:57 PM

// This class simply reads throuhg a given CVS files and creates a
// 2D ArrayList to store every word.
// Because of the way the CSV files are organized, the username is first, followed by
// its associated passwords.

import java.util.*;
import java.io.*;

class TextParser{
    public static final String COMMA_DELIMITER = ",";
    public static void main(String[] args){
        // The dataset 1
        ArrayList<ArrayList<String>> dataset1 = new ArrayList<>();

        // This scans the DataGeneration9_16_25Part1.cvs line by line.
        try(Scanner myScanner = new Scanner(new File("DataGeneration9_16_25Part1.cvs"))){
            while(myScanner.hasNextLine()){
                dataset1.add(getRecordFromLine(myScanner.nextLine()));
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }

        // Printing out dataset 1
        System.out.println();
        System.out.println("This is dataset 1");
        for(ArrayList<String> currentLine : dataset1){
            System.out.println(currentLine.toString());
        }

        // The dataset 2
        ArrayList<ArrayList<String>> dataset2 = new ArrayList<>();

        // This scans the DataGeneration9_16_25Part2.cvs line by line.
        try(Scanner myScanner = new Scanner(new File("DataGeneration9_16_25Part2.cvs"))){
            while(myScanner.hasNextLine()){
                dataset2.add(getRecordFromLine(myScanner.nextLine()));
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }

        // Printing out dataset 2
        System.out.println();
        System.out.println("This is dataset2 2");
        for(ArrayList<String> currentLine : dataset2){
            System.out.println(currentLine.toString());
        }

        // The dataset 3
        ArrayList<ArrayList<String>> dataset3 = new ArrayList<>();

        // This scans the DataGeneration9_16_25Part3.cvs line by line.
        try(Scanner myScanner = new Scanner(new File("DataGeneration9_16_25Part3.cvs"))){
            while(myScanner.hasNextLine()){
                dataset3.add(getRecordFromLine(myScanner.nextLine()));
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found.");
        }

        // Printing out dataset 3
        System.out.println();
        System.out.println("This is dataset 3");
        for(ArrayList<String> currentLine : dataset3){
            System.out.println(currentLine.toString());
        }
    }

    // This breaks each line up into words using the comma as a delimiter
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
