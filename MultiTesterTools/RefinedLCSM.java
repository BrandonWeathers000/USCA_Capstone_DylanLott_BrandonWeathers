package MultiTesterTools;

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

        Set<String> results = new HashSet<>();
        results = maximalCommonSubstrings("Bobby1abc", "Bobby2abc");
        results.forEach((currentPassword) -> System.out.print(currentPassword + ", "));
    }

    public static returnAllSubstringMultiInput(ArrayList<String> input){;
        ArrayList<String> results = new ArrayList<Srings>();
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
