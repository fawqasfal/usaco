/*
ID: omarbic1
LANG: JAVA
PROG: castle
*/
import java.util.*;
import java.io.*;
public class castle {
	static int[][] board;
	static ArrayList<ArrayList<ArrayList<Integer>>> rooms = new ArrayList<ArrayList<ArrayList<Integer>>>(); 
	//its an arraylist of rooms. each room is an arraylist that contains the coordinates of the squares in the room. each square is an arraylist of
	//vert, hor. 
	public static void main(String[] args) throws IOException {	
		//setup
		long startTime = System.currentTimeMillis();
		Scanner in = new Scanner(new FileReader("castle.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		rooms.add(new ArrayList<ArrayList<Integer>>());
		rooms.get(0).add(new ArrayList<Integer>());
		//input
		int hor = in.nextInt();
		int ver = in.nextInt();
		board = new int[ver][hor];
		for (int v = 0; v < ver; v++)
			for (int h = 0; h < hor; h++)
				board[v][h] = in.nextInt();
		in.close();

		addRoom(0,0,0);
		System.out.println(printRoom());

		out.close();
		long endTime = System.currentTimeMillis();
		System.out.println((endTime - startTime) / 1000.0);
		System.exit(0);
	}
	public static void addRoom(int ver, int hor, int roomNum) {
		//find all rooms and put them in the rooms arraylist, recursively
		ArrayList<Integer> thisRoom = new ArrayList<Integer>();
		thisRoom.add(ver);
		thisRoom.add(hor);
		//check to see if it's out of bounds OR already in a room
		boolean safe = ver >= 0 && ver < board.length && hor >= 0 && hor < board[0].length;
		if (!safe)
			return;
		for (ArrayList<ArrayList<Integer>> room : rooms)
			if (room.contains(thisRoom)) {
				safe = false;
				return;
			}
		rooms.get(roomNum).add(thisRoom);
		//check to see if the square west/east/north/south can be added to the current room
		int thisInt = board[ver][hor];
		
		boolean canWest = thisInt % 2 == 0;
		boolean canSouth = thisInt % 4 == 0 || thisInt % 2 == 1;
		boolean canEast = thisInt == 8 || thisInt % 4 != 0;
		boolean canNorth = thisInt < 8;
		if (canWest && safe) {
			addRoom(ver, hor - 1, roomNum);
		}
		if (canSouth && safe) {
			addRoom(ver + 1, hor, roomNum);
		}
		if (canEast && safe) {
			addRoom(ver, hor + 1, roomNum);
		}
		if (canNorth && safe) {
			addRoom(ver - 1, hor, roomNum);
		}
		rooms.get(roomNum).remove(thisRoom);
	}
	public static String printRoom() {
		String answer = new String();
		for (ArrayList<ArrayList<Integer>> room : rooms) {
			for (ArrayList<Integer> square : room) 
				answer += square.toString() + "\n";
		}
		return answer;
	}

}