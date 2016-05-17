/**
 * Maximum Product Subarray
Given an array that contains both positive and negative integers, find the product of the maximum product subarray. Expected Time complexity is O(n) and only O(1) extra space can be used.

Examples:

Input: arr[] = {6, -3, -10, 0, 2}
Output:   180  // The subarray is {6, -3, -10}

Input: arr[] = {-1, -3, -10, 0, 60}
Output:   60  // The subarray is {60}

Input: arr[] = {-2, -3, 0, -2, -40}
Output:   80  // The subarray is {-2, -40}
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 20, 2015
 * MaximumProductSubArray.java
 */
public class MaximumProductSubArray {

	public static void main(String[] args) {
		int[] arr = {6, -3, 10, 0, 2};
		System.out.println(getMaximumProduct(arr));
	}

	private static int getMaximumProduct(int[] arr) {
		int maxProd= 0;
		int maxNegativeProd = 1;
		int maxPositiveProd = 1;
		int zeroCount = 0;
		for (int index = 0; index < arr.length; index++) {
			zeroCount = (arr[index] == 0) ? zeroCount + 1 : zeroCount;
			if (arr[index] > 0) {
				maxPositiveProd *= arr[index];
				maxNegativeProd *= arr[index];
			} else if (arr[index] < 0) {
				int temp = maxPositiveProd;
				maxPositiveProd = Math.max(maxNegativeProd * arr[index], 1);
				maxNegativeProd = temp * arr[index];
			} else {
				maxNegativeProd = maxPositiveProd = 1;
			}
			maxProd = Math.max(maxPositiveProd, maxProd);
		}
		if (zeroCount == arr.length) {
			return 0;
		}
		return maxProd;
	}
}
