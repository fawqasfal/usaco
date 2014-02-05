/*
ID: omarbic1
LANG: java1
prog: baseball
*/
import java.util.*;
import java.io.*;

public class baseball {
	public static void main(String[] args) throws IOException {
		//long startTime = System.currentTimeMillis();
		
		BufferedReader in = new BufferedReader(new FileReader("baseball.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("baseball.out")));
		int amt = Integer.parseInt(in.readLine());
		int[] nums = new int[amt];
		for (int read = 0; read < amt; read++)
			nums[read] = Integer.parseInt(in.readLine());
		Arrays.sort(nums);
		int answer = 0;
		for (int firstNum = 0; firstNum < amt - 2; firstNum++)
			for (int secondNum = firstNum + 1; secondNum < amt - 1; secondNum++)
				for (int thirdNum = secondNum + 1; thirdNum < amt; thirdNum++)
					if (nums[thirdNum] >= nums[secondNum] + (nums[secondNum] - nums[firstNum]) && nums[thirdNum] <= nums[secondNum] + 2 * (nums[secondNum] - nums[firstNum])) 
						answer++;
		out.println(answer);
		in.close();
		out.close();
		//long endTime = System.currentTimeMillis();
		//System.out.println((endTime - startTime) / 1000.0);
		System.exit(0);
	}

}