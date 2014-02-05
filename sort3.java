/*
ID: omarbic1
LANG: JAVA
PROG: sort3
*/
import java.util.*;
import java.io.*;
public class sort3 {
	static int[] amts; 
	static int swapNum;
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(new FileReader("sort3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		int[] ourNums = new int[in.nextInt()];
		int amtOnes = 0;
		int amtTwos = 0;
		int amtThrees = 0;
			for (int ind = 0; ind < ourNums.length; ind++) {
			int nextInt = in.nextInt();
			ourNums[ind] = nextInt;
			if (nextInt == 1)
				amtOnes++;
			else if (nextInt == 2)
				amtTwos++;
			else
				amtThrees++;
		}
		swapNum = 0;
		int[] amts = {amtOnes,amtTwos,amtThrees};
		int[] whatsRight = new int[ourNums.length];
		for (int h = 0; h < whatsRight.length; h++)
			if (h < amtOnes) whatsRight[h] = 0;
			else if (h < amtOnes + amtTwos) whatsRight[h] = 1;
			else whatsRight[h] = 2;
		int[][] rapidSwap = new int[3][3];
		for (int i = 0; i < ourNums.length; i++)
			rapidSwap[ourNums[i] - 1][whatsRight[i]]++;
		swapNum = Math.min(rapidSwap[0][1],rapidSwap[1][0]) + Math.min(rapidSwap[1][2],rapidSwap[2][1]) + Math.min(rapidSwap[2][0],rapidSwap[0][2]);
		int doubleSwaps = 2 * (Math.max(rapidSwap[0][1],rapidSwap[1][0]) - Math.min(rapidSwap[0][1],rapidSwap[1][0]));
		swapNum += doubleSwaps;					
		System.out.println(swapNum);
		out.println(swapNum);			
		in.close();

		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0);
		System.exit(0);
		}

}