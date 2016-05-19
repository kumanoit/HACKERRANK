package dynamicProgramming;

public class GridWalkingSingleDimension {

	private static long[][] m;
	private static long num = 1000000007;
	public static void main(String[] args) {
		int loc = 25;
		int moves = 236;
		m = new long[loc + moves + 1][moves + 1];
		int dim = 87;
		for(int i = 0; i < loc + moves + 1; i++) {
			for(int j = 0; j < moves + 1; j++) {
				m[i][j] = -1;
			}
		}
		System.out.println("running");
		System.out.println(getTotalWays(loc, moves, dim));
	}

	private static long getTotalWays(int loc, int moves, int dim) {
		if (loc < 1 || loc > dim) {
			return 0;
		}
//		if (m[loc][moves] != -1) {
//			return m[loc][moves];
//		}
		if(moves == 0) {
			return 1;
		}
//		m[loc][moves] = (getTotalWays(loc - 1, moves - 1, dim) % num
//				+ getTotalWays(loc + 1, moves - 1, dim) % num) % num;
//		System.out.println(loc + "\t" + moves + "\t" + m[loc][moves]);
//		return m[loc][moves];
		long p = (getTotalWays(loc - 1, moves - 1, dim) % num
				+ getTotalWays(loc + 1, moves - 1, dim) % num) % num;
		System.out.println(loc + "\t" + moves + "\t" + p);
		return p;
	}
}
