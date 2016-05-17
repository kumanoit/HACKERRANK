/**
 * Given an array of 1s and 0s which has all 1s first followed by all 0s. Find the number of 0s. Count the number of zeroes in the given array.

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

/**
 * @author kumanoit Dec 20, 2015
 * CountNumberOfZeros.java
 */
public class CountNumberOfZeros {

	public static void main(String[] args) {
		int arr[] = {1, 0, 0, 0, 0};
		System.out.println(countNumberOfZeros(arr));
	}

	private static int countNumberOfZeros(int[] array) {
		return array.length - getFirstLocationOfZero(array, 0, array.length - 1);
	}

	private static int getFirstLocationOfZero(int[] array, int beg, int end) {
		int mid = beg + (end - beg) / 2;
		if (array[mid] == 0) {
			if (mid == 0 || (mid > 0 && array[mid - 1] == 1)) {
				return mid;
			} else {
				return getFirstLocationOfZero(array, beg, mid - 1);
			}
		} else {
			if (mid == array.length - 1) {
				return array.length;
			}
			return getFirstLocationOfZero(array, mid + 1, end);
		}
	}
}
