/*
ID: omarbic1
LANG: JAVA
PROG: barn1
*/
import java.util.*;
import java.io.*;

class barn1 {
	static int[] prepped;
	static int[] stalls;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		//input`
		String line = in.readLine();
		int[] nums = new int[3];
		nums[0] = Integer.parseInt(line.substring(0,line.indexOf(" "))); //max boards
		nums[1] = Integer.parseInt(line.substring(line.indexOf(" ") + 1,line.indexOf(" ", line.indexOf(" ") + 1))); //stall num
		nums[2] = Integer.parseInt(line.substring(line.indexOf(" ",line.indexOf(" ") + 1) + 1,line.length())); //cows in stalls
		stalls = new int[nums[2]];
		for (int occ = 0; occ < nums[2];occ++)  
			stalls[occ] = Integer.parseInt(in.readLine());
		Arrays.sort(stalls); //the example case was sorted and it's implied from the problem that they were and in some cases they weren't? 
		//gimmicks and tricks 
		//greedy
		prepped = new int[nums[0] - 1];
		prepList();
		int[] indices = new int[nums[0] + 1];
		indices[indices.length - 1] = stalls.length - 1;
		for (int boards = 0; boards < nums[0] - 1; boards++) {
			indices[boards] = indexGap(stalls,boards);
		}
		System.out.println(Arrays.toString(indices)); 

		Arrays.sort(indices);
		int answer = stalls[indices[1]] - stalls[indices[0]] + 1; 
		for (int i = 1; i < indices.length - 1; i++) 
			answer += stalls[indices[i + 1]] - stalls[indices[i] + 1] + 1;
		if (answer < stalls.length)
			answer = stalls.length;
		out.println(answer);
		out.close();	
	}
	//get the index of the number before nth biggest gap between nums in a list recursively; where the biggest is the number 0 biggest gap
	public static int indexGap(int[] list, int n) {
		if (n == 0) {
			int maxGap = 0;
			for (int i = 1; i < list.length; i++)
				if (list[i] - list[i - 1] > list[maxGap + 1] - list[maxGap])
					maxGap = i - 1;
			return maxGap;
		}
		int[] thisPrepped = new int[n];
		int notBigger = prepped[n - 1];
		for (int z = 0; z < n; z++)
			thisPrepped[z] = prepped[z];
		int maxGap = 0;
		for (int i = 1; i < list.length; i++)
			if (list[i] - list[i - 1] > list[maxGap + 1] - list[maxGap] && list[i] - list[i - 1] <= list[notBigger + 1] - list[notBigger] && i - 1 != notBigger && !isIn(thisPrepped,i - 1))
				maxGap = i - 1;
		return maxGap;
	}
	public static boolean isIn(int[] list, int n) {
		for (int i = 0; i < list.length; i++)
			if (list[i] == n)
				return true;
		return false;
	}
	public static void prepList() {
		for (int i = 0; i < prepped.length; i++)
			prepped[i] = indexGap(stalls,i);
	}
}