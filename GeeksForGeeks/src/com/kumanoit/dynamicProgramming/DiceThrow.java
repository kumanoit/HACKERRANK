/**
 * Dynamic Programming | Set 30 (Dice Throw)
 * Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X. 
 * X is the summation of values on each face when all the dice are thrown.
 */

package com.kumanoit.dynamicProgramming;

public class DiceThrow {

	public static void main(String[] args) {
		int totalDice = 3;
		int maxDiceValue = 160;
		int sum = 180;
		System.out.println("Using DP   : " + getNumberOfWaysDP(totalDice, maxDiceValue, sum));
		System.out.println("Without DP : " + getNumberOfWays(totalDice, maxDiceValue, sum));
	}

	private static int getNumberOfWays(int totalDice, int maxDiceValue, int sum) {
		if (sum == 0 && totalDice == 0) {
			return 1;
		}

		if (totalDice == 0) {
			return 0;
		}

		int totalWays = 0;
		for (int i = 1; i <= maxDiceValue; i++) {
			totalWays += getNumberOfWays(totalDice - 1, maxDiceValue, sum - i);
		}

		return totalWays;
	}

	private static int getNumberOfWaysDP(int totalDice, int maxDiceValue, int sum) {
		int[][] memo = new int[sum + 1][totalDice + 1];
		memo[0][0] = 1;

		for (int i = 1; i <= sum; i++) {
			memo[i][0] = 0;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= totalDice; j++) {
				for (int k = 1; k <= maxDiceValue && i >= k; k++) {
					memo[i][j] += memo[i - k][j - 1];
				}
			}
		}

		return memo[sum][totalDice];
	}
}
