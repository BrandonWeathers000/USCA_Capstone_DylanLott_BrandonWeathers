package Capstone.MultiTester;

import java.util.*;

/**
 * @version 1.0
 * @author Dylan Lott
 * @author Brandon Weathers
 * <hr>
 * This class be meant to be ran as a way to test multiple ways to analyses passwords.
 * It provides a clean interface for users to enter passwords a have them analyses.
 */
public class MultiTesterTool{
    /**
     * This class is not ment to be constructed and ran in another program; it's ment to be ran itself.
     */
    public MultiTesterTool(){
    }

    /**
     * This is the entry point.
     *
     * @param args command-line arguments not used
     */
    public static void main(String[] args){
        System.out.println("\033[H\033[2J");
        System.out.println("Greetings user! Welcome to the multitesting tool.");

        ArrayList<String> userPasswords = new ArrayList<>();
        readInUserPasswords(userPasswords);
        // System.out.println("The user passwords are:");
        // userPasswords.forEach((currentPassword) -> System.out.print(currentPassword + ", "));

        Scanner ob = new Scanner(System.in);
        String userInput = "";

        while(!(userInput.equals("q"))){
            userInput = ob.nextLine();
            switch(userInput){
                case "1" -> useEPSB(userPasswords);
                case "2" -> useRefinedLCSM(userPasswords);
                case "3" -> useSuffixTree(userPasswords);
                case "r" -> { System.out.println("\033[H\033[2J"); readInUserPasswords(userPasswords); }
                case "q" -> System.out.println("Exiting");
                case ""  -> System.out.print(">>> ");
                default  -> System.out.print("Please enter a valid answer\n>>> ");
            }
        }
    }

    /**
     * Allows for the inputs of strings via the command line.
     *
     * @param userPasswords the blank (or old) list of user passwords
     * @return ArrayList the new list of user passwords
     */
    public static ArrayList<String> readInUserPasswords(ArrayList<String> userPasswords){
        System.out.println("Please enter below the passwords you would like to analyse, enter \"q\" when finished");

        userPasswords.clear();
        Scanner ob = new Scanner(System.in);
        String currentPassword = "";
        while(!(currentPassword.equals("q"))){
            System.out.print(">>> ");
            currentPassword = ob.nextLine();
            userPasswords.add(currentPassword);
        }
        userPasswords.remove(userPasswords.size()-1);

        System.out.println("\033[H\033[2J");
        printMainMenu(userPasswords);
        System.out.print(">>> ");

        return userPasswords;
    }

    /**
     * Prints the main menu.
     *
     * @param userPasswords the blank (or old) list of user passwords
     */
    public static void printMainMenu(ArrayList<String> userPasswords){
        System.out.println("The passwords to be analysed are as follows:");
        userPasswords.forEach((currentPassword) -> System.out.println("\t- " + currentPassword));
        System.out.println();
        System.out.println("Please choosing the following method to analyse the previous input:");
        System.out.println("\t1) EPSB");
        System.out.println("\t2) All common substrings (Summer method)");
        System.out.println("\t3) Multiple common substrings (with squashing, first two strings only)");
        System.out.println("\tr) Read in a new set of passwords");
        System.out.println("\tq) Quit the program");
    }

    /**
     * Creates and uses an EPSB object to analyse passwords.
     * Processes one password at a time.
     *
     * @param userPasswords the blank (or old) list of user passwords
     */
    public static void useEPSB(ArrayList<String> userPasswords){
        System.out.println("\033[H\033[2J");
        Scanner ob = new Scanner(System.in);
        EPSB myEPSB = new EPSB();
        for(String currentPassword : userPasswords){
            myEPSB.addNewPassword(currentPassword);
        }
        myEPSB.getInfo();
        System.out.println();
        System.out.println("Press any key to continue.");
        String waitingForUser1 = ob.nextLine();
        System.out.println("\033[H\033[2J");
        printMainMenu(userPasswords);
        System.out.print(">>> ");
    }

    /**
     * Creates the refined version of the LCSM object
     * and uses its new algorithm to process all user given strings.
     *
     * @param userPasswords the blank (or old) list of user passwords
     */
    public static void useRefinedLCSM(ArrayList<String> userPasswords){
        System.out.println("\033[H\033[2J");

        Scanner ob = new Scanner(System.in);
        RefinedLCSM myRefinedLCSM = new RefinedLCSM();
        List<String> results = new ArrayList<>();

        results = RefinedLCSM.returnAllCommonSubstrings(userPasswords);

        if(results.size() == 0){
            System.out.println("No common substrings.");
        }else{
            System.out.println("All common substrings are as follows:");
            results.forEach((currentString) -> System.out.println("\t- " + currentString));
        }

        System.out.println();
        System.out.println("Press any key to continue.");
        String waitingForUser1 = ob.nextLine();
        System.out.println("\033[H\033[2J");

        printMainMenu(userPasswords);
        System.out.print(">>> ");
    }

    /**
     * Creates a SuffixTree object and read two strings at a time.
     * It then returns the longest common substring and all other commonsubstrings,
     * with squashing, up to a 2 character minimmum.
     *
     * @param userPasswords the blank (or old) list of user passwords
     */
    public static void useSuffixTree(ArrayList<String> userPasswords){
        System.out.println("\033[H\033[2J");
        Scanner ob = new Scanner(System.in);
        ArrayList<String> allSubstrings = new ArrayList<String>();

        System.out.println("Please provide the index of the two strings you wish to compare:");
        int userIndex1 = ob.nextInt();
        int userIndex2 = ob.nextInt();
        System.out.println("\033[H\033[2J");

        MultipleStringsFinder.recursiveFindLongestCommonSubstring(userPasswords.get(userIndex1 - 1), userPasswords.get(userIndex2 - 1), allSubstrings);

        if(allSubstrings.get(0).equals("")){
            System.out.println("No common substrings.");
        }else{
            System.out.println("All common substrings (with squashing) are as follows:");
            allSubstrings.forEach((currentString) -> System.out.println("\t- " + currentString));
        }

        System.out.println();
        System.out.println("Press any key to continue.");
        String waitingForUser1 = ob.nextLine();
        waitingForUser1 = ob.nextLine();
        System.out.println("\033[H\033[2J");

        printMainMenu(userPasswords);
        System.out.print(">>> ");
    }
}
