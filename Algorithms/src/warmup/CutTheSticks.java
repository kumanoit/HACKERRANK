package warmup;
//https://www.hackerrank.com/challenges/cut-the-sticks
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class CutTheSticks {

	private static int[] map = new int[1001];

	public static void main(String[] args) {
		TreeSet<Integer> sortedSet = new TreeSet<Integer>();
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		if(n < 1 || n > 1000) {
			System.exit(0);
		}
		
		for(int i = 0; i < n; i++) {
			int temp = in.nextInt();
			if(temp < 1 || temp > 1000) {
				System.exit(0);
			}
			if(map[temp] == 0) {
				sortedSet.add(temp);
			}
			map[temp] ++;
		}
		printSolution(map, sortedSet);
		in.close();
	}
	
	private static void printSolution(int[] map, TreeSet<Integer> sortedSet) {
		TreeSet<Integer> descendingSet = (TreeSet<Integer>) sortedSet.descendingSet();
		Iterator<Integer> iter = descendingSet.iterator();
		int prev = map[iter.next()];
		while(iter.hasNext()) {
			int index = iter.next();
			map[index] += prev;
			prev = map[index];
		}
		
		for(Integer index : sortedSet) {
			System.out.println(map[index]);
		}
	}
	
}
