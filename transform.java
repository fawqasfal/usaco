  /*
ID: omarbic1
LANG: JAVA
PROG: transform 
*/
import java.io.*;
import java.util.*;
 
class transform {
    public static void main(String[] args) throws IOException {
      //input and output
      BufferedReader in = new BufferedReader(new FileReader("transform.in"));
      PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
      int numLines = Integer.parseInt(in.readLine());
      int supNum = numLines - 1;
      char[][] box = new char[numLines][numLines];
      char[][] shifted = new char[numLines][numLines];
      char[][] reflection = new char[numLines][numLines];
      for (int i = 0; i < numLines; i++) {
          String line = in.readLine();
          for (int z = 0; z < numLines; z++) {
            box[i][z] = line.charAt(z);
          }
      }
      for (int j = 0; j < numLines; j++) {
        String line = in.readLine();
        for (int r = 0; r < numLines; r++) {
          shifted[j][r] = line.charAt(r);
          reflection[j][r] = box[j][supNum - r];
        }
      }
      int index = -1;
      int att = 0;
      int ans = 1;
      for (int h = 0; h < numLines; h++) {
        for (int w = 0; w < numLines; w++) {
          if (ans == 1 && !(box[h][w] == shifted[w][supNum - h])) {
            h = 0;
            w = 0;
            ans = 2;
          }
          if (ans == 2 && !(box[h][w] == shifted[supNum - h][supNum - w])) {
            h = 0;
            w = 0;
            ans = 3;
          }
          if (ans == 3 && !(box[h][w] == shifted[supNum - w][h])) {
            h = 0;
            w = 0;
            ans = 4;
          }
          if (ans == 4 && !(reflection[h][w] == shifted[h][w])) {
            h = 0;
            w = 0;
            ans = 5;
          } 
          if (ans == 5 && !(reflection[h][w] == shifted[w][supNum - h])) {
            h = 0;
            w = 0;
            ans = 6;
          }
          if (ans == 6 && !(reflection[h][w] == shifted[supNum - h][supNum - w])) {
            h = 0;
            w = 0;
            ans = 7;
          }
          if (ans == 7 && reflection[h][w] != shifted[supNum - w][h]) {
            h = 0;
            w = 0;
            ans = 8; 
          }    
          if (ans == 8 && (box[h][w] != shifted[h][w])) {
            ans = 9;
            break;
          }
        }
      }
      if (ans == 5 || ans == 6 || ans == 7) {
        ans = 5;
      }
      if (ans == 8) {
        ans = 6;
      }
      if (ans == 9) {
        ans = 7;
      }
      out.println(ans);
      in.close();
      out.close();
      System.exit(0);
    }
}