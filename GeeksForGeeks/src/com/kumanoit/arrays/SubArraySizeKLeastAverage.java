/**
 * Input:  arr[] = {3, 7, 90, 20, 10, 50, 40}, k = 3
Output: Subarray between indexes 3 and 5
The subarray {20, 10, 50} has the least average 
among all subarrays of size 3.

Input:  arr[] = {3, 7, 5, 20, -10, 0, 12}, k = 2
Output: Subarray between [4, 5] has minimum average
 */
package com.kumanoit.arrays;

public class SubArraySizeKLeastAverage {

	
	public static void main(String[] args) {
		int[] arr = {3, 7, 90, 20, 10, 50, 40};
		int k = 3;
		getAverage(arr, k);
	}

	private static double getAverage(int[] arr, int k) {
		long sum = 0;
		long minSum;
		int begIndex = 0;
		int endIndex = k - 1;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		minSum = sum;
		int beg = 0;
		int last = k;
		while (last < arr.length) {
			long newSum = sum + arr[last] - arr[beg];
			if (minSum > newSum) {
				minSum = newSum;
				begIndex = beg + 1;
				endIndex = last;
			}
			last++;
			beg++;
		}
		System.out.println("Starting index : " + begIndex);
		System.out.println("Ending index :   " + endIndex);
		return (double) minSum / k;
	}
}
