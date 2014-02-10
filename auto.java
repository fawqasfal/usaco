/*
ID: omarbic1
LANG: JAVA
PROG: auto
*/
import java.io.*;
import java.util.*;
class  auto {
	public static void main (String [] args) throws IOException {
		long nowTime = System.nanoTime();
    	Scanner in = new Scanner(new FileReader("auto.in"));
    	PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("auto.out")));
    	ArrayList<String> dict = new ArrayList<String>();
    	ArrayList<String> fuckJava = new ArrayList<String>();
    	ArrayList<String> partials = new ArrayList<String>();
    	ArrayList<Integer> partialNum = new ArrayList<Integer>();
    	int dictLength = in.nextInt();
    	int wordLength = in.nextInt();
    	for (int i = 0; i < dictLength; i++) {
			String fuckJavaSrsly = in.next();
			dict.add(fuckJavaSrsly);
			fuckJava.add(fuckJavaSrsly);
		}    		
    	while (in.hasNext()) {
    		partialNum.add(Integer.parseInt(in.next()));
    		partials.add(in.next());
    	}
    	Collections.sort(dict);
    	for (int k = 0; k < partials.size(); k++) {
    		String word = partials.get(k);
    		int num = partialNum.get(k);
    		int counter = 0;
    		int index = -1;
    		for (int d = 0; d < dict.size() && counter < num; d++) {
    			String thisWord = dict.get(d);
    			if (thisWord.substring(0, word.length()).equals(word))
    				counter++;
    			if (counter == num)
    				index = fuckJava.indexOf(thisWord) + 1;
    		}
    		out.println(index);
    	}
		System.out.println(nowTime / Math.pow(10,9));
		out.close();
	}
	
}