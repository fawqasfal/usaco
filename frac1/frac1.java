/*
ID: omarbic1
LANG: JAVA
PROG: frac1
*/
import java.util.*;
import java.io.*;

public class frac1 {
	static ArrayList<Fraction> fractions;
	public static void main(String[] args) throws IOException {
		long nowTime = System.nanoTime();
		Scanner in = new Scanner(new FileReader("frac1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		fractions = new ArrayList<Fraction>();
		fractions.add(new Fraction(0, 1));
		int denom = in.nextInt();
		in.close();
		for (int i = 2; i <= denom; i++)
			for (int k  = 1; k < i; k++) {
				Fraction newFrac = new Fraction(k,i);
				newFrac.reduce();
				if (!fractions.contains(newFrac))
					fractions.add(newFrac);
			}
		Collections.sort(fractions);
		fractions.add(new Fraction(1,1));
		for (Fraction k : fractions)
			out.println(k.toString());	
		out.close();
		nowTime = System.nanoTime() - nowTime;
		System.out.println(nowTime / Math.pow(10,9));	
	}
}
class Fraction implements Comparable<Fraction> {
	public int num;
	public int denom;
	public Fraction(int n, int d) {
		this.num = n;
		this.denom = d;
	}
	public int compareTo(Fraction b) {
		int ourCompare = this.num * b.denom;
		int theirCompare = b.num * this.denom;
		return ourCompare - theirCompare;
	}
	public String toString() {
		return this.num + "/" + this.denom;
	}
	public int gcf(int a, int b) {
		if (b == 0) 
			return a;
		return (gcf(b,a%b));
	}
	public void reduce() {
		int gcf = this.gcf(num,denom);
		this.num = this.num / gcf;
		this.denom = this.denom / gcf;
	}
	public boolean equals(Object b) {
		if (b != null && b instanceof Fraction) {
			Fraction their = (Fraction) b;
			return (this.num == their.num) && (this.denom == their.denom);
		}
		return false;
	}
}