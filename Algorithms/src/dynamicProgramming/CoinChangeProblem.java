package dynamicProgramming;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/coin-change
public class CoinChangeProblem {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int m = in.nextInt();
		int[] arr = new int[m];
		for(int i = 0; i < m;  i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(getNumberOfWaysDP(N, arr, m));
		in.close();
	}

	/**
	 * recursive way to get solution
	 * complexity O(2^n)
	 * @param N
	 * @param arr
	 * @param m
	 * @return
	 */
	private static long getNumberOfWays(int N, int[] arr, int m) {
		if (m == 0 && N > 0) {
			return 0;
		}
		if(N == 0) {
			return 1;
		}
		if(arr[m -1] > N) {
			return getNumberOfWays(N, arr, m - 1);
		}
		return getNumberOfWays(N - arr[m - 1], arr, m) +
				getNumberOfWays(N, arr, m - 1);
	}
	
	/**
	 * Dynamic programming
	 * Complexity : O(Nm)
	 * @param N
	 * @param arr
	 * @param m
	 * @return
	 */
	private static long getNumberOfWaysDP(int N, int[] arr, int m) {
		long[][] mat = new long[N + 1][m + 1];
		for (int i = 1; i <= m; i++) {
			mat[0][i] = 1;
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= m; j++) {
				mat[i][j] = mat[i][j - 1];
				if (arr[j - 1] <= i) {
					mat[i][j] += mat[i - arr[j -1]][j];
				}
			}
		}
		return mat[N][m];
	}
}
