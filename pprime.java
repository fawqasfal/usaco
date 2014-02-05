/*
ID: omarbic1
LANG: JAVA
PROG: sprime
*/
import java.util.*;
import java.io.*;

class sprime {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new FileReader("sprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
		int length = in.nextInt();
		int currentInt = 0;
		in.close();
		System.out.println(genSupPrimes(3).toString());
		out.close();
		System.exit(0);
	}
	public static int[] genSupPrimes(int len) {
		if (len == 1)
		{
			int[] answers = {2,3,5,7};
		}
		int[] firstNums = genSupPrimes(len - 1);
		int[] lastNums = {1,3,7,9};
		return addArrays(firstNums,lastNums);
	}
	public static int[] addArrays(int[] a, int[] b) {
		int[] answer = new int[a.length + b.length];
		for (int i = 0; i < a.length; i++)
			answer[i] = a[i];
		for (int k = a.length; k < b.length - a.length; k++)
			answer[k] = b[k];
		return answer;
}