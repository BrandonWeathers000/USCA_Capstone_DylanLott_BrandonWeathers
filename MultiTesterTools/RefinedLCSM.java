package MultiTesterTools;

import java.util.List;
import java.util.ArrayList;

/**
 * @version 1.0
 * @author Dylan Lott
 * @author Brandon Weathers
 * <hr>
 * WARNING: This classes posses inneffiences that I am disatsfied with.
 * I must rewrite this algorithm to imporve its preformance.
 *
 * This class provies methods a single substring amoung an non-zero number of input strings.
 */

public class RefinedLCSM{
    /**
     * This is the entry point.
     * It is usually used for testing.
     *
     * @param args command-line arguments not used
     */
    public static void main(String[] args){
        ArrayList<String> input = new ArrayList<>();

        input.add("Bo1abc");
        input.add("Bo2abc");
        input.add("Bo3abc");

        // input.add("Bob1abc");
        // input.add("Bob2abc");
        // input.add("Bob3abc");

        // input.add("Bobby1abc");
        // input.add("Bobby2abc");
        // input.add("Bobby3abc");

        List<String> results = new ArrayList<>();
        results = returnAllCommonSubstrings(input);
        results.forEach((currentPassword) -> System.out.print(currentPassword + ", "));
    }

    /**
     * This method returns all of the LONGEST common substrings given an ArrayList of input strings.
     *
     * @param allInputs the ArrayList of all String inputs
     * @return a List of Strings that represent all common substring withtin all inputs
     */
    public static List<String> returnAllCommonSubstrings(ArrayList<String> allInputs){
        List<String> results = new ArrayList<>();
        results = returnCommonSubstrings(allInputs.get(0), allInputs.get(1));
        if(results .size() == 0){
            System.out.println("No common substrings.");
            return results;
        }
        // System.out.println("The substrings from S1 and S2 are:");
        // results.forEach((currentSubstring) -> System.out.println("\"" + currentSubstring + "\""));
        // System.out.println();
        for(int index = 2; index < allInputs.size(); index++){
            singleAuxiliaryComparison(allInputs.get(index), results);
        }

        return results;
    }

    /**
     * This method returns all the common substrings given just two input Strings
     *
     * @param s1 the first string to be compared
     * @param s2 the second string to be compared
     * @return result a List of Strings the both inputs share
     */
    public static List<String> returnCommonSubstrings(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] LCSuf = new int[m + 1][n + 1];
        int maxLen = 0;
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    LCSuf[i][j] = LCSuf[i - 1][j - 1] + 1;
                    // res = Math.max(res, LCSuf[i][j]);

                    if(LCSuf[i][j] > maxLen){
                        maxLen = LCSuf[i][j];
                        result.clear();
                        result.add(s1.substring(i - maxLen, i));
                    }else if(LCSuf[i][j] == maxLen && maxLen > 0){
                        result.add(s1.substring(i - maxLen, i));
                    }
                }
            }
        }
        return result;
    }

    /**
     * This method compares the single other input string to the list of possible results to see if they match
     *
     * @param otherInputString the 3rd through nth element of all inputs to be compared
     * @param results the list to be checked against
     * @return a List of String that represent all elements that pass the conditions
     */
    public static List<String> singleAuxiliaryComparison(String otherInputString, List<String> results){
        for(int index = 0; index <= results.size(); index++){
            List<String> possibleNewSubstrings = new ArrayList<>();
            possibleNewSubstrings = new ArrayList<>();
            possibleNewSubstrings = returnCommonSubstrings(otherInputString, results.get(0));
            // System.out.println("The comparison of " + otherInputString + " and " + results.get(0) + " leaves the results looking as such:");
            if(!(possibleNewSubstrings.isEmpty())){
                for(String currentPossibleString : possibleNewSubstrings){
                    results.add(currentPossibleString);
                    results.remove(0);
                }
            }else{
                results.remove(0);
            }
            // results.forEach((currentSubstring) -> System.out.println("\"" + currentSubstring + "\""));
            // System.out.println();
        }
        return results;
    }
}
