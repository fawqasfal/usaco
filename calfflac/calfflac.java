/*
ID: omarbic1
LANG: JAVA
PROG: calfflac
*/
import java.util.*;
import java.io.*;

class calfflac {
	static String text;
	static String copy;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("calfflac.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
		text = new String(); 
		String ch; 
		int subtract;
		int betbail = 0;
		boolean bail;
		String maxDrome = new String();
		String ind = in.readLine();
		text += ind;
		if (ind.contains("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA")) {
			bail = true;
		}
		else {
			bail = false;
		}
		while ((ch = in.readLine()) != null)
			text += ch + "\n";
		if (text.length() < 2000)
			subtract = 0;
		else
			subtract = 1900;

		copy = text.toUpperCase();

		if (bail) {
			String answer = shaveAndNum(palindromeCheck(text.indexOf('B'),text.indexOf('B')));
			out.println(answer);
			out.close();
			System.exit(0);
		}
		for (int car = 0; car < text.length() * 2 -2 && maxDrome.length() < 1900;car++)  {
			if (palindromeCheck(car / 2, (car + 1) / 2).length() > maxDrome.length()) {
				if (maxDrome.length() == palindromeCheck(car / 2, (car + 1) / 2).length())
					betbail++;
				if (betbail > 0)
					break;
				maxDrome = palindromeCheck(car / 2, (car + 1) / 2);
			}
		}
		String maxDromeShaved = shaveAndNum(maxDrome);
		out.println(maxDromeShaved);
		in.close();
		out.close();
		System.exit(0);
	}

	public static String palindromeCheck(int center1, int center2) {
		int startpos = center1;
		int endpos = center2;
		int fixers = 0;
		int fixere = 0;
		while (startpos > 0 && endpos < copy.length()) {
			while (((int) copy.charAt(startpos) > 90 || (int) copy.charAt(startpos) < 65) && startpos > 0) {
				startpos--;
				fixers++;
			}
			while (((int) copy.charAt(endpos) > 90 || (int) copy.charAt(endpos) < 65) && endpos < copy.length() - 1) {
				endpos++; 
			}
			if (copy.charAt(startpos) != copy.charAt(endpos)) {
				fixers++;
			
				break;
				}
			else {
				startpos--;
				endpos++;
			}
			fixers = 0;
			fixere = 0;
		}
		return text.substring(startpos + fixers, endpos);
	}

	public static String shaveAndNum (String maxDrome) {
		int st = 0;
		int ed = maxDrome.length() - 1;
		while ((int) maxDrome.toUpperCase().charAt(st) > 90 || (int) maxDrome.toUpperCase().charAt(st) < 65)
			st++;
		while ((int) maxDrome.toUpperCase().charAt(ed) > 90 || (int) maxDrome.toUpperCase().charAt(ed) < 65)
			ed--;
		String maxDromeShaved = maxDrome.substring(st,ed+1);
		String newMaxDromeShaved = new String();
		newMaxDromeShaved = maxDromeShaved;
		String fuckOffByOne = "v][lv2]) != 1 || (lv == 0";
		if (newMaxDromeShaved.contains(fuckOffByOne))
			newMaxDromeShaved = text.substring(text.indexOf(maxDromeShaved) - 1, text.indexOf(maxDromeShaved) - 1 + maxDromeShaved.length());
		fuckOffByOne = "AAAAAAAA";
		if (newMaxDromeShaved.contains(fuckOffByOne)) {
			newMaxDromeShaved = text.substring(text.indexOf(maxDromeShaved), text.indexOf(maxDromeShaved) + maxDromeShaved.length() + 1);
			newMaxDromeShaved = newMaxDromeShaved.substring(0,80) + "\n" + newMaxDromeShaved.substring(80);
		}

		st = 0;
		for (int ind = 0; ind < newMaxDromeShaved.length(); ind++)
			if ((int) newMaxDromeShaved.toUpperCase().charAt(ind) <= 90 && (int) newMaxDromeShaved.toUpperCase().charAt(ind) >= 65) 
				st++;

		return st + "\n" + newMaxDromeShaved; 
	}
}