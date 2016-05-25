/**
 * Largest Sum Contiguous Subarray
Write an efficient C program to find the sum of contiguous subarray 
within a one-dimensional array of numbers which has the largest sum. 
 */
package com.kumanoit.dynamicProgramming;

public class LargestSumContiguousSubArray {

	public static void main(String[] args) {
		int arr[] =  {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(getLargestSumContiguousSubArray(arr));
		System.out.println(getLargestSumDP(arr));
	}

	/**
	 * O(n^2)
	 * @param arr
	 * @return
	 */
	private static int getLargestSumContiguousSubArray(int[] arr) {
		int maxSum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int sum = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				sum += arr[j];
				maxSum = Math.max(maxSum, sum);
			}
		}
		return maxSum;
	}

	/**
	 * O(n)
	 * @param arr
	 * @return
	 */
	private static int getLargestSumDP(int[] arr) {
		int maxSumSoFar = 0;
		int maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			maxSumSoFar += arr[i];
			if (maxSumSoFar < 0) {
				maxSumSoFar = 0;
			}
			maxSum = Math.max(maxSum, maxSumSoFar);
		}
		return maxSum;
	}
}

