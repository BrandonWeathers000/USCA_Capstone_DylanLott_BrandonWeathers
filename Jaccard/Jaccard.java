import java.util.*;
import java.util.HashMap;

class Jaccard {
    public static void main(String[] args) {
        String inputOne = "abc", inputTwo  = "bcd";

        System.out.println(jac(inputOne, inputTwo));
    }

    static double jac(String a, String b) {
        String intersection = findIntersection(a, b);
        int sizeOfIntersection  = intersection.length();


        return (double) (sizeOfIntersection) / (double) ((a.length() + b.length() - sizeOfIntersection));
    }


    static String findIntersection(String s1, String s2) {
        StringBuilder ans = new StringBuilder();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char character = s1.charAt(i);
            map.put(character,
                    map.getOrDefault(character, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {
            char character = s2.charAt(i);
            if (map.containsKey(character)
                && map.get(character) > 0) {

                ans.append(character);
                map.put(character, map.get(character) - 1);
            }
        }

        return ans.toString();
    }
}
