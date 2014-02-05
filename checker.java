/*
ID: omarbic1
LANG: JAVA
PROG: checker
*/
import java.util.*;
import java.io.*;

public class checker {
	static boolean[] canRow;
	static boolean[] leftDiag;
	static boolean[] rightDiag;
	static int[] answer;
	static int count;
	static int boardSize;
	static int printTime;
	static PrintWriter out;  
	public static void main(String[] args) throws IOException {
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(new FileReader("checker.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("checker.out")));
		boardSize = in.nextInt();
		in.close();
		canRow = new boolean[boardSize];
		answer = new int[boardSize];
		leftDiag = new boolean[26];
		rightDiag = new boolean[26];
		printTime = 0;
		count = 0;
		queenIt(0);
		out.println(count);
		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0);
		System.exit(0);
	}
	public static void queenIt(int column) {
		if (column == boardSize) {
			if (printTime < 3) {
				for (int p = 0; p < boardSize - 1; p++)
					out.print(answer[p] + 1 + " ");
				out.print(answer[boardSize - 1] + 1 + "\n");
				printTime++;
			}		
			count++;
			return;
		}
		for (int row = 0; row < boardSize; row++) {
			if (!canRow[row] && !rightDiag[row + column] && !leftDiag[row - column + 13]) {
				canRow[row] = rightDiag[row + column] = leftDiag[row - column + 13] = true;
				answer[column] = row;
				queenIt(column + 1);
				canRow[row] = rightDiag[row + column] = leftDiag[row - column + 13] = false;
			}
		}
		return;
	}

}