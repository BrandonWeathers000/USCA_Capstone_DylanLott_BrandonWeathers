// Author(s): Brandon Weathers
// Last updated: 9/20/2025 1:49 AM

// CONCEPT
// Step 1: Prompt the user for a password.
// Step 2: Count how many of the following characters: capitals, lower case, numbers, symbols.
// Step 3: For each of these characters, add them to a coresponding linked list.
// Step 4: Update the min, max, mean, median, and mode.
// Step 4: Go to step 1.

// I have created a class that handles the technical parsing and calculation.
// I made this disccision so that I can use a single object in both a CLI and GUI versions.

// I have implemented the display of stats pertaining to all letters and
// the length of the new password as the paper instructs.

// This is just a test for adding a commit from a school owned Windows machine.

import java.util.*;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Map;

public class EPSB_CLI{
    public static void main (String[] args){
        Scanner ob = new Scanner(System.in);
        String currentPassword;

        EPSB EPSB1 = new EPSB();
        while(true){
            System.out.println("Please enter a password: ");
            currentPassword = ob.nextLine();

            EPSB1.addNewPassword(currentPassword);

            // System.out.println("There are " + countCapitalsInWord(currentPassword)    + " capital(s) in the password "           + currentPassword);
            // System.out.println("There are " + countLowerCaseInWord(currentPassword)   + " lower case letter(s) in the password " + currentPassword);
            // System.out.println("There are " + countDigits(currentPassword)            + " digit(s) in the password "             + currentPassword);
            // System.out.println("There are " + countSpecialCharacters(currentPassword) + " special character(s) in the password " + currentPassword);

            System.out.println("The current passwords are: " +                         EPSB1.passwords .toString());
            System.out.println("The coresponding number of capitals are: " +           EPSB1.capitals  .toString());
            System.out.println("The coresponding number of lower case letters are: " + EPSB1.lowerCase .toString());
            System.out.println("The coresponding number of numbers are: " +            EPSB1.numbers   .toString());
            System.out.println("The coresponding number of symbols are: " +            EPSB1.symbols   .toString());

            System.out.println("The current minimum number of capitals are: " + EPSB1.getMin(     EPSB1.capitals));
            System.out.println("The current max number of capitals are: " +     EPSB1.getMax(     EPSB1.capitals));
            System.out.println("The current average number of capitals are: " + EPSB1.getAverage( EPSB1.capitals));
            System.out.println("The current median number of capitals are: " +  EPSB1.getMedian(  EPSB1.capitals));
            System.out.println("The current mode number of capitals are: " +    EPSB1.getMode(    EPSB1.capitals));

            System.out.println("The current minimum number of lower case letters are: " + EPSB1.getMin(     EPSB1.lowerCase));
            System.out.println("The current max number of lower case letters are: " +     EPSB1.getMax(     EPSB1.lowerCase));
            System.out.println("The current average number of lower case letters are: " + EPSB1.getAverage( EPSB1.lowerCase));
            System.out.println("The current median number of lower case letters are: " +  EPSB1.getMedian(  EPSB1.lowerCase));
            System.out.println("The current mode number of lower case letters are: " +    EPSB1.getMode(    EPSB1.lowerCase));

            System.out.println("The current minimum number of letters are: " + EPSB1.getMin(     EPSB1.letters));
            System.out.println("The current max number of letters are: " +     EPSB1.getMax(     EPSB1.letters));
            System.out.println("The current average number of letters are: " + EPSB1.getAverage( EPSB1.letters));
            System.out.println("The current median number of letters are: " +  EPSB1.getMedian(  EPSB1.letters));
            System.out.println("The current mode number of letters are: " +    EPSB1.getMode(    EPSB1.letters));

            System.out.println("The current minimum number of numbers are: " + EPSB1.getMin(     EPSB1.numbers));
            System.out.println("The current max number of numbers are: " +     EPSB1.getMax(     EPSB1.numbers));
            System.out.println("The current average number of numbers are: " + EPSB1.getAverage( EPSB1.numbers));
            System.out.println("The current median number of numbers are: " +  EPSB1.getMedian(  EPSB1.numbers));
            System.out.println("The current mode number of numbers are: " +    EPSB1.getMode(    EPSB1.numbers));

            System.out.println("The current minimum number of symbols are: " + EPSB1.getMin(     EPSB1.symbols));
            System.out.println("The current max number of symbols are: " +     EPSB1.getMax(     EPSB1.symbols));
            System.out.println("The current average number of symbols are: " + EPSB1.getAverage( EPSB1.symbols));
            System.out.println("The current median number of symbols are: " +  EPSB1.getMedian(  EPSB1.symbols));
            System.out.println("The current mode number of symbols are: " +    EPSB1.getMode(    EPSB1.symbols));

            System.out.println("The current minimum length is: " + EPSB1.getMin(     EPSB1.length));
            System.out.println("The current max length is: " +     EPSB1.getMax(     EPSB1.length));
            System.out.println("The current average length is: " + EPSB1.getAverage( EPSB1.length));
            System.out.println("The current median length is: " +  EPSB1.getMedian(  EPSB1.length));
            System.out.println("The current mode length is: " +    EPSB1.getMode(    EPSB1.length));
        }
    }
}
