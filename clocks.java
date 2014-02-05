
/*
ID: omarbic1
LANG: JAVA
PROG: clocks
*/
import java.util.*;
import java.io.*;

class clocks {
	static int[] clocks = new int[9];
	static int[][] changeClocks = {{3,3,3,3,3,2,3,2,0},{2,3,2,3,2,3,1,0,1},{3,3,3,2,3,3,0,2,3},{2,3,1,3,2,0,2,3,1},{2,3,2,3,1,3,2,3,2},{1,3,2,0,2,3,1,3,2},
	{3,2,0,3,3,2,3,3,3},{1,0,1,3,2,3,2,3,2},{0,2,3,2,3,3,3,3,3}};
	static int[] answer = new int[9];	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("clocks.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clocks.out")));
		String firstRow = in.readLine();
		String secondRow = in.readLine();
		String thirdRow = in.readLine();
		String[] rows = {firstRow, secondRow, thirdRow};
		for (int i = 0; i < rows.length; i++) {
			clocks[3*i + 0] = Integer.parseInt(rows[i].substring(0,rows[i].indexOf(" "))); 
			clocks[3*i + 1] = Integer.parseInt(rows[i].substring(rows[i].indexOf(" ") + 1,rows[i].indexOf(" ", rows[i].indexOf(" ") + 1))); 
			clocks[3*i + 2] = Integer.parseInt(rows[i].substring(rows[i].indexOf(" ",rows[i].indexOf(" ") + 1) + 1,rows[i].length())); 
		}
		setAnswer();
		String ans = answerToString();
		out.println(ans);
		in.close();
		out.close();
		System.exit(0);	
	}
	public static String answerToString() {
		String ans = new String();
		for (int i = 0; i < answer.length; i++)
			if (answer[i] != 0)
				for (int z = 0; z < answer[i]; z++)
					ans += (i + 1) + " ";
		return ans.substring(0,ans.length() - 1);
	}
	public static void setAnswer() {
		for (int clock = 0; clock < 9; clock++) {
			int weNeed = (12 - clocks[clock]) / 3;
			int[] thisClock = changeClocks[clock];
			for (int i = 0; i < thisClock.length; i++)
				answer[i] += weNeed * thisClock[i];
		}
		for (int z = 0; z < 9; z++)
			answer[z] = answer[z] % 4;
	}

}