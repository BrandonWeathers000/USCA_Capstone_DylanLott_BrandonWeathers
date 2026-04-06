import java.util.*;
import java.io.*;

class JacListMaker {
    public static ArrayList<Double> getJacList(ArrayList<ArrayList<String>> stringMatrix) {
        ArrayList<Double> jacList = new ArrayList<>();

        Jaccard currentJac = new Jaccard();
        jacList.add(currentJac.multiJac(stringMatrix.get(0)));

        return jacList;
    }
}
