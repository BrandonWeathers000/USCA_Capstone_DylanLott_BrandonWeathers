// Author(s): Dylan Lott & Brandon Weathers
// Last updated: 12/2/2025 12:57 PM

// Just for testing

import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.util.HashMap;
import java.util.Map;

public class Little_EPSB_CLI_Testing{
    public static void main (String[] args){
        Scanner ob = new Scanner(System.in);
        String currentPassword1 = "Password_A#Password_B$";
        EPSB EPSB1 = new EPSB();

        long startTime = System.nanoTime();
        for(int index = 0; index < 100; index++){
                EPSB1.addNewPassword(currentPassword1);
                EPSB1.getInfoTesting();
        }
        long endTime = System.nanoTime();
        EPSB1.getInfoTesting();
        System.out.println("The EPSB algorithm takes " + (endTime-startTime)/1000000 + " miliseconds for 100 entries.");
    }
}
