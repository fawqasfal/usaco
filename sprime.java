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
		ArrayList<Integer> answers = genSupPrimes(length);
		for (int k : answers)
			out.println(k);
		in.close();
		out.close();
		System.exit(0);
	}
	public static ArrayList<Integer> genSupPrimes(int len) {
		if (len == 1)
		{
			ArrayList<Integer> answers = new ArrayList<Integer>();
			answers.add(2);answers.add(3);answers.add(5);answers.add(7);
			return answers;
		}
		ArrayList<Integer> firstNums = genSupPrimes(len - 1);
		ArrayList<Integer> answer = new ArrayList<Integer>();
		int[] lastNums = {1,3,7,9};
		for (int i : firstNums)
			for (int k : lastNums)
				if (isPrime(i * 10 + k))
					answer.add(i * 10 + k);
		return answer;

	}
	public static boolean isPrime(int x) {
		for (int ans = 3; ans < Math.round(Math.sqrt(x)); ans+= 2)
			if (x % ans == 0)
				return false;
		return true;
	}
}