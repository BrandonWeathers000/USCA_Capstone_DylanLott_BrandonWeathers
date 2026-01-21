package MultiTesterTools;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @version 1.0
 * @author Dylan Lott
 * @author Brandon Weathers
 * <hr>
 * This class provies methods for findings substrings (and subsequences) when provided multiple inputs strings.
 */

public class MultipleStringsFinder{
    public static final String COMMA_DELIMITER = ",";

    /**
     * This is the entry point.
     * It is usually used for testing.
     *
     * @param args command-line arguments not used
     */
    public static void main(String[] args){
        // String mainInput1 = "abXYab";
        // String mainInput2 = "ablXY";
        ArrayList<String> craftRiseDataset = new ArrayList<String>();

        BufferedReader reader;
        try{
            reader = new BufferedReader(new FileReader("CraftRiseFiltered_35.csv"));
            String line = reader.readLine();

            while(line != null){
                // System.out.println(line);
                craftRiseDataset.add(line);
                line = reader.readLine();
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }

        for(String currentTwoPasswords : craftRiseDataset){
            System.out.println("A new password set:");
            String input0 = currentTwoPasswords.substring(0, findIndexOfFirstString(currentTwoPasswords));
            String input1 = currentTwoPasswords.substring(findIndexOfFirstString(currentTwoPasswords) + 1, currentTwoPasswords.length() - 1);

            ArrayList<String> allSubstrings = new ArrayList<String>();
            recursiveFindLongestCommonSubstring(input0, input1, allSubstrings);
            allSubstrings.forEach((currentString) -> System.out.print(currentString + " "));
            System.out.println();
        }
    }

    /**
     * This method finds where the hash delimiter appears in the concatonated word
     *
     * @param input this represents the long string where you don't know where the hash is
     * @return counter this represents hash's location
     */
    static int findIndexOfFirstString(String input){
        int counter = 1;
        while(true){
            if(input.charAt(counter) == '#'){
                return counter;
            }
            else counter++;
        }
    }

    /**
     * This method recursively find the longest common substring given two inputs strings
     * and an empty ArrayList of strings
     *
     * @param input1 the first string you wish to analyse
     * @param input2 the second string you wish to analyse
     */
    static void recursiveFindLongestCommonSubstring(String input1, String input2, ArrayList<String> allSubstrings){
        // System.out.println("Input 1: " + input1 + "\nInput 2: " + input2);
        String treeInput = input1 + "#" + input2 + "$";

        TranslatedSuffixTree tree = new TranslatedSuffixTree();
        tree.size1 = tree.lengthOfFirstInput(treeInput);
        tree.setInputString(treeInput);
        tree.buildSuffixTree();
        allSubstrings.add(tree.getLongestCommonSubstring());
        // System.out.println("The longest common substring is: " + tree.getLongestCommonSubstring() + "\n");

        input1 = input1.replaceFirst(tree.getLongestCommonSubstring(), "");
        input2 = input2.replaceFirst(tree.getLongestCommonSubstring(), "");

        if((tree.getLongestCommonSubstring().equals("")) || ((input1.length() <= 1) || (input1.length() <= 2))){
        }else{
            recursiveFindLongestCommonSubstring(input1, input2, allSubstrings);
        }
    }
}
