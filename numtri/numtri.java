/*
ID: omarbic1
LANG: JAVA
PROG: numtri
*/
import java.util.*;
import java.io.*;
class numtri {
	static ArrayList<ArrayList<Integer>> numtree;
	static int sums;
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new FileReader("numtri.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		numtree = new ArrayList<ArrayList<Integer>>();
		int loopNum = in.nextInt();
		for(int i = 1; i <= loopNum; i++) {
			numtree.add(new ArrayList<Integer>());
			for (int k = 1; k <= i; k++)
				numtree.get(numtree.size() - 1).add(in.nextInt());
		}
		findSumsGreedy();
		out.println(sums);
		out.close();
		System.exit(0);
	}
	public static void findSums(int node, int direction, int level, int sumSoFar) {
		//0 for left, 1 for right
		if (level == numtree.size() - 1) {
			if (sumSoFar > sums)
				sums = sumSoFar;
			return;
		}
		ArrayList<Integer> thisList = numtree.get(level);
		ArrayList<Integer> nextList = numtree.get(level + 1);
		int left = nextList.get(direction);
		int right = nextList.get(direction + 1);
		findSums(left, direction, level + 1, sumSoFar + left);
		findSums(right, direction + 1, level + 1, sumSoFar + right);
	}
	public static void findSums() {
		findSums(numtree.get(0).get(0), 0, 0, numtree.get(0).get(0));
	}
	public static void findSumsGreedy() {
		for (int a = numtree.size() - 1; a > 0; a--)
			for (int b = 0; b < a; b++)
				numtree.get(a - 1).set(b,numtree.get(a - 1).get(b) + Math.max(numtree.get(a).get(b), numtree.get(a).get(b + 1)));
		sums = numtree.get(0).get(0);
	}
}