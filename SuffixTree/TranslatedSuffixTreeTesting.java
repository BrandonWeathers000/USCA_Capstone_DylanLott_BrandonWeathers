// Authors: Dylan Lott & Brandon Weathers
// Date last updated:  12/2/2025 12:56 PM

class TranslatedSuffixTreeTesting{
    public static void main(String[] args){
        long startTime = System.nanoTime();
        for(int index = 0; index < 100; index++){
            TranslatedSuffixTree tree = new TranslatedSuffixTree();
            tree.size1 = tree.lengthOfFirstInput("ancplucaskai99ancplucaskai99");
            tree.setInputString("ancplucaskai99ancplucaskai997");

            // This algorithm excels are many inputs. Uncomment and run testing script to see!
            // tree.setInputString("ancplucaskai99ancplucaskai997");
            // tree.setInputString("ancplucaskai99ancplucaskai997");
            // tree.setInputString("ancplucaskai99ancplucaskai997");
            // tree.setInputString("ancplucaskai99ancplucaskai997");
            // tree.setInputString("ancplucaskai99ancplucaskai997");
            // tree.setInputString("ancplucaskai99ancplucaskai997");
            // tree.setInputString("ancplucaskai99ancplucaskai997");
            // tree.setInputString("ancplucaskai99ancplucaskai997");
            // tree.setInputString("ancplucaskai99ancplucaskai997");
            tree.buildSuffixTree();
           System.out.println(tree.getLongestCommonSubstring()); 
        }
        long endTime = System.nanoTime();
        System.out.println("The suffix tree algorithm takes " + (endTime-startTime)/1000000 + " miliseconds comparing 2 entries 100 times.");
    }
}
