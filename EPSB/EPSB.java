import java.util.*;
import java.util.regex.*;
import java.util.Map;

/**
 * @version 1.0
 * @author Dylan Lott
 * @author Brandon Weathers
 * <hr>
 * I have created a class that handles the technical parsing and calculation.
 * I made this disccision so that I can use a single object in both a CLI and GUI versions.
 * I have changed this class so that it also keeps tracks of all letters and the
 * length of the new passwords as per the paper instructs.S
 * I have squeezed out some more preformance by saving time by not recalculating digit count or min or max values.
 *
 * NOTE: Make EPSB a single pass.
 */

public class EPSB{
    public ArrayList<Integer> capitals, lowerCase, letters, numbers, symbols, length;

    /**
     * This class is ment of store basic numerical info in the form of various String array lists.
     */
    public EPSB(){
        capitals  = new ArrayList<Integer>();
        lowerCase = new ArrayList<Integer>();
        letters   = new ArrayList<Integer>();
        numbers   = new ArrayList<Integer>();
        symbols   = new ArrayList<Integer>();
        length    = new ArrayList<Integer>();
    }

    /**
     * This method is used to tally the total number of various feature of the given new password
     * @param newPassword a new password to be added and analysed
     */
    public void addNewPassword(String newPassword){
        int capitalsInWord = 0, lowerCaseInWord = 0, digitsInWord = 0;

        for(int index = 0; index < newPassword.length(); index++){
            switch(newPassword.charAt(index)){
                case 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z':
                    capitalsInWord++;
                    break;
                case 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z':
                    lowerCaseInWord++;
                    break;
                case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9':
                    digitsInWord++;
                    break;
            }
        }

        capitals.add((Integer) capitalsInWord);
        lowerCase.add((Integer) lowerCaseInWord);
        letters.add((Integer) capitalsInWord + lowerCaseInWord);
        numbers.add((Integer) digitsInWord);
        symbols.add((Integer) newPassword.length() - (capitalsInWord + lowerCaseInWord + digitsInWord));
        length.add((Integer) newPassword.length());

        capitals.sort(null);
        lowerCase.sort(null);
        letters.sort(null);
        numbers.sort(null);
        symbols.sort(null);
        length.sort(null);
    }

    /**
     * This method calculates the average (arthmatic mean) with an input of ArrayList Integer
     * @param list this is the list of Integer objects in an ArrayList
     * @return average/list.size() the average of the list of Integers
     */
    public double getAverage(ArrayList<Integer> list){
        double average = 0;
        for(Integer currentElement : list)
            average += currentElement.intValue();
        return average/list.size();
    }

    /**
     * This method calculates the median with an input of ArrayList Integer
     * @param list this is the list of Integer objects in an ArrayList
     * @return list.get(list.size()/2) the average of the list of Integers
     */
    public int getMedian(ArrayList<Integer> list){
       return list.get(list.size()/2);
    }

    /**
     * This method calculates the mode with an input of ArrayList Integer
     * It does so by using the Map library
     * @param list this is the list of Integer objects in an ArrayList
     * @return mode the most common element of the list of Integers
     */
    public int getMode(ArrayList<Integer> list){
        HashMap<Integer, Integer> freqMap = new HashMap<Integer, Integer>();

        for(Integer index : list)
            freqMap.put(index, freqMap.getOrDefault(index, 0) + 1);

        int maxCount = 0, mode = -1;
        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()){
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
                mode = entry.getKey();
            }
        }
        return mode;
    }

    /**
     * Return basic info by printing out the min, max, mean, median, and mode or capitals, lower
     * case, letters, numbers, symbols, and length for all passwords associated with a user.
     */
    public void getInfo(){
        System.out.printf("\n");
        System.out.printf("[CAPITALS]                             [LOWER CASE]\n");
        System.out.printf("Minimum number of capitals are: %d    | Minimum number of lower case letters are: %d\n", capitals.get(0), lowerCase.get(0));
        System.out.printf("Maximum number of capitals are: %d    | Maximum number of lower case letters are: %d\n", capitals.get(capitals.size()-1), lowerCase.get(lowerCase.size()-1));
        System.out.printf("verage number of capitals are:  %.2f | Average number of lower case letters are: %.2f\n", getAverage(capitals), getAverage(lowerCase));
        System.out.printf("Median number of capitals are:  %d    | Median number of lower case letters are:  %d\n", getMedian(capitals) ,getMedian(lowerCase));
        System.out.printf("Mode number of capitals are:    %d    | Mode number of lower case letters are:    %d\n\n", getMode(capitals), getMode(letters));

        System.out.printf("[LETTERS]                              [NUMBERS]\n");
        System.out.printf("Minimum number of letters are: %d     | Minimum number of numbers are: %d\n", letters.get(0), numbers.get(0));
        System.out.printf("Maximum number of letters are: %d     | Maximum number of numbers are: %d\n", letters.get(letters.size()-1), numbers.get(numbers.size()-1));
        System.out.printf("Average number of letters are: %.2f  | Average number of numbers are: %.2f\n", getAverage(letters), getAverage(numbers));
        System.out.printf("Median number of letters are:  %d     | Median number of numbers are:  %d\n", getMedian(letters), getMedian(numbers));
        System.out.printf("Mode number of letters are:    %d     | Mode number of numbers are:    %d\n\n", getMode(letters), getMode(numbers));

        System.out.printf("[SYMBOLS]                              [LENGTH]\n");
        System.out.printf("Minimum number of symbols are: %d     | Minimum length is: %d\n", symbols.get(0), length.get(0));
        System.out.printf("Maximum number of symbols are: %d     | Maximum length is: %d\n", symbols.get(symbols.size()-1), length.get(length.size()-1));
        System.out.printf("Average number of symbols are: %.2f  | Average length is: %.2f\n", getAverage(symbols), getAverage(length));
        System.out.printf("Median number of symbols are:  %d     | Median length is:  %d\n", getMedian(symbols), getMedian(length));
        System.out.printf("Mode number of symbols are:    %d     | Mode length is:    %d\n\n", getMode(symbols), getMode(length));
    }

    /**
     * This method is just like above, but it doesn't print anything out.
     * It is just for testing the time the EPSB takes.
     * It is ment to be ran many times, where terminal output becomes an obsticle.
     *
     * @param wantToTest please set to ture
     */
    public void getInfo(boolean wantToTest){
        if(wantToTest == false){
            System.out.println("Plesae pass \"true\" to activate testing purposes.");
            return;
        }

        capitals.get(0);
        lowerCase.get(0);
        capitals.get(capitals.size()-1);
        lowerCase.get(lowerCase.size()-1);
        getAverage(capitals);
        getAverage(lowerCase);
        getMedian(capitals) ;
        getMedian(lowerCase);
        getMode(capitals);
        getMode(letters);
        letters.get(0);
        numbers.get(0);
        letters.get(letters.size()-1);
        numbers.get(numbers.size()-1);
        getAverage(letters);
        getAverage(numbers);
        getMedian(letters);
        getMedian(numbers);
        getMode(letters);
        getMode(numbers);
        symbols.get(0);
        length.get(0);
        symbols.get(symbols.size()-1);
        length.get(length.size()-1);
        getAverage(symbols);
        getAverage(length);
        getMedian(symbols);
        getMedian(length);
        getMode(symbols);
        getMode(length);
    }
}
