import java.util.*;
import java.io.*;

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
                    totalLev += levenshteinTwoMatrixRows(userPasswords.get(i), userPasswords.get(j));
                }
            }
        }
        return (double) totalLev / ((double) ((userPasswords.size() * userPasswords.size()) - userPasswords.size()));
    }

    // static int lev(String a, String b) {
    //     if(head(b).length() == 0) return a.length();
    //     if(head(a).length() == 0) return b.length();
    //     if(head(a).equals(head(b))) return lev(tail(a), tail(b));

    //     int[] lastStep = {lev(tail(a), b), lev(a, tail(b)), lev(tail(a), tail(b))};
    //     Arrays.sort(lastStep);

    //     return (1 + lastStep[0]);
    // }

    public static int levenshteinTwoMatrixRows(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        // Initializing two arrays to store the current and previous row values
        int[] prevRow = new int[n + 1];
        int[] currRow = new int[n + 1];

        // Initializing the first row with increasing integers
        for (int j = 0; j <= n; j++) {
            prevRow[j] = j;
        }

        // Looping through each character of str1
        for (int i = 1; i <= m; i++) {
            // Initializing the first element of the current row with the row number
            currRow[0] = i;

            // Looping through each character of str2
            for (int j = 1; j <= n; j++) {
                // If characters are equal, no operation needed, take the diagonal value
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    currRow[j] = prevRow[j - 1];
                } else {
                    // If characters are not equal, find the minimum value of insert, delete, or replace
                    currRow[j] = 1 + Math.min(currRow[j - 1], Math.min(prevRow[j], prevRow[j - 1]));
                }
            }

            // Update prevRow with currRow values
            prevRow = Arrays.copyOf(currRow, currRow.length);
        }

        // Return the final Levenshtein distance stored at the bottom-right corner of the matrix
        return currRow[n];
    }


    static String head(String input) {
        if(input.length() == 0) return "";
        return input.substring(0, 1);
    }

    static String tail(String input) {
        if((input.length() == 0) || (input.length() == 1)) return "";
        return input.substring(1);
    }

    static ArrayList<Double> getLevList(ArrayList<ArrayList<String>> stringMatrix) {
        ArrayList<Double> levList = new ArrayList<>();

        for(ArrayList<String> currentEntry : stringMatrix) {
            levList.add(Levenshtein.multiLev(currentEntry));
        }

        return levList;
    }
}
