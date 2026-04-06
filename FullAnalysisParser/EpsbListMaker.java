import java.util.*;
import java.io.*;

class EpsbListMaker {
    public static ArrayList<EPSB> getAnEpsbList(ArrayList<ArrayList<String>> stringMatrix) {
        // System.out.println("Entered into function.");
        ArrayList<EPSB> epsbList = new ArrayList<>();

        for(int i = 0; i < stringMatrix.size(); i++) {
            // System.out.println("Outer loop iteration: " + i);
            EPSB currentEPSB = new EPSB();
            epsbList.add(currentEPSB);

            for(int j = 0; j < stringMatrix.get(i).size(); j++) {
                // System.out.println("Inner loop iteration: " + j);
                epsbList.get(i).addNewPassword(stringMatrix.get(i).get(j));
            }
        }

        return epsbList;
    }
}
