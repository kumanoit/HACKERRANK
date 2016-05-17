/**
 * http://www.geeksforgeeks.org/find-minimum-difference-pair/
 * Find minimum difference between any two elements
Given an unsorted array, find the minimum difference between any pair in given array.

Examples :

Input  : {1, 5, 3, 19, 18, 25};
Output : 1
Minimum difference is between 18 and 19

Input  : {30, 5, 20, 9};
Output : 4
Minimum difference is between 5 and 9

Input  : {1, 19, -4, 31, 38, 25, 100};
Output : 5
Minimum difference is between 1 and -4
 */
package com.kumanoit.arrays;

import java.util.Arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

public class MinimumDifferenceBetweenTwoNumbers {

	public static void main(String[] args) {
		int arr[] =  {1, 19, -4, 31, 38, 25, 100};
		System.out.println("\nMinimum difference is = " + getMinimumDiffernce(arr));
	}

	private static int getMinimumDiffernce(int[] array) {
		int minDifference = Integer.MAX_VALUE;
		ArrayUtility.printArray(array);
		Arrays.sort(array);
		ArrayUtility.printArray(array);
		for (int index = 0; index < array.length - 1; index++) {
			minDifference = Math.min(minDifference, Math.abs(array[index] - array[index + 1]));
		}
		return minDifference;
	}
}
