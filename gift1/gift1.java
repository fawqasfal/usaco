/*
ID: omarbic1
LANG: JAVA
PROG: gift1
*/
import java.io.*;
import java.util.*;
 
class gift1 {
  public static void main (String [] args) throws IOException {
    BufferedReader in = new BufferedReader(new FileReader("gift1.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gift1.out")));
    //input section
    int people = Integer.parseInt(in.readLine());
    String[] men = new String[people];
    int[] money = new int[people];
    int[] initmoney  = new int[people];
    for (int i = 0; i < people; i++) {
      men[i] = in.readLine();
    }
    String restInput = null;
    int state = 0;
    String currentDude = "";
    int moneyToAdd = 0;
    int numDudes = 0 ;
    while ((restInput = in.readLine()) != null) {
      if (state == 0) {
        if (currentDude.equals("")) {
          currentDude = men[gift1.find(men,restInput)];
          state++;
          continue;
        }
        state++;
      }
      if (state == 1) {
        int skipThis = restInput.indexOf(" ");
        int dudesIndex = gift1.find(men,currentDude);
        int giftMoney = Integer.parseInt(restInput.substring(0,skipThis));
        initmoney[dudesIndex] = giftMoney;
        int eachMoney = Integer.parseInt(restInput.substring(skipThis + 1));
        if (eachMoney != 0) {
          money[dudesIndex] += giftMoney % eachMoney;
        }
        else {
          money[dudesIndex] += giftMoney;
        }
        if (eachMoney != 0) {
          moneyToAdd = giftMoney / eachMoney;
          }
        else {
          moneyToAdd = 0;
        }
        numDudes = eachMoney;
        state++;
        continue;
      }
      if (state >= 2 && state < numDudes + 2) {
        money[find(men,restInput)] += moneyToAdd;
        state++;
        continue;
      }
      if (state == numDudes + 2) {
        currentDude = men[gift1.find(men,restInput)];
        state = 0;
        continue;  
      }
    }
    for(int i = 0; i < men.length; i++) {
      out.println(men[i] + " " + (money[i] - initmoney[i]));
    }
    out.close();                                  
    System.exit(0);                               
  }
  public static int find(String[] people, String name) {
    for (int i = 0; i < people.length; i++) {
      if (people[i].equals(name)) {
        return i;
      }
    }
    return -1;
  }
}