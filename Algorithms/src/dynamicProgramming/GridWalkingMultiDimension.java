package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GridWalkingMultiDimension {

	private static Map<Integer[], Long> map = new HashMap<Integer[], Long>();
	private static long mod = 1000000007;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTestCase = in.nextInt();
		for(int i = 0; i < numberOfTestCase; i++) {
			int dim = in.nextInt();
			int moves = in.nextInt();
			int[] x = new int[dim];
			int[] d = new int[dim];
			for(int j = 0; j < dim; j++) {
				x[j] = in.nextInt();
			}
			for(int j = 0; j < dim; j++) {
				d[j] = in.nextInt();
			}
			System.out.println(getTotalWays(x, d, moves));
		}
		in.close();
	}
	
	private static long getTotalWays(int[] x, int[] d, int moves) {
		for(int i = 0; i < x.length; i++) {
			if(x[i] < 1 || x[i] > d[i]) {
				return 0;
			}
		}
		if(moves == 0) {
			return 1;
		}
		Integer[] arr = new Integer[x.length + 1];
		for(int i = 0; i < x.length; i++) {
			arr[i] = x[i];
		}
		arr[x.length] = moves;

		if(map.containsKey(arr)) {
			return map.get(arr);
		}

		long ways = 0;
		for(int i = 0; i < x.length; i++) {
			int temp = x[i];
			x[i] = temp - 1;
			ways = (ways + getTotalWays(x, d, moves - 1) % mod) % mod;
			x[i] = temp + 1;
			ways = (ways + getTotalWays(x, d, moves - 1) % mod) % mod;
			x[i] = temp;
		}
		map.put(arr, ways);
		System.out.println(arr[0] + "\t" + map.get(arr) + "\t >>> " + ways);
		return ways;
	}
}
