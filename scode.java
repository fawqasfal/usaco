/*
ID: omarbic1
LANG: JAVA
PROG: scode
*/
import java.io.*;
import java.util.*;
class  scode {
	static String word;
	static int soFar;
	public static void main (String [] args) throws IOException {
		long nowTime = System.nanoTime();
    	Scanner in = new Scanner(new FileReader("scode.in"));
    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("scode.out")));
    	word = in.next(); 
    	out.println(goBack());
		System.out.println(nowTime / Math.pow(10,9));
		out.close();
	}
	public static int goBack(String mangled) {
		//System.out.println(mangled + " " + soFar);
		if (mangled.length() % 2 == 0)
			return soFar;
		int length = (mangled.length() + 1) / 2;
		String firstWord = mangled.substring(0,length);
		//System.out.println("fw " + firstWord);
		String restWordFirst = mangled.substring(length, mangled.length());
		//System.out.println("rwf " + restWordFirst);
		String backWord = mangled.substring(length - 1, mangled.length());
		//System.out.println("bw " + backWord);
		String restWordBack = mangled.substring(0,length - 1);
		//System.out.println("rwb " + restWordBack);
		/*System.out.println(firstWord.substring(0,firstWord.length() - 1).equals(restWordFirst));
		System.out.println(firstWord.substring(1,firstWord.length()).equals(restWordFirst));
		System.out.println(backWord.substring(0,backWord.length() - 1).equals(restWordBack));
		System.out.println(backWord.substring(1,backWord.length()).equals(restWordBack));*/
		if (firstWord.substring(0,firstWord.length() - 1).equals(restWordFirst) || firstWord.substring(1,firstWord.length()).equals(restWordFirst)) {
			soFar++;
			goBack(firstWord);
		}
		/*if (firstWord.substring(1,firstWord.length()).equals(restWordFirst)) {
			soFar++;
			goBack(firstWord);
		}*/
		if (backWord.substring(0,backWord.length() - 1).equals(restWordBack) || backWord.substring(1,backWord.length()).equals(restWordBack)) {
			soFar++;
			goBack(backWord);
		}
		/*if (backWord.substring(1,backWord.length()).equals(restWordBack)) {
			soFar++;
			goBack(backWord);
		}*/		
			return soFar;
	}
	public static int goBack() {
		return goBack(word);
	}
	
}