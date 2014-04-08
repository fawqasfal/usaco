/*
ID: omarbic1
LANG: JAVA
PROG: ride
*/
import java.io.*;
import java.util.*;

class ride {
  public static void main (String [] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("ride.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
    String comet = in.readLine();  
    String group = in.readLine();    
    
    int cometMod = 1;
    int groupMod = 1;

    for (int i = 0; i < comet.length(); i++) {
      int valueComet = (int) comet.charAt(i) - 64;
        cometMod = cometMod * valueComet;
    }
    for (int k = 0; k < group.length(); k++) {
      int valueGroup = (int) group.charAt(k) - 64;
      groupMod = groupMod * valueGroup;
    }

    cometMod = cometMod % 47;
    groupMod = groupMod % 47;

    if (cometMod == groupMod) {
      out.println("GO");
    }
    else {
      out.println("STAY");
    }

    out.close();                                  
    System.exit(0);                               
  }
}