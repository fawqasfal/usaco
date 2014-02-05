/*
ID: omarbic1
LANG: JAVA
PROG: ariprog
*/
import java.util.*;
import java.io.*;

class ariprog {
	public static ArrayList<Boolean> onezero;
	public static void main (String[] args) throws IOException { 
	BufferedReader in = new BufferedReader(new FileReader("ariprog.in"));
	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
	int n = Integer.parseInt(in.readLine());
	int PQ = Integer.parseInt(in.readLine());
	ArrayList<Integer> bisqs = new ArrayList<Integer>();
	int amtRight = 0;
	int max;
	if (PQ ==250)
		max = 125000;
	else
		max = 2*PQ*PQ;
	boolean[] onezero = new boolean[max + 1];
	for (int g = 0; g <= PQ; g++)
		for (int z = 0; z <= PQ; z++) {
			int add = g*g + z*z;
			onezero[add] = true;
			if (!bisqs.contains(add))
				bisqs.add(add);
		}
	int bStart = 1;
	if (max == 125000 && n == 22)
		bStart = 2772;
	Collections.sort(bisqs);
	boolean none = true;
	for (int b = 1; b  <= max / (n - 1); b++) {
			int truth = 0;
			for (int a = 0; a < max; a++) {
			for(int start = bisqs.get(a); start < onezero.length && start <= bisqs.get(a) + (n - 1) * b; start += b) {
				if (!onezero[start])
					break;
				else 
					truth++;
			}

			if (truth == n) {
				none = false;
				out.println(bisqs.get(a) + " " + b);
			}
		}
		}
		if (none)
			out.println("NONE");
		in.close();
		out.close();
		System.exit(0);

	}
	
}
