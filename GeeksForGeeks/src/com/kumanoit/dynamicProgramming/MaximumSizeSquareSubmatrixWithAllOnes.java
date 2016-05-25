package com.kumanoit.dynamicProgramming;

public class MaximumSizeSquareSubmatrixWithAllOnes {

	public static void main(String[] args) {
		int[][] mat = {	{0, 1, 1, 0, 1}, 
		                {1, 1, 0, 1, 0}, 
		                {0, 1, 1, 1, 0},
		                {1, 1, 1, 1, 0},
		                {1, 1, 1, 1, 1},
		                {0, 0, 0, 0, 0}
		              };
		getMaximumSizeSubmatrixWithAllOnesDP(mat);
	}

	private static void getMaximumSizeSubmatrixWithAllOnesDP(int[][] mat) {
		int m = mat.length;
		int n = mat[0].length;
		int maxSize = 0;
		int end_i = -1;
		int end_j = -1;
		int[][] s = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			s[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			s[0][i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (mat[i - 1][j - 1] == 1) {
					s[i][j] = 1 + Math.min(
										s[i - 1][j - 1],
										Math.min(s[i - 1][j], s[i][j - 1])
									);
					if (maxSize < s[i][j]) {
						maxSize = s[i][j];
						end_i = i;
						end_j = j;
					}
				} else {
					s[i][j] = 0;
				}
			}
		}
		System.out.println("Maximum size subarray is " + maxSize);
		System.out.println("Index is [" + (end_i - maxSize) + ", " + (end_j - maxSize) + "]");
	}
}
