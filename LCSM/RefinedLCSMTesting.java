import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.io.*;

/**
 * @version 1.0
 * @author Dylan Lott
 * @author Brandon Weathers
 * <hr>
 * This class provies methods a single substring amoung an non-zero number of input strings.
 */

public class RefinedLCSMTesting{
    /**
     * This is the entry point.
     * It is usually used for testing.
     *
     * @param args command-line arguments not used
     */
    public static void main(String[] args){
        long startTime = System.nanoTime();
        for(int index = 0; index < 100; index++){
            ArrayList<String> input = new ArrayList<>();
            input.add("ancplucaskai99ancplucaskai99");
            input.add("ancplucaskai99ancplucaskai997");

            // This algorithm is excels with few inputs, but struges with many inputs. Uncomment to see!
            // input.add("ancplucaskai99ancplucaskai997");
            // input.add("ancplucaskai99ancplucaskai997");
            // input.add("ancplucaskai99ancplucaskai997");
            // input.add("ancplucaskai99ancplucaskai997");
            // input.add("ancplucaskai99ancplucaskai997");
            // input.add("ancplucaskai99ancplucaskai997");
            // input.add("ancplucaskai99ancplucaskai997");
            // input.add("ancplucaskai99ancplucaskai997");
            // input.add("ancplucaskai99ancplucaskai997");
            // input.add("ancplucaskai99ancplucaskai997");

            ArrayList<String> results = new ArrayList<>();
            results = RefinedLCSM.returnAllSubstringMultiInput(input);
        }

        long endTime = System.nanoTime();
        System.out.println("The refined LCMS algorithm takes " + (endTime-startTime)/1000000 + " miliseconds for 2 entries 100 times.");
    }
}
