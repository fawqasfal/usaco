/*
ID: omarbic1
LANG: JAVA
PROG: sort3
*/
import java.util.*;
import java.io.*;

public class sort3 {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(new FileReader("sort3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		int[] ourNums = int[in.nextInt()];
		for (int ind = 0; ind < ourNums.length; ind++)
			ourNums[ind] = in.nextInt();
		in.close();
		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0);
		System.exit(0);
	}
}