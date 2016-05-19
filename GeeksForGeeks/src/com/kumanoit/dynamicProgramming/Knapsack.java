package com.kumanoit.dynamicProgramming;

public class Knapsack {

	public static void main(String[] args) {
		int maxLimit = 55;
		int price[] = {1000, 460, 1300, 1585};
		int weight[] = {5, 25, 30, 55};
		System.out.println("Recursion : " + maximumProfitRecursion(price, weight, maxLimit, price.length));
		System.out.println("DP : " + maximumProfitDP(price, weight, maxLimit));
	}

	private static int maximumProfitRecursion(int[] price, int[] weight, int maxWeightLimit, int n) {
		if (n == 0 || maxWeightLimit == 0) {
			return 0;
		}
		if (weight[n - 1] > maxWeightLimit) {
			return maximumProfitRecursion(price, weight, maxWeightLimit, n - 1);
		}
		return Math.max(
				maximumProfitRecursion(price, weight, maxWeightLimit, n - 1), 
				price[n - 1] + maximumProfitRecursion(price, weight, maxWeightLimit - weight[n - 1], n - 1));
	}

	private static int maximumProfitDP(int[] price, int[] weight, int maxWeightLimit) {
		int[][] map = new int[maxWeightLimit + 1][price.length + 1];
		for (int i = 1; i <= maxWeightLimit; i++) {
			for (int j = 1; j <= price.length; j++) {
				if (i < weight[j - 1]) {
					map[i][j] = map[i][j - 1];
				} else {
					map[i][j] = Math.max(
									map[i][j - 1],
									price[j - 1] + map[i - weight[j - 1]][j - 1]
								);
				}
			}
		}
		return map[maxWeightLimit][price.length];
	}
}
