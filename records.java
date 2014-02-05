/*
ID: omarbic1
LANG: java1
prog: records
*/
import java.util.*;
import java.io.*;

public class records {
	public static void main(String[] args) throws IOException {
		//long startTime = System.currentTimeMillis();
		BufferedReader in = new BufferedReader(new FileReader("records.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("records.out")));
		int lines = Integer.parseInt(in.readLine());	
		String[][] cows = new String[lines][3];
		for (int ind = 0; ind < lines; ind++) {
			String thisLine = in.readLine();
			int ourSpace = thisLine.indexOf(" ");
			int ourSpace2 = thisLine.indexOf(" ", ourSpace + 1);
			cows[ind][0] = thisLine.substring(0,ourSpace);
			cows[ind][1] = thisLine.substring(ourSpace + 1,ourSpace2);
			cows[ind][2] = thisLine.substring(ourSpace2 + 1);
			Arrays.sort(cows[ind]);
		}
		int[] occ = new int[lines];
		for (int i = 0; i < lines; i++)
			for (int k = 0; k < lines; k++)
				if (myEquals(cows[i],cows[k]))
					occ[i] = occ[i]  + 1;
		Arrays.sort(occ);
		out.println(occ[lines - 1]);

		in.close();
		out.close();
		//long endTime = System.currentTimeMillis();
		//System.out.println((endTime - startTime) / 1000.0);
		System.exit(0);
	}
	public static boolean myEquals(String[] one, String[] two) {
		if (one.length != two.length)
			return false;
		for (int i = 0; i < one.length; i++)
			if (!(one[i].equals(two[i])))
				return false;
		return true;
	}
}