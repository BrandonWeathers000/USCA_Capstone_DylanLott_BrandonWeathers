import java.util.ArrayList;

class MultipleStringsFinderTesting{
    public static void main(String[] args){
        String mainInput1 = "ancplucaskai99ancplucaskai99";
        String mainInput2 = "ancplucaskai99ancplucaskai997";

        long startTime = System.nanoTime();
        for(int index = 0; index < 100; index++){
            ArrayList<String> allSubstrings = new ArrayList<String>();
            recursiveFindLongestCommonSubstring(mainInput1, mainInput2, allSubstrings);
        }
        long endTime = System.nanoTime();
        System.out.println("The RECURSIVE suffix tree algorithm takes " + (endTime-startTime)/1000000 + " miliseconds comparing 2 entries 100 times.");
    }

    static void recursiveFindLongestCommonSubstring(String input1, String input2, ArrayList<String> allSubstrings){
        // String treeInput = input1 + "#" + input2 + "$"; // String conconation in this way takes up 60% of the time.
        String treeInput  = input1.concat("#").concat(input2).concat("$");

        TranslatedSuffixTree tree = new TranslatedSuffixTree();
        tree.size1 = tree.lengthOfFirstInput(treeInput);
        tree.setInputString(treeInput);
        tree.buildSuffixTree();
        allSubstrings.add(tree.getLongestCommonSubstring());

        input1 = input1.replaceFirst(tree.getLongestCommonSubstring(), "");
        input2 = input2.replaceFirst(tree.getLongestCommonSubstring(), "");

        if((tree.getLongestCommonSubstring().equals("")) || (input1.length() <=2)){
            return;
        }else{
            recursiveFindLongestCommonSubstring(input1, input2, allSubstrings);
        }

    }
}
