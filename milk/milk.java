/*
ID: omarbic1
LANG: JAVA
PROG: milk
*/
import java.util.*;
import java.io.*;

class milk {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		//input
		String firstNums = in.readLine();
		int weNeed = Integer.parseInt(firstNums.substring(0,firstNums.indexOf(" ")));
		int farmers = Integer.parseInt(firstNums.substring(firstNums.indexOf(" ") + 1));
		int[][] priceamt = new int[farmers][2];
		int[] amt = new int[farmers];
		for (int farmNum = 0; farmNum < farmers; farmNum++) {
			firstNums = in.readLine();
			priceamt[farmNum][0] = Integer.parseInt(firstNums.substring(0,firstNums.indexOf(" ")));
			priceamt[farmNum][1] = Integer.parseInt(firstNums.substring(firstNums.indexOf(" ") + 1));
		}
		Arrays.sort(priceamt, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		int answer = 0;
		int galls = 0;
		int index = 0;
		while (galls < weNeed) {
			if (galls + priceamt[index][1] < weNeed) {
				galls += priceamt[index][1];
				answer += priceamt[index][1] * priceamt[index][0];
			}
			else {
				answer += priceamt[index][0] * (weNeed - galls);
				galls += weNeed - galls;
			}
			index++;
		}
		out.println(answer);
		out.close();	
		System.exit(0);
	}
}