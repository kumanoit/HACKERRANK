package com.kumanoit.dynamicProgramming;

public class OptimalGameStrategy {

	public static void main(String[] args) {
		int[] arr = {8, 64, 23, 5, 21, 46, 95, 2, 4};
		System.out.println("DP : " + getMaxValueDP(arr));
		System.out.println("My DP : " + opGameMy(arr));
		System.out.println("Recursion : " + getMaxValueRecursion(arr, 0, arr.length - 1));
	}

	private static int getMaxValueRecursion(int[] arr, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (start + 1 == end) {
			return Math.max(arr[start], arr[end]);
		}
		return Math.max(
						arr[start] +
								Math.min(
										getMaxValueRecursion(arr, start + 2, end),
										getMaxValueRecursion(arr, start + 1, end - 1)
										),
						arr[end] +
								Math.min(
										getMaxValueRecursion(arr, start, end - 2),
										getMaxValueRecursion(arr, start + 1, end - 1)
										)
						);
	}

	private static int getMaxValueDP(int[] arr) {
		int[][] mat = new int[arr.length][arr.length];
		for(int len = 0; len < arr.length; len++) {
			for (int i = 0, j = len; j < arr.length; i++, j++) {
				int x = i + 2 < j ? mat[i + 2][j] : 0;
				int y = i + 1 < j - 1 ? mat[i + 1][j - 1] : 0;
				int z = i < j - 2 ? mat[i][j - 2] : 0;
				mat[i][j] = Math.max(
									arr[i] + Math.min(x, y),
									arr[j] + Math.min(y, z)
									);
			}
		}
		return mat[0][arr.length - 1];
	}

	private static int opGameMy(int arr[]) {
		int i, j;
		int size = arr.length;
		int[][] m = new int[size][size];
		int x, y, z, len;
		for(i=0;i<size;i++)
			m[i][i] = arr[i];
		for(i=0;i<size-1;i++)
			m[i][i+1] = Math.max(arr[i], arr[i+1]);
		
		for(len = 3; len <=size; len++)
		{
			for(i=0; i<size - len + 1; i++)
			{
				j = i + len - 1;
				x = m[i+2][j];
				y = m[i+1][j-1];
				z = m[i][j-2];
				
				m[i][j] = Math.max(arr[i] + Math.min(x,y), arr[j] + Math.min(y,z));
			}
		}
		return m[0][size-1];
	}
}
