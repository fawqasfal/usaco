/*
ID: thisisomar
LANG: JAVA
PROG: decorate
*/
import java.util.*;
import java.io.*;

public class decorate {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(new FileReader("decorate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("decorate.out")));
		int maxj = 0;
		int pastures = Integer.parseInt(in.next());
		int connects = Integer.parseInt(in.next());
		boolean[][] connections = new boolean[pastures][pastures];
		for (int i = 0; i < connects; i++) {
			int past1 = Integer.parseInt(in.next()) - 1 ;
			int past2 = Integer.parseInt(in.next()) - 1;
			connections[past1][past2] = true;
			connections[past2][past1] = true;
		}
		for (int i = 0; i < connections.length; i++)
			System.out.println(Arrays.toString(connections[i]));
		System.out.println(isConnected(0,2,connections));
		ArrayList<Integer> pasturesarr = new ArrayList<Integer>();
		ArrayList<Integer> illegal = new ArrayList<Integer>();
		for (int i = 0; i < pastures; i++)
			pasturesarr.add(i);
		ArrayList<ArrayList<Integer>> components = new ArrayList<ArrayList<Integer>>();
		
		while (pasturesarr.size() != 0) {
			ArrayList<Integer> newcomp = new ArrayList<Integer>();
			int one = pasturesarr.get(0);
			newcomp.add(pasturesarr.get(0));
			pasturesarr.remove(0);
			for (int i : pasturesarr) {
				if (isConnected(one, i, connections)) {
					newcomp.add(i);
					illegal.add(i);
			}
			}
			for (int i : illegal) {
				if (pasturesarr.contains(i))
					pasturesarr.remove(pasturesarr.indexOf(i));
			}
			components.add(newcomp);
		}
		System.out.println(components);
		//dont understand why i just wrote this component code right now. the input details tell me it could only be one input. but i did.
		for (ArrayList<Integer> component : components) {
			if (component.size() == 2)
				continue;
			//you said it'd be a square so...
			maxj += component.size() / 2;
		}
		out.println(maxj);
		in.close();
		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0);
		System.exit(0);
	
	}
	public static boolean isConnected(int one, int two, boolean[][] graph, ArrayList<Integer> donttry) {
		if (!donttry.contains(one)) {
			donttry.add(one);
			for (int i = 0; i < graph[one].length; i++) {
				if (graph[one][i]){
					if (i == two)
						return true;
					if (!donttry.contains(i))
						return isConnected(i, two, graph, donttry);
				}
			}
			return false;
		}
		return false;
	}
	public static boolean isConnected(int one, int two, boolean[][] graph) {
		return isConnected(one,two,graph, new ArrayList<Integer>());
	}
}