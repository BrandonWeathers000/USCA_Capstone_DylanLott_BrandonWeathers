import java.util.*;
import java.io.*;

class EpsbMatrixMaker {
    public static ArrayList<EPSB> getAnEpsbMatrix(ArrayList<ArrayList<String>> stringMatrix) {
        // System.out.println("Entered into function.");
        ArrayList<EPSB> epsbMatrix = new ArrayList<>();

        for(int i = 0; i < stringMatrix.size(); i++) {
            // System.out.println("Outer loop iteration: " + i);
            EPSB currentEPSB = new EPSB();
            epsbMatrix.add(currentEPSB);

            for(int j = 0; j < stringMatrix.get(i).size(); j++) {
                // System.out.println("Inner loop iteration: " + j);
                epsbMatrix.get(i).addNewPassword(stringMatrix.get(i).get(j));
            }
        }

        return epsbMatrix;
    }
}
