/*
ID: omarbic1
LANG: JAVA
PROG: holstein
*/
import java.util.*;
import java.io.*;

public class holstein {
	static ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(new FileReader("holstein.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		int[] cowNeeds = new int[in.nextInt()];
		int[] thisConfig = new int[cowNeeds.length];
		for (int k = 0; k < cowNeeds.length; k++)
			cowNeeds[k] = in.nextInt();
		int[][] feeds = new int[in.nextInt()][cowNeeds.length];
		for (int g = 0; g < feeds.length; g++)
			for (int q = 0; q < cowNeeds.length; q++)
				feeds[g][q] = in.nextInt();
		String feedsUsed = new String();
		for (int i = 0; i < Math.pow(2,feeds.length); i++) {
			int[] thisFeed = new int[cowNeeds.length];
			thisConfig = thisFeed;
			feedsUsed = Integer.toBinaryString(i);
			if (feedsUsed.length() < feeds.length)
				feedsUsed = "000000000000000".substring(0,feeds.length - feedsUsed.length()) + feedsUsed;
			for (int x = 0; x < feedsUsed.length(); x++) {
				if (feedsUsed.charAt(x) == '1') 
					thisFeed = feeds[x];
				else
					thisFeed = new int[cowNeeds.length];
				for (int z = 0; z < thisFeed.length; z++)
					thisConfig[z] += thisFeed[z];
			}
			boolean doPrint = true;
			for (int y = 0; y < cowNeeds.length; y++) {
				if (!(thisConfig[y] >= cowNeeds[y])) {
					doPrint = false;
					break;
				}
			}
			if (doPrint) {
				answer.add(binaryToPrint(feedsUsed));
			}
		}
		//System.out.println(answer);
		Collections.sort(answer, new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				return a.get(0) - b.get(0);
			}
		});
		ArrayList<ArrayList<Integer>> realAnswer = new ArrayList<ArrayList<Integer>>();
		for (ArrayList<Integer> x : answer)
			if (x.get(0) == answer.get(0).get(0))
				realAnswer.add(x);
			else
				break;
		answer = realAnswer;
		Collections.sort(answer, new Comparator<ArrayList<Integer>>() {
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				int aSum = 0;
				int bSum = 0;
				for (int ain = 1; ain < a.size(); ain++)
					aSum += a.get(ain);
				for (int bin = 1; bin < b.size(); bin++)
					bSum += b.get(bin);
				return aSum - bSum;
			}
		});
		System.out.println(realAnswer.get(0));
		for (int r = 0; r < answer.get(0).size(); r++) {
			out.print(answer.get(0).get(r));
			if (r != answer.get(0).size() - 1)
				out.print(" ");
			else
				out.print("\n");
		}
		in.close();
		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0);
		System.exit(0);
	}
	public static ArrayList<Integer> binaryToPrint(String binRep) {
		int h = 0;
		ArrayList<Integer> maybeAnswer = new ArrayList<Integer>();
		for (int x = 0; x < binRep.length(); x++)
			if (binRep.charAt(x) == '1') {
				h++;
				maybeAnswer.add(x + 1);
			}
		ArrayList<Integer> realAnswer = new ArrayList<Integer>();
		realAnswer.add(h);
		realAnswer.addAll(maybeAnswer);
		return realAnswer;
	}
}