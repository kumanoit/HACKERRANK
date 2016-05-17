/**
 * http://www.geeksforgeeks.org/find-number-zeroes/
 * Find the number of zeroes
Given an array of 1s and 0s which has all 1s first followed by all 0s. Find the number of 0s. Count the number of zeroes in the given array.

Examples:

Input: arr[] = {1, 1, 1, 1, 0, 0}
Output: 2

Input: arr[] = {1, 0, 0, 0, 0}
Output: 4

Input: arr[] = {0, 0, 0}
Output: 3

Input: arr[] = {1, 1, 1, 1}
Output: 0
 */
package com.kumanoit.arrays;

public class NumberOfZeros {

	public static void main(String[] args) {
		int arr[] = {0,0,0,0};
		System.out.println(getNumberOfZeros(arr));
	}

	private static int getNumberOfZeros(int[] array) {
		int firstZeroIndex = getFirstZeroIndex(array, 0, array.length - 1);
		if (firstZeroIndex == -1) {
			System.out.println("No zero found");
			return -1;
		}
		return array.length - firstZeroIndex;
	}

	private static int getFirstZeroIndex(int[] array, int beg, int end) {
		if (beg > end) {
			return -1;
		}
		int mid = beg + (end - beg) / 2;
		if (end == array.length - 1 && array[end] == 1) {
			return -1; // all are ones
		}
		if (array[mid] == 0) {
			if (mid == 0) {
				return mid;
			}
			if (mid > 0 && array[mid - 1] == 1) {
				return mid;
			}
			return getFirstZeroIndex(array, beg, mid - 1);
		}
		return getFirstZeroIndex(array, mid + 1, end);
	}
}
