class MultipleStringsFinder{
    public static void main(String[] args){
        // String mainInput1 = "abc";
        // String mainInput2 = "abd";

        // String mainInput1 = "abcXY";
        // String mainInput2 = "abdXY";

        String mainInput1 = "abXYab";
        String mainInput2 = "ablXY";

        System.out.println(recursiveFindLongestCommonSubstring(mainInput1, mainInput2));
    }

    static int findIndexOfFirstString(String input){
        int counter = 1;
        while(true){
            if(input.charAt(counter) == '#'){
                return counter;
            }
            else counter++;
        }
    }

    static String recursiveFindLongestCommonSubstring(String input1, String input2){
        System.out.println("Input 1: " + input1 + "\nInput 2: " + input2);
        String treeInput = input1 + "#" + input2 + "$";

        TranslatedSuffixTree tree = new TranslatedSuffixTree();
        tree.size1 = tree.lengthOfFirstInput(treeInput);
        tree.setInputString(treeInput);
        tree.buildSuffixTree();
        System.out.println("The longest common substring is: " + tree.getLongestCommonSubstring() + "\n");

        input1 = input1.replaceFirst(tree.getLongestCommonSubstring(), "");
        input2 = input2.replaceFirst(tree.getLongestCommonSubstring(), "");

        if((tree.getLongestCommonSubstring().equals("")) || ((input1.length() <= 1) || (input1.length() <= 2))){
            return "We are done.";
        }else{
            return recursiveFindLongestCommonSubstring(input1, input2);
        }
    }
}
