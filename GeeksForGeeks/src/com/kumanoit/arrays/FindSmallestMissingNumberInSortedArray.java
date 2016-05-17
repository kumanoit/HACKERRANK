/**
 * Find the smallest missing number
Given a sorted array of n integers where each integer is in the range from 0 to m-1 and m > n. Find the smallest number that is missing from the array.

Examples
Input: {4, 5, 10, 11}, n = 4, m = 12
Output: 0

Input: {0, 1, 2, 3}, n = 4, m = 5
Output: 4

Input: {0, 1, 2, 3, 4, 5, 6, 7, 10}, n = 9, m = 11
Output: 8

Input: {0, 1, 2, 6, 9}, n = 5, m = 10
Output: 3
 */

package com.kumanoit.arrays;

public class FindSmallestMissingNumberInSortedArray {

	public static void main(String[] args) {
		int[][] array = {
				{4, 5, 10, 11},
				{0, 1, 2, 3},
				{0, 1, 2, 3, 4, 5, 6, 7, 10},
				{0, 1, 2, 6, 9},
				{4, 3, 2, 1}
		};
		for (int[] arr : array) {
			callMain(arr);
		}
	}

	private static void callMain(int[] array) {
		findMissinNumber(array);
	}

	private static void findMissinNumber(int[] array) {
		System.out.println(getMissingNumber(array, 0, array.length - 1));
	}

	private static int getMissingNumber(int[] arr, int low, int high) {
		if ( low > high || arr[low] != low) {
			return low;
		}
		int mid = low + (high - low) / 2;
		if (arr[mid] > mid) {
			return getMissingNumber(arr, low, mid - 1);
		}
		return getMissingNumber(arr, mid + 1, high);
	}
}
