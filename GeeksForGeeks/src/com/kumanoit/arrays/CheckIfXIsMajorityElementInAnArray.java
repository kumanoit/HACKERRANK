/**
 * Check for Majority Element in a sorted array
Question: Write a C function to find if a given integer x appears more than n/2 times
in a sorted array of n integers.

Basically, we need to write a function say isMajority() that takes an array (arr[] ), 
array’s size (n) and a number to be searched (x) as parameters and returns true 
if x is a majority element (present more than n/2 times).

Examples:

Input: arr[] = {1, 2, 3, 3, 3, 3, 10}, x = 3
Output: True (x appears more than n/2 times in the given array)

Input: arr[] = {1, 1, 2, 4, 4, 4, 6, 6}, x = 4
Output: False (x doesn't appear more than n/2 times in the given array)

Input: arr[] = {1, 1, 1, 2, 2}, x = 1
Output: True (x appears more than n/2 times in the given array)
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 21, 2015
 * CheckIfXIsMajorityElementInAnArray.java
 */
public class CheckIfXIsMajorityElementInAnArray {

	public static void main(String[] args) {
		int[][] arrays = {
				{1, 2, 3, 3, 3, 3, 10},
				{1, 1, 2, 4, 4, 4, 6, 6},
				{1, 1, 1, 2, 2}
		};
		int x[] = {3, 4, 1};
		for (int index = 0; index < arrays.length; index++) {
			System.out.println(isMajority(arrays[index], x[index]));
		}
	}

	private static boolean isMajority(int[] array, int x) {
		int n = array.length;
		int leftMostIndex = binarySearch(array, 0, array.length - 1, x);
		if (leftMostIndex == -1) { // Element not found
			return false;
		}
		if (leftMostIndex + n / 2 < n && array[leftMostIndex + n / 2] == x) {
			return true;
		} else {
			return false;
		}
	}

	private static int binarySearch(int[] array, int low, int high, int x) {
		if (low > high) { // NOT found
			return -1;
		}
		int mid = low + (high - low) / 2;
		if ((mid == 0 || array[mid - 1] < x) && array[mid] == x) {
			return mid;
		} else if (array[mid] >= x) {
			return binarySearch(array, low, mid - 1, x);
		}
		return binarySearch(array, mid + 1, high, x);
	}
}
