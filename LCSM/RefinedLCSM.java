import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @version 1.0
 * @author Dylan Lott
 * @author Brandon Weathers
 * <hr>
 * After extensive working and reworking. I have produced an algorithm that find
 * the common substring amoung any given number of input strings.
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

        // input.add("Bo1abc");
        // input.add("Bo2abc");
        // input.add("Bo3abc");

        // input.add("Bob1abc");
        // input.add("Bob2abc");
        // input.add("Bob3abc");

        input.add("Bobby1abc");
        input.add("Bobby2abc");
        input.add("Bobby3abc");

        ArrayList<String> results = new ArrayList<>();
        results = returnAllSubstringMultiInput(input);
        results.forEach((currentPassword) -> System.out.println(currentPassword));
    }


    public static ArrayList<String> returnAllSubstringMultiInput(ArrayList<String> input){;
        // System.out.println("The inputs are:");
        // input.forEach((element) -> System.out.println(element));

        ArrayList<String> results = new ArrayList<>();
        Set<String> firstComparison = maximalCommonSubstrings(input.get(0), input.get(1));

        for(String currentSubstring : firstComparison){
                results.add(currentSubstring);
        }

        // System.out.println("The results of the first comparison are:");
        // results.forEach((element) -> System.out.println(element));

        for(int index = 2; index < input.size(); index++){
                Set<String> newResults = new HashSet<>();
                for(String currentOldResult : results){
                        // Set<String> additionalResults = new HashSet<>();
                        // additionalResults = maximalCommonSubstrings(input.get(index), currentOldResult);
                        // newResults.addAll(additionalResults);

                        newResults.addAll(maximalCommonSubstrings(input.get(index), currentOldResult));

                        // System.out.println("When compared to the third string the new results are:");
                        // newResults.forEach((element) -> System.out.println(element));
                }

                results.clear();
                for(String currentSubstring : newResults){
                        results.add(currentSubstring);
                }
        }

        return results;
    }

    public static Set<String> maximalCommonSubstrings(String s, String t){
        int[][] table = new int[s.length()][t.length()];
        Set<String> result = new HashSet<>();

        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < t.length(); j++){
                if (s.charAt(i) != t.charAt(j)){
                    continue;
                }

                table[i][j] = (i == 0 || j == 0) ? 1 : table[i - 1][j - 1] + 1;

                int len = table[i][j];

                boolean cannotExtend = (i == s.length() - 1) || (j == t.length() - 1) || (s.charAt(i + 1) != t.charAt(j + 1));

                if (len > 0 && cannotExtend){
                    result.add(s.substring(i - len + 1, i + 1));
                }
            }
        }

        // for(int[] row : table){
        //     for(int cell : row){
        //         System.out.print(cell + " ");
        //     }
        //     System.out.println();
        // }

        return result;
    }
}
