// Author(s): Dylan Lott & Brandon Weathers
// Last updated: 12/27/2025 3:08 PM

import java.util.List;
import java.util.ArrayList;

class RefinedLCSM{
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
            System.out.println("The comparison of " + otherInputString + " and " + results.get(0) + " leaves the results looking as such:");
            if(!(possibleNewSubstrings.isEmpty())){
                for(String currentPossibleString : possibleNewSubstrings){
                    results.add(currentPossibleString);
                    results.remove(0);
                }
            }else{
                results.remove(0);
            }
            results.forEach((currentSubstring) -> System.out.println("\"" + currentSubstring + "\""));
            System.out.println();
        }
        return results;
    }

    public static void main(String[] args){
        String S1 = "GeeksForGeeks";
        String S2 = "GeeGeeksGeeForGe";
        String S3 = "For";
        String S4 = "o";

        List<String> results = new ArrayList<>();
        results = returnCommonSubstrings(S1, S2);
        System.out.println("The substrings from S1 and S2 are:");
        results.forEach((currentSubstring) -> System.out.println("\"" + currentSubstring + "\""));
        System.out.println();

        singleAuxiliaryComparison(S3, results);

        // for(int index = 0; index <= results.size(); index++){
        //     List<String> possibleNewSubstrings = new ArrayList<>();
        //     possibleNewSubstrings = returnCommonSubstrings(S3, results.get(0));
        //     System.out.println("The comparison of " + S3 + " and " + results.get(0) + " leaves the results looking as such:");
        //     if(!(possibleNewSubstrings.isEmpty())){
        //         for(String currentPossibleString : possibleNewSubstrings){
        //             results.add(currentPossibleString);
        //             results.remove(0);
        //         }
        //     }else{
        //         results.remove(0);
        //     }
        //     results.forEach((currentSubstring) -> System.out.println("\"" + currentSubstring + "\""));
        //     System.out.println();
        // }

        // possibleNewSubstrings = returnCommonSubstrings(S3, results.get(0));
        // System.out.println("The comparison of " + S3 + " and " + results.get(0) + " leaves the results looking as such:");
        // if(!(possibleNewSubstrings.isEmpty())){
        //     for(String currentPossibleString : possibleNewSubstrings){
        //         results.add(currentPossibleString);
        //         results.remove(0);
        //     }
        // }else{
        //     results.remove(0);
        // }
        // results.forEach((currentSubstring) -> System.out.println("\"" + currentSubstring + "\""));
        // System.out.println();

        // possibleNewSubstrings = returnCommonSubstrings(S3, results.get(0));
        // System.out.println("The comparison of " + S3 + " and " + results.get(0) + " leaves the results looking as such:");
        // if(!(possibleNewSubstrings.isEmpty())){
        //     for(String currentPossibleString : possibleNewSubstrings){
        //         results.add(currentPossibleString);
        //         results.remove(0);
        //     }
        // }else{
        //     results.remove(0);
        // }
        // results.forEach((currentSubstring) -> System.out.println("\"" + currentSubstring + "\""));
        // System.out.println();
    }
}
