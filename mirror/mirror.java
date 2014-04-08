/*
ID: omarbic1
LANG: JAVA
PROG: mirror
*/
import java.io.*;
import java.util.*;
class  mirror {
	static ArrayList<ArrayList<Integer>> mirrors;
	public static void main (String [] args) throws IOException {
		long nowTime = System.nanoTime();
    	Scanner in = new Scanner(new FileReader("mirror.in"));
    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("mirror.out")));
    	int useless = in.nextInt();
    	int uselesstwo = in.nextInt();
    	mirrors = new ArrayList<ArrayList<Integer>>();
    	while (in.hasNext()) {
   			mirrors.add(new ArrayList<Integer>());
    		String thisLine = in.next();
    		for (int i = 0; i < thisLine.length(); i++) {
    			Character thisChar = thisLine.charAt(i);
    			if (thisChar == '/')
    				mirrors.get(mirrors.size() - 1).add(1);
    			else
    				mirrors.get(mirrors.size() - 1).add(-1);
    		}
		}
		int max = 0;
		int thisGRL = 0;
		for (int i = 0; i < mirrors.get(0).size() && max != -1; i++) {
			thisGRL = GRL(0,i,"negVer");
			if (thisGRL > max || thisGRL == -1)
				max = thisGRL;
		}
		for (int i = 0; i < mirrors.get(mirrors.size() - 1).size() && max != -1; i++) {
			thisGRL = GRL(mirrors.size() - 1, i, "posVer");
			if (thisGRL > max || thisGRL == -1)
				max = thisGRL;
		}
		for (int i = 0; i < mirrors.size() && max != -1; i++) {
			thisGRL = GRL(i,0,"posHor");
			if (thisGRL > max || thisGRL == -1)
				max = thisGRL;
			thisGRL = GRL(i,mirrors.get(i).size() - 1, "negHor");
			if (thisGRL > max || thisGRL == -1)
				max = thisGRL;
		}
		out.println(max);
		nowTime = System.nanoTime() - nowTime;
		System.out.println(nowTime / Math.pow(10,9));
		out.close();
	}
	public static int getRouteLength(int initPosX, int initPosY, int posX, int posY, String direction, int soFar, boolean beCareful) {
		System.out.println(initPosX + " " + initPosY + " " +  posX + " " + posY + " " + direction + " " + soFar);
		if (beCareful && posX < mirrors.size() && posX >= 0 && posY < mirrors.get(posX).size() && posY >= 0)
			return -1;
		if (soFar != 0 && initPosX == posX && posY == initPosY) 
			beCareful = true;
		else if (posX >= mirrors.size() || posX < 0) 
			return soFar;
		else if (posY >= mirrors.get(posX).size() || posY < 0) 
			return soFar;

		System.out.println(initPosX + " " + initPosY + " " +  posX + " " + posY + " " + direction + " " + soFar + " " + mirrors.get(posX).get(posY) + " " + beCareful);
		if (mirrors.get(posX).get(posY) == 1) {
			if (direction == "negVer")
				return getRouteLength(initPosX, initPosY, posX, posY - 1, "negHor", soFar + 1, beCareful);
			if (direction == "posVer")
				return getRouteLength(initPosX, initPosY, posX, posY + 1, "posHor", soFar + 1,beCareful);
			if (direction == "negHor")
				return getRouteLength(initPosX, initPosY, posX + 1, posY, "negVer", soFar + 1, beCareful);
			if (direction == "posHor")
				return getRouteLength(initPosX, initPosY, posX - 1, posY, "posVer", soFar + 1, beCareful);
		}
		else if (mirrors.get(posX).get(posY) == -1) {
			if (direction == "negVer")
				return getRouteLength(initPosX, initPosY, posX, posY + 1, "posHor", soFar + 1, beCareful);
			if (direction == "posVer")
				return getRouteLength(initPosX, initPosY, posX, posY - 1, "negHor", soFar + 1, beCareful);
			if (direction == "negHor")
				return getRouteLength(initPosX, initPosY, posX - 1, posY, "posVer", soFar + 1, beCareful);
			if (direction == "posHor")
				return getRouteLength(initPosX, initPosY, posX + 1, posY, "negVer", soFar + 1, beCareful);
		}
		return 0;
	}
	public static int GRL(int initPosX, int initPosY, String direction) {
		return getRouteLength(initPosX, initPosY, initPosX, initPosY, direction, 0, false);
	}
}