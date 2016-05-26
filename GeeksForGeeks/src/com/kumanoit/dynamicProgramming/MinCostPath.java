/**
 * Given a cost matrix cost[][] and a position (m, n) in cost[][], 
 * write a function that returns cost of minimum cost path to reach 
 * (m, n) from (0, 0). Each cell of the matrix represents a cost to traverse
 *  through that cell. Total cost of a path to reach (m, n) is sum of all the
 *   costs on that path (including both source and destination).
 *    You can only traverse down, right and diagonally lower cells from a given
 *     cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) 
 *     can be traversed. You may assume that all costs are positive integers.

For example, in the following figure, what is the minimum cost path to (2, 2)?


The path with minimum cost is highlighted in the following figure.
The path is (0, 0) –> (0, 1) –> (1, 2) –> (2, 2). The cost of the path is 8 (1 + 2 + 2 + 3).

 */
package com.kumanoit.dynamicProgramming;

public class MinCostPath {

	public static void main(String[] args) {
      int[][] cost = {	{1, 2, 3},
    		  			{4, 8, 2},
    		  			{1, 5, 3}
    		  			};
		System.out.println("Normal : " + getMinPath(cost, cost.length, cost[0].length));
		System.out.println("Via DP : " + getMinPathSumDP(cost, cost.length, cost[0].length));
	}

	private static int getMinPath(int[][] cost, int m, int n) {
//		if (m == 1) {
//			int sum = 0;
//			while (n != 0) {
//				sum += cost[m - 1][n - 1];
//				n--;
//			}
//			return sum;
//		}
//
//		if (n == 1) {
//			int sum = 0;
//			while (m != 0) {
//				sum += cost[m - 1][n - 1];
//				m--;
//			}
//			return sum;
//		}

		if (m == 0 || n == 0) {
			return Integer.MAX_VALUE;
		}

		if (m == 1 && n == 1) {
			return cost[m - 1][n - 1];
		}

		return cost[m - 1][n - 1] + 
				Math.min(
					Math.min(
							getMinPath(cost, m - 1, n),
							getMinPath(cost, m, n - 1)
						),
					getMinPath(cost, m - 1, n - 1)
				);
	}

	private static int getMinPathSumDP(int[][] cost, int m, int n) {
		int[][] map = new int[m][n];
		map[0][0] = cost[0][0];
		for (int i = 1; i < m; i++) {
			map[i][0] = cost[i][0] + map[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			map[0][i] += cost[0][i] + map[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				map[i][j] = cost[i][j]
							+ Math.min(
								Math.min(
									map[i - 1][j],
									map[i][j - 1]
								),
								map[i - 1][j - 1]
							);
			}
		}
//		ArrayUtility.printMatrix(map);
		return map[m - 1][n - 1];
	}
}
