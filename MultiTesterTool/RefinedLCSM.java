// Author(s): Dylan Lott & Brandon Weathers
// Last updated: 12/30/2025 10:57 PM

import java.util.List;
import java.util.ArrayList;

class RefinedLCSM{
    public static void main(String[] args){
        ArrayList<String> input = new ArrayList<>();
        // input.add("GeeksForGe");
        // input.add("GeeGeeksGeeForGe");
        // input.add("GeekForGe");
        // input.add("GeekForGes");

        input.add("GeeksForGe");
        input.add("a");
        input.add("GeekForGe");
        input.add("GeekForGes");

        List<String> results = new ArrayList<>();
        results = returnAllCommonSubstrings(input);
        results.forEach((currentPassword) -> System.out.print(currentPassword + ", "));
    }

    public static List<String> returnAllCommonSubstrings(ArrayList<String> allInputs){
        List<String> results = new ArrayList<>();
        results = returnCommonSubstrings(allInputs.get(0), allInputs.get(1));
        if(results .size() == 0){
            // System.out.println("No common substrings.");
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
