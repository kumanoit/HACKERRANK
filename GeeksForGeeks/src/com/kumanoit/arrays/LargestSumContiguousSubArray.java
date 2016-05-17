/**
 * Largest Sum Contiguous Subarray
Write an efficient C program to find the sum of contiguous subarray within a
 one-dimensional array of numbers which has the largest sum.

Kadane’s Algorithm:

Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 20, 2015
 * LargestSumContiguousSubArray.java
 */
public class LargestSumContiguousSubArray {

	public static void main(String[] args) {
		int[] array = {-2, -3, 4, -1, -2, 1, 5, -3};
		System.out.println(getLargestSum(array));
	}

	public static int getLargestSum(int[] array) {
		int maximumSum = 0;
		int maxSoFar = 0;
		for (int i = 0; i < array.length; i++) {
			maxSoFar += array[i];
			if (maxSoFar < 0) {
				maxSoFar = 0;
			}
			if (maxSoFar > maximumSum) {
				maximumSum = maxSoFar;
			}
		}
		return maximumSum;
	}
}

