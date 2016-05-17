/**
 * http://www.geeksforgeeks.org/count-number-of-ways-to-fill-a-n-x-4-grid-using-1-x-4-tiles/
 * 
 * Count number of ways to fill a n x 4 grid using 1 x 4 tiles
Given a number n, count number of ways to fill a n x 4 grid using 1 x 4 tiles.

Examples:

Input : n = 1
Output : 1

Input : n = 2
Output : 1
We can only place both tiles horizontally

Input : n = 3
Output : 1
We can only place all tiles horizontally.

Input : n = 4
Output : 2
The two ways are : 
  1) Place all tiles horizontally 
  2) Place all tiles vertically.

Input : n = 5
Output : 3
We can fill a 5 x 4 grid in following ways : 
  1) Place all 5 tiles horizontally
  2) Place first 4 vertically and 1 horizontally.
  3) Place first 1 horizontally and 4 horizontally.
 */
package com.kumanoit.dynamicProgramming;

public class TilesPlacement {

	public static void main(String[] args) {
		int n = 150;
		System.out.println(getNumberOfWaysToPlaceTilesDPIterative(n));
		System.out.println(getNumberOfWaysToPlaceTilesDPRecursicve(n, new long[n + 1]));
		System.out.println(getNumberOfWaysToPlaceTilesRecursive(n));
	}

	private static long getNumberOfWaysToPlaceTilesDPRecursicve(int n, long[] arr) {
		if (n <= 0) {
			return 0;
		}
		if (n < 4) {
			return 1;
		}
		if (n == 4) {
			return 2;
		}
		if (arr[n] != 0) {
			return arr[n];
		}
		arr[n] = getNumberOfWaysToPlaceTilesDPRecursicve(n - 1, arr)
				+ getNumberOfWaysToPlaceTilesDPRecursicve(n - 4, arr);
		return arr[n];
	}

	private static long getNumberOfWaysToPlaceTilesDPIterative(int n) {
		long[] dp = new long[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;
		dp[4] = 2;
		for (int i = 5; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 4];
		}
		return dp[n];
	}

	private static long getNumberOfWaysToPlaceTilesRecursive(int n) {
		if (n <= 0) {
			return 0;
		}
		if (n < 4) {
			return 1;
		}
		if (n == 4) {
			return 2;
		}
		return getNumberOfWaysToPlaceTilesRecursive(n - 1)
				+ getNumberOfWaysToPlaceTilesRecursive(n - 4);
	}
}
