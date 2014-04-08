/*
ID: thisisomar
LANG: JAVA
PROG: Odometer
*/
import java.util.*;
import java.io.*;

public class Odometer {
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(new FileReader("odometer.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("odometer.out")));
		long x = Long.parseLong(in.next());
		long y = Long.parseLong(in.next());
		int moos = 0;
		for (long i = x; i <= y; i++) if (isInteresting(i)) moos++;
		out.println(moos);
		in.close();
		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0);
		System.exit(0);
	}

	public static boolean isInteresting(long x) {
		String unq = new String();
		String num = String.valueOf(x);
		for (int i = 0; i < num.length(); i++) {
			if (!unq.contains(String.valueOf(num.charAt(i))))
				unq += num.charAt(i);
			if (unq.length() > 2)
				return false;
		}
		if (unq.length() != 2)
			return false;
		return true;
	}
}