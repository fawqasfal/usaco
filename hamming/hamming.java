/*
ID: omarbic1
LANG: JAVA
PROG: hamming
*/
import java.util.*;
import java.io.*;

public class hamming {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(new FileReader("hamming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		int codeWords = in.nextInt();
		int bitLength = in.nextInt();
		int reqDist = in.nextInt();
		ArrayList<Integer> answers = new ArrayList<Integer>();
		in.close();
		for (int i = 0; i < Math.pow(2, bitLength); i++) {
			boolean itWorks = true;
			if (i == 0) {
				answers.add(i);
			}
			else {
				for (int k = 0; k < answers.size(); k++)
					if (!isHam(i,answers.get(k),reqDist)) {
						itWorks = false;
						break;
					}
				if (!itWorks)
					continue;
				if (answers.size() >= codeWords)
					break;
				answers.add(i);
			}
		}
		for (int k = 0; k < answers.size(); k++) {
			if ((k+ 1) % 10 == 0)
				out.print(answers.get(k) + "\n");
			else {
				out.print(answers.get(k));
			if (k == answers.size() - 1)
				out.print("\n");
			else
				out.print(" ");
			}
		}
		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0);
		System.exit(0);
	}
	public static boolean isHam(int a, int b, int reqDist) {
		String boolRepA = Integer.toBinaryString(a);
		String boolRepB = Integer.toBinaryString(b);
		int numDiff = 0;
		if (boolRepA.length() > boolRepB.length())
			boolRepB = "00000000".substring(0,boolRepA.length() - boolRepB.length()) + boolRepB;
		else if (boolRepB.length() > boolRepA.length())
			boolRepA = "00000000".substring(0,boolRepB.length() - boolRepA.length()) + boolRepA;
		for (int i = 0; i < boolRepA.length(); i++) {
			if (boolRepA.charAt(i) != boolRepB.charAt(i))
				numDiff++;
			if (numDiff >= reqDist)
				return true;
		}
		return false;
	}
}