/**
 * Dynamic Programming | Set 7 (Coin Change)
Given a value N, if we want to make change for N cents,
 and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
  how many ways can we make the change? The order of coins doesn’t matter.

For example, for N = 4 and S = {1,2,3}, there are four solutions:
 {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and 
 S = {2, 5, 3, 6}, there are five solutions: 
 {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}.
  So the output should be 5.
 */
package com.kumanoit.dynamicProgramming;

import com.kumanoit.utils.arrays.ArrayUtility;

public class CoinChangeRepeatedUsage {

	public static void main(String[] args) {
		int amount = 10;// 4;
		int[] denomination = {2, 5, 3, 6};// {1, 2, 3};
		int n = denomination.length;
		System.out.println("Normal : " + getTotalWaysToChangeCoin(amount, denomination, n));
		System.out.println("Via DP : " + getTotalWaysDP(amount, denomination, n));
	}

	private static int getTotalWaysToChangeCoin(int amount, int[] denomination, int n) {
		if (amount == 0) {
			return 1;
		}
		if (n == 0) {
			return 0;
		}
		if (amount < denomination[n - 1]) {
			return getTotalWaysToChangeCoin(amount, denomination, n - 1);
		}
		return getTotalWaysToChangeCoin(amount, denomination, n - 1) +
				getTotalWaysToChangeCoin(amount - denomination[n - 1], denomination, n);
	}

	private static int getTotalWaysDP(int amount, int[] denomination, int n) {
		int[][] table = new int[amount + 1][n + 1];
		for(int i = 0; i <= n; i++) {
			table[0][i] = 1; // Very important
		}
		for (int i = 0; i <= amount; i++) {
			table[i][0] = 0;
		}
		for (int i = 1; i <= amount; i++) {
			for (int j = 1; j <= n; j++) {
				if (denomination[j - 1] > i) {
					table[i][j] = table[i][j - 1];
				} else {
					table[i][j] = table[i][j - 1] + table[i - denomination[j - 1]][j];
				}
			}
		}
//		ArrayUtility.printMatrix(table);
		return table[amount][n];
	}
}
