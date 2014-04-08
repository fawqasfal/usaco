/*
ID: omarbic1
LANG: JAVA
PROG: crypt1
*/
import java.util.*;
import java.io.*;

class crypt1 {
	static int[] prepped;
	static int[] stalls;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		int amtNums = Integer.parseInt(in.readLine());
		String strNums = in.readLine();
		int[] nums = new int[amtNums];
		String compareNums = "";
		int answer = 0;
		int start = 0;
		for (int l = 0; l < strNums.length(); l+= 2) {
			nums[l / 2] = Integer.parseInt(String.valueOf(strNums.charAt(l)));
			compareNums += Integer.parseInt(String.valueOf(strNums.charAt(l)));
		}
		for (int i = 0; i < nums.length; i++)
			for (int la = 0; la < nums.length; la++)
				for (int zy = 0; zy < nums.length; zy++)
					for (int iamlazy = 0; iamlazy < nums.length; iamlazy++)
						for (int thiscodeisugly = 0; thiscodeisugly < nums.length; thiscodeisugly++)
							if ((nums[i] * 100 + nums[la] * 10 + nums[zy]) * (nums[iamlazy] * 10 + nums[thiscodeisugly]) < 10000 && containsAll(compareNums, multiply((nums[i] * 100 + nums[la] * 10 + nums[zy]), (nums[iamlazy] * 10 + nums[thiscodeisugly]))))
								answer++;
		out.println(answer);
		in.close();
		out.close();
		System.exit(0);	
	}
	public static String multiply(String tryOne, String tryTwo) {
		//tryOne is the 3-digit number, tryTwo is the 2-digit number.
		int dOne = Integer.parseInt(tryOne);
		int[] dTwo = new int[tryTwo.length()];
		for (int two = 0; two < tryTwo.length(); two++)
			dTwo[two] = Integer.parseInt(String.valueOf(tryTwo.charAt(two)));
		String firstRow = String.valueOf(dOne * dTwo[1]); 
		if (dOne * dTwo[1] > 999 || dOne * dTwo[0] > 999)
			return "asdf";
 
		String secondRow = String.valueOf(dOne * dTwo[0]); //no trailing zeroes
		int finAns = dOne * dTwo[1] + dOne * dTwo[0] * 10;
		String answer = firstRow + secondRow  + finAns;
		return answer;
	}
	public static String multiply(int tryOne, int tryTwo) {
		return multiply(String.valueOf(tryOne), String.valueOf(tryTwo));
	}
	public static boolean containsAll(String container, String contained) {
		for (int i = 0; i < contained.length(); i++)
			if (!container.contains(String.valueOf(contained.charAt(i))))
				return false;
		return true;
	}
}