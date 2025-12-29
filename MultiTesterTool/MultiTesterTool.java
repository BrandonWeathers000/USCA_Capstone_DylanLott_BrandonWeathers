// Author(s): Dylan Lott & Brandon Weathers
// Last updated: 12/29/2025 12:40 AM

import java.util.*;

class MultiTesterTool{
    public static void main(String[] args){
        System.out.println("Greetings user! Welcome to the multitesting tool.");
        System.out.println("Please enter below the passwords you would like to analyse, enter \"DONE\" when finished");

        ArrayList<String> userPasswords = new ArrayList<>();
        readInUserPasswords(userPasswords);
        // System.out.println("The user passwords are:");
        // userPasswords.forEach((currentPassword) -> System.out.print(currentPassword + ", "));

        printMainMenu();

        Scanner ob = new Scanner(System.in);
        String userInput = "";
        while(!(userInput.equals("q"))){
            System.out.print(">>> ");
            userInput = ob.nextLine();
            switch(userInput){
                case "1":
                    System.out.println("Function 1");
                    break;
                case "2":
                    System.out.println("Function 2");
                    break;
                case "3":
                    System.out.println("Function 3");
                    break;
                case "4":
                    System.out.println("Function 4");
                    break;
                default:
                    System.out.println("Please enter a valid answer");
            }
        }
    }

    static ArrayList<String> readInUserPasswords(ArrayList<String> userPasswords){
        Scanner ob = new Scanner(System.in);
        String currentPassword = "";
        while(!(currentPassword.equals("DONE"))){
            currentPassword = ob.nextLine();
            userPasswords.add(currentPassword);
        }
        userPasswords.remove(userPasswords.size()-1);
        return userPasswords;
    }

    static void printMainMenu(){
        System.out.println("Please choosing the following method to analyse the previous input:");
        System.out.println("1) EPSB");
        System.out.println("2) All common substrings (Summer method)");
        System.out.println("3) Longest common substring");
        System.out.println("4) Multiple longest common substring (with squashing)");
        System.out.println("Press \"q\" to quit");
    }
}
