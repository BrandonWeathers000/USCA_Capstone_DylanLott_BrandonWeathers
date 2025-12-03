// Authors: Dylan Lott & Brandon Weathers
// Date last updated:  12/2/2025 12:56 PM

class TranslatedSuffixTreeTesting{
    public static void main(String[] args){


        long startTime = System.nanoTime();
        for(int index = 0; index < 100; index++){
            TranslatedSuffixTree tree = new TranslatedSuffixTree();
            tree.size1 = tree.lengthOfFirstInput("Password_A#Password_B$");
            tree.setInputString("Password_A#Password_B$");
            tree.buildSuffixTree();
            tree.getLongestCommonSubstringTesting();
        }
        long endTime = System.nanoTime();
        System.out.println("The suffix tree algorithm takes " + (endTime-startTime)/1000000 + " miliseconds for 2 entries 100 times.");
    }
}
