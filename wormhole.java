/*
ID: omarbic1
LANG: java1
prog: wormhole
*/
import java.util.*;
import java.io.*;

public class wormhole {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		
		BufferedReader in = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		int coNum = Integer.parseInt(in.readLine());
		ArrayList<ArrayList<Integer>> coords = new ArrayList<ArrayList<Integer>>();
		for (int coord = 0; coord < coNum; coord++) {
			String thisLine = in.readLine();
			coords.add(new ArrayList<Integer>());
			coords.get(coord).add(Integer.parseInt(String.valueOf(thisLine.charAt(0))));
			coords.get(coord).add(Integer.parseInt(String.valueOf(thisLine.charAt(2))));
		}
		Collections.sort(coords, new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> a1, ArrayList<Integer> a2) {
				return a1.get(1) - a2.get(1);
			}
		});
		int answer = 0;
		for (int i = coords.get(0).get(1); i <= coords.get(coords.size() -1).get(1); i++) {
			System.out.println(i);
			if (containsY(coords,i) > 1)
				answer+= containsY(coords,i) / 2;
		}
		out.println(answer);
		in.close();
		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0);
		System.exit(0);

}
	  