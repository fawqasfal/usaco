/*
ID: omarbic1
LANG: JAVA
PROG: packrec
*/
//this problem was pretty boring ... 
import java.util.*;
import java.io.*;

class packrec {
	static int[] smalls = new int[2]; 
	static int area = 999999999;
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new FileReader("packrec.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("packrec.out")));
		int[][] rects = new int[4][2];
		for (int rectInd = 0; rectInd < 4; rectInd++){
			rects[rectInd][0] = in.nextInt();
			rects[rectInd][1] = in.nextInt();
		}

		checkpermute(rects,0);
		System.out.println(Arrays.toString(smalls));
		in.close();
		out.close();
		System.exit(0);	
	}
	public static int checkConfig(int[][] config, int style) {
		int[] bigRect = new int[2];
		//0 = length
		//1 = width
		bigRect[0] = 0;
		bigRect[1] = 0;
		int[] smallLength = new int[2];
		smallLength[0] = 0;
		smallLength[1] = 0;
		int i = 0;
		if (style == 0)
			for (i = 0; i < config.length; i++) {
				bigRect[0] = Math.max(config[i][0], bigRect[0]);
				bigRect[1] += config[i][1];
			}

		if (style == 1) {
			for (i = 0; i < config.length - 1; i++) {
				bigRect[0] = Math.max(config[i][0], bigRect[0]);
				bigRect[1] += config[i][1];
			}
			bigRect[1] = Math.max(config[config.length - 1][1],bigRect[1]);
			bigRect[0] += config[config.length - 1][0];
		}

		if (style == 2) {
			bigRect[0] = Math.max(Math.max(config[0][0], config[1][0]) + config[2][0], config[3][0]);
			bigRect[1] = Math.max(config[0][1] + config[1][1], config[2][1]) + config[3][1];

		}
		if (style == 3 || style == 4) {
			bigRect[0] = Math.max(config[1][0] + config[2][0], Math.max(config[0][0],config[3][0]));
			bigRect[1] = config[0][1] + config[3][1] + Math.max(config[1][1], config[2][1]);
		}
		if (style == 5) {
			bigRect[0] = Math.max(config[0][0] + config[1][0], config[2][0] + config[3][0]);
			bigRect[1] = config[0][1] + config[2][1];
			if(config[0][0] < config[2][0])
			      bigRect[1] = Math.max(bigRect[1], config[1][1]+config[2][1]);
			  if(config[0][0]+config[3][0] > config[2][0])
			      bigRect[1] = Math.max(bigRect[1], config[1][1]+config[3][1]);
			  if(config[2][0] < config[0][0])
			      bigRect[1] = Math.max(bigRect[1], config[0][1]+config[3][1]);

			  bigRect[1] = Math.max(Math.max(bigRect[1], config[1][1]), config[3][1]);
		}
		if (bigRect[0] * bigRect[1] <= area) {
			area = bigRect[0] * bigRect[1];
			smallLength[0] = bigRect[0];
			smallLength[1] = bigRect[1];
			smalls = smallLength;
		}
		return area;	
	}
	public static int checkConfig(int[][] config) {
		for (int i = 0; i < 6; i++)
			return checkConfig(config,i);
		return 0;
	}
	public static void rotate(int[] config) {
		int a = config[1];
		config[1] = 0;
		config[0] = 1;
	}
	public static void checkRotate(int[][] config, int n) {
   		if(n == 4) {
       	return;
   		}
   		checkConfig(config);
   		checkRotate(config, n+1);
   		rotate(config[n]);
   		checkRotate(config, n+1);
   		rotate(config[n]);
	}

	public static void checkpermute(int [][] config, int n) {
		int[] rec;
   		int i;
  	 	if(n == 4)
       		return;

   		for(i=n; i<4; i++) {
       		rec = config[n];
       		config[n] = config[i];
       		config[i] = rec;   
       		checkpermute(config, n+1);
       		rec = config[n];
       		config[n] = config[i];
       		config[i] = rec;  
       		checkRotate(config,i);  
	   }
	}

}