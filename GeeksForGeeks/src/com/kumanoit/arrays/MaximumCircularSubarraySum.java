/**
 * Given n numbers (both +ve and -ve), arranged in a circle, fnd the maximum sum of consecutive number.

Examples:

Input: a[] = {8, -8, 9, -9, 10, -11, 12}
Output: 22 (12 + 8 - 8 + 9 - 9 + 10)

Input: a[] = {10, -3, -4, 7, 6, 5, -4, -1} 
Output:  23 (7 + 6 + 5 - 4 -1 + 10) 

Input: a[] = {-1, 40, -14, 7, 6, 5, -4, -1}
Output: 52 (7 + 6 + 5 - 4 - 1 - 1 + 40)
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 20, 2015
 * MaximumCircularSubarraySum.java
 */
public class MaximumCircularSubarraySum {

	public static void main(String[] args) {
		int[] array = {-1, 40, -14, 7, 6, 5, -4, -1};
		System.out.println(getMaximumSum(array));
	}

	private static int getMaximumSum(int[] array) {
		int totalSum = 0;
		int sumA = LargestSumContiguousSubArray.getLargestSum(array);
		for (int index = 0; index < array.length; index++) {
			totalSum += array[index];
			array[index] *= -1;
		}
		int sumB = LargestSumContiguousSubArray.getLargestSum(array);
		return Math.max(sumA, totalSum + sumB);
	}

	
}
