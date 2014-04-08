/*
ID: omarbic1
LANG: JAVA
PROG: beads
*/
import java.io.*;
import java.util.*;
 
class beads {
  static String beads;
  public static void main (String [] args) throws IOException {
    //setting up input and output
    BufferedReader in = new BufferedReader(new FileReader("beads.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("beads.out")));
    //initial variables -- must be accessible in all scopes because modified in many areas
    //beads is a class variable for use in splitBeads without having to add a second parameter
    int length = Integer.parseInt(in.readLine());
    beads = in.readLine();
    int maxPull = 0;
    //get rid of same-color necklaces right away
    if (!checkAll()) {
      //main loop
      for (int split = 0; split < length; split++) {
        String front = splitBeads(split);
        int begin = check(front);
        int back = check(reverse(front));
        if (begin + back > maxPull)
          maxPull = begin + back;
      }
    }
    else {
      maxPull = length;
    }
    if (maxPull > length)
      maxPull = length;
    //final write
    out.println(maxPull);
    //cleanup
    in.close();
    out.close();                                  
    System.exit(0);                               
  }

  public static int check(String str) {
    int wStart = 0;
    while (str.charAt(wStart) == 'w') 
      wStart++;
    int amtBeads = wStart;
    char firstChar = str.charAt(wStart);
    int i = wStart;
    char thisChar;
    while ((thisChar = str.charAt(i)) == firstChar || (thisChar = str.charAt(i)) == 'w') { 
      amtBeads++;
      i++; 
    }
    return amtBeads;
  }
  public static String splitBeads(int splitPoint) {
    if (splitPoint == beads.length() - 1)
      return beads;
    String answer = beads.substring(splitPoint + 1) + beads.substring(0,splitPoint + 1);
    return answer;
  }
  public static String reverse(String str) {
    String reverseString = "";
    for (int i = str.length() - 1; i >= 0; i--) {
      reverseString += Character.toString(str.charAt(i));
    }
    return reverseString;
  }
  public static boolean checkAll() {
    int wStart = 0;
    while (beads.charAt(wStart) == 'w') { 
      wStart++;
      if (wStart == beads.length() - 1)
        return true;
    }
    int i = wStart;
    char firstChar = beads.charAt(wStart);
    char thisChar;
    while ((thisChar = beads.charAt(i)) == firstChar || (thisChar = beads.charAt(i)) == 'w') {
      if (i == beads.length() - 1)
        return true;     
      i++;
    }
    return false;
  }
}