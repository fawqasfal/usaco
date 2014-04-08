/*
ID: omarbic1
LANG: JAVA
PROG: milk3
*/
import java.util.*;
import java.io.*;

public class milk3 {
	static boolean[][][] branchfinished;
	static int aMax, bMax, cMax;
	static ArrayList<Integer> answers;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		String line= in.readLine();
		aMax = Integer.parseInt(line.substring(0, line.indexOf(" ")));
		bMax = Integer.parseInt(line.substring(line.indexOf(" ") + 1, line.indexOf(" ", line.indexOf(" ")  + 1)));
		cMax = Integer.parseInt(line.substring(line.indexOf(" ",line.indexOf(" ") + 1) + 1));
		branchfinished = new boolean[aMax + 1][bMax + 1][cMax + 1];
		answers = new ArrayList<Integer>();
		treeSearch(0,0,cMax);
		Collections.sort(answers); 
		for (int i = 0; i < answers.size(); i++) {
			out.print(answers.get(i));
			if (i != answers.size() - 1)
				out.print(" ");
			else
				out.print("\n");
		}
		out.close();
		System.exit(0);
	}
	public static void treeSearch(int a, int b, int c) {
		if (!branchfinished[a][b][c])
			branchfinished[a][b][c] = true;
		else 
			return;
		if (a == 0)
			answers.add(c);
		//every decision constitutes of 6 branches, each representing a potential pour; recursive DFS through the entire tree 
		//if theres a speed problem ill come back and forbid empty pours 
		treeSearch(a+Math.min(c,aMax-a),b,c-Math.min(c,aMax-a));
		treeSearch(a-Math.min(cMax-c,a),b,c+Math.min(cMax-c,a));
		treeSearch(a+Math.min(b,aMax-a),b-Math.min(b,aMax-a),c);
		treeSearch(a-Math.min(bMax-b,a),b+Math.min(bMax-b,a),c);
		treeSearch(a,b+Math.min(c,bMax-b),c-Math.min(c,bMax-b));
		treeSearch(a,b-Math.min(cMax-c,b),c+Math.min(cMax-c,b));
	}

}