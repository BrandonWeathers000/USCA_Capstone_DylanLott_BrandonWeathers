// Authors: Dylan Lott & Brandon Weathers
// Date last updated:  12/23/2025 12:56 AM

// Ok Here are my ideas.
// For all of the string comparison algoritms (LCSM, suffix tree, and recusrive suffix tree) the following is necessary:
// 1) take the first two strings and compare them
// 2) get rid of the second input string
// 3) set the first input string to the output of the string comparison
// 4) repeat until one string remains
// This will leave you with the common substring.
// The number of comparisons will be equals to the number of passwords minus 1.

import java.io.*;
import java.util.*;
import java.util.ArrayList.*;

class MultiTesterTool{
    public static final String COMMA_DELIMITER = ",";

    public static void main(String[] args){
        Scanner ob = new Scanner(System.in);

        System.out.println("Welcome, please enter all passwords you wish to analyse. enter \"DONE\" when finished.");
        String currentNewPassword = "";
        String currentInput = "";
        while(!currentInput.equals("DONE")){
            currentInput = ob.nextLine();
            currentNewPassword = currentNewPassword + "," + currentInput;
        }

        // Cropping out unnecessary part of password CSV
        currentNewPassword = currentNewPassword.substring(1, currentNewPassword.length()-5);
        // System.out.println(currentNewPassword);

        boolean userContinue = true;
        while(userContinue){
            passwordAnalysisMethod();
            String userChoice = ob.nextLine(); // Reading in user input as a string so that the default cause can
                                               // catch errors without string to int type conversion error.
            switch(userChoice){
                case "1":
                    System.out.println("Running EPSB...");
                    runEPSB(currentNewPassword);
                    break;
                case "2":
                    System.out.println("Running LCSM...");
                    // runLCSM(currentNewPassword);
                    break;
                case "3":
                    System.out.println("Running suffix tree...");
                    // runSuffixTree(currentNewPassword);
                    break;
                case "4":
                    System.out.println("Running recursive suffix tree...");
                    // runRecursiveSuffixTree(currentNewPassword);
                    break;
                case "q":
                    userContinue = false;
                    System.out.println("Exiting.");
                    break;
                default:
                    System.out.println("Please enter a valid choice");
                    break;
            }
            System.out.println();
        }
    }

    static void passwordAnalysisMethod(){
        System.out.println("\033[H\033[2J"); // Clears the screen
        System.out.println("#########################################################################################");
        System.out.println("Please enter all passwords you with to analyse (hypothetically associated with one uesr).");
        System.out.println("How would you like to analyse the passwords.");
        System.out.println("1) EPSB");
        System.out.println("2) LCSM (old Summer method)"); // Not working yet
        System.out.println("3) Suffix tree");
        System.out.println("4) Recursive suffix tree");
        System.out.println("Enter \"q\" to quit.");
        System.out.println("#########################################################################################");

    }

    static void runEPSB(String allPasswords){
        System.out.println("\033[H\033[2J");
        ArrayList<String> currentLine = new ArrayList<String>();
        try(Scanner rowScanner = new Scanner(allPasswords)){
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while(rowScanner.hasNext()){
                currentLine.add(rowScanner.next());
            }
        }

        // currentLine.forEach((password) -> System.out.print(password + ", "));

        EPSB myEPSB = new EPSB();
        for(String currentPassword : currentLine){
            myEPSB.addNewPassword(currentPassword);
        }
        myEPSB.getInfo();

        System.out.println("Press any key to continue.");
        Scanner myScanner = new Scanner(System.in);
        String waitingForUser = myScanner.nextLine();
    }

    static void runLCSM(String allPasswords){
        // Here the strategy is to break down all passwords into pairs of two passwords you wish to compare.
        // Then, I will compare the two, remove one word, and set of the inputs to the result of the function.
    }
}
