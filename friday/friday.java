/*
ID: omarbic1
LANG: JAVA
PROG: friday
*/
import java.io.*;
import java.util.*;
 
class friday {
  public static void main (String [] args) throws IOException {
    //setting up input and output
    BufferedReader in = new BufferedReader(new FileReader("friday.in"));
    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("friday.out")));
    //initial variables -- must be accessible in all scopes because modified in many areas
    int years = Integer.parseInt(in.readLine()); //number of years
    String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"}; 
    int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
    String[] daysOfWeek = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
    int[] spooky = {0,0,0,0,0,0,0}; //amount of 13s 
    //starting points 
    String month = "January"; 
    int day = 1; 
    String dayOfWeek = "Monday";
    int year = 1900;
    while (year <= (1900 + years - 1)) {
      //checking if it"s a leap year
      if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
        daysInMonth[1] = 29;
      }
      else {
        daysInMonth[1] = 28;
      }
      //new day (of month)!
      day++;
      //update year
      if ((day == 32) && month.equals("December")) {
        year++;
      }
      //update week
      dayOfWeek = daysOfWeek[(find(daysOfWeek,dayOfWeek) + 1) % 7]; //mod 7 to make sure Saturday wraps back to Sunday ((6 + 1) mod 7 = 0)
      //update month
      if (day > daysInMonth[find(months,month)]) {
        day = 1;
        month = months[(find(months,month) + 1) % 12]; //mod 13 to make sure December wraps back to January ((11 + 1) mod 12 = 0)
      }
      //update amt of 13s
      if (day == 13) {
        int index = find(daysOfWeek,dayOfWeek);
        spooky[index] = spooky[index] + 1;
      }
    }
    //done -- finally, printing
    for (int i = 0; i < spooky.length; i++) {
      out.print(spooky[i]);
      if (i != spooky.length - 1) 
        out.print(" ");
    }
    out.print("\n");
    out.close();                                  
    System.exit(0);                               
  }
  //finding variable in list
  public static int find(String[] list, String variable) {
    for (int i = 0; i < list.length; i++) {
      if (list[i].equals(variable)) {
        return i;
      }
    }
    return -1;
  }
}