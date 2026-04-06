import java.util.*;

class Jaccard {
    public static void main(String[] args) {
        String inputOne = "password1", inputTwo = "password2", inputThree = "password3";

        // System.out.println(jac(inputOne, inputTwo));

        ArrayList<String> inputArrayList = new ArrayList<String>();
        inputArrayList.add(inputOne);
        inputArrayList.add(inputTwo);
        inputArrayList.add(inputThree);

        System.out.printf("The average jac distance (rounded to two decimals) is: %.2f", multiJac(inputArrayList));
    }

    static double multiJac(ArrayList<String> userPasswords) {
        double totalJac = 0;
        for(int i = 0; i < userPasswords.size(); i++) {
            for(int j = 0; j < userPasswords.size(); j++) {
                if (i != j) {
                    // System.out.println(userPasswords.get(i) + " + " + userPasswords.get(j) + " = " + jac(userPasswords.get(i), userPasswords.get(j)));
                    totalJac += jac(userPasswords.get(i), userPasswords.get(j));
                }
            }
        }
        return totalJac / ((double) ((userPasswords.size() * userPasswords.size()) - userPasswords.size()));
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
