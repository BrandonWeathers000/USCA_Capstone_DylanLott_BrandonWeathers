import java.util.*;
import java.io.*;

class JacListMaker {
    public static ArrayList<Double> getJacList(ArrayList<ArrayList<String>> stringMatrix) {
        ArrayList<Double> jacList = new ArrayList<>();
        for(ArrayList<String> currentEntry : stringMatrix) {
            jacList.add(Jaccard.multiJac(currentEntry));
        }
        return jacList;
    }
}
