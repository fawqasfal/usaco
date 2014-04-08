/*
ID: omarbic1
LANG: JAVA
PROG: dualpal
*/
import java.io.*;
import java.util.*;
class dualpal {
	public static String[] convert = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J"};
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		String inString = in.readLine();
		int increase = Integer.parseInt(inString.substring(0,inString.indexOf(" ")));
		int start = Integer.parseInt(inString.substring(inString.indexOf(" ") + 1)) + 1;
		int success = 0;
		int weDidIt = 0;
		while (weDidIt < increase) {
			for (int z = 2; z <= 10; z++) {
				if (isPalindrome(baseConverter(start,z))) {
					success++;
					if (success >= 2) {
						success = 0;
						weDidIt++;
						out.println(start);
						break;
					}
				}
			}
			start++;
			success = 0;
		}
		out.close();
		System.exit(0);
	}
	//i figured using a built in base converter would be cheating
	public static String baseConverter(int num, int newBase) {
		String ans = ""; 
		int starter = num;
		boolean onlyZero = true;
		for (int z = (int) (Math.log(num)/Math.log(newBase)); z >= 0; z--) {
			String add = convert[starter / (int) Math.floor(Math.pow(newBase,z))];
			if (onlyZero && !add.equals("0") || z == 0)
				onlyZero = false;
			if (!onlyZero)
				ans += add;
			starter = starter % (int) Math.pow(newBase,z);
		}
		return ans;
	}
	public static boolean isPalindrome(String value) {
		int length = value.length();
		for (int i = 0; i < length; i++)
			if (value.charAt(i) != value.charAt(length - 1 -i))
				return false;
		return true;
	}		
}