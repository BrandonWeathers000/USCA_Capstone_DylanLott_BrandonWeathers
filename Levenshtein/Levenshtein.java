import java.util.Arrays;

class Levenshtein{
    public static void main(String[] args) {
        String inputOne = "a", inputTwo = "b";
        System.out.println("\nThe lev distance is: " + lev(inputOne, inputTwo));
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
