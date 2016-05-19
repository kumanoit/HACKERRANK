package com.kumanoit.dynamicProgramming;

public class MaxProductOnDividingARod {

	public static void main(String[] args) {
		int length = 9;
		System.out.println("By DP = " + getMaximumProductDP(length));
		System.out.println("By recursion = " + getMaxProductRecursive(length));
	}

	private static int getMaxProductRecursive(int length) {
		if (length <= 1) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		int maxProd = 0;
		for (int i = 1; i <= length / 2; i++) {
			maxProd = Math.max(
						Math.max(maxProd, i * getMaxProductRecursive(length - i)),
						i * (length - i)
					);
		}
		return maxProd;
	}

	private static int getMaximumProductDP(int length) {
		int[] maxProd = new int[length + 1];
		maxProd[0] = 0;
		maxProd[1] = 0;
		for (int i = 2; i <= length; i++) {
			maxProd[i] = 0;
			for (int j = 1; j <= i/2; j++) {
				maxProd[i] = Math.max(
								Math.max(maxProd[i], j * maxProd[i - j]),
								j * (i - j)
							);
			}
		}
		return maxProd[length];
	}
}
