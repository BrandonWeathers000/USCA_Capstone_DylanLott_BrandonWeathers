package MultiTesterTools;

import java.util.*;

class Levenshtein{
    public static void main(String[] args) {
        String inputOne = "ABC", inputTwo = "BCD", inputThree = "CDE";

        // System.out.println("Input one is: " + inputOne);
        // System.out.println("Input two is: " + inputTwo);
        // System.out.println("The lev distance is: " + lev(inputOne, inputTwo));

        ArrayList<String> inputArrayList = new ArrayList<String>();
        inputArrayList.add(inputOne);
        inputArrayList.add(inputTwo);
        inputArrayList.add(inputThree);

        System.out.printf("The average lev distance (rounded to two decimals) is: %.2f", multiLev(inputArrayList));
    }

    static double multiLev(ArrayList<String> userPasswords) {
        int totalLev = 0;
        for(int i = 0; i < userPasswords.size(); i++) {
            for(int j = 0; j < userPasswords.size(); j++) {
                if (i != j) {
                    // System.out.println(userPasswords.get(i) + " + " + userPasswords.get(j) + " = " + lev(userPasswords.get(i), userPasswords.get(j)));
                    totalLev += lev(userPasswords.get(i), userPasswords.get(j));
                }
            }
        }
        return (double) totalLev / ((double) ((userPasswords.size() * userPasswords.size()) - userPasswords.size()));
    }

    static int lev(String a, String b) {
        if(head(b).length() == 0) return a.length();
        if(head(a).length() == 0) return b.length();
        if(head(a).equals(head(b))) return lev(tail(a), tail(b));

        int[] lastStep = {lev(tail(a), b), lev(a, tail(b)), lev(tail(a), tail(b))};
        Arrays.sort(lastStep);

        return (1 + lastStep[0]);
    }

    static String head(String input) {
        if(input.length() == 0) return "";
        return input.substring(0, 1);
    }

    static String tail(String input) {
        if((input.length() == 0) || (input.length() == 1)) return "";
        return input.substring(1);
    }
}
