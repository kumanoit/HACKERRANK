/**
 * Given an array containing only 0s and 1s, find the largest subarray which contain equal no of 0s and 1s. Expected time complexity is O(n).

Examples:

Input: arr[] = {1, 0, 1, 1, 1, 0, 0}
Output: 1 to 6 (Starting and Ending indexes of output subarray)

Input: arr[] = {1, 1, 1, 1}
Output: No such subarray

Input: arr[] = {0, 0, 1, 1, 0}
Output: 0 to 3 Or 1 to 4
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 21, 2015
 * LargestSubArrayWithEqualNumberOfOneAndZero.java
 */
public class LargestSubArrayWithEqualNumberOfOneAndZero {

	public static void main(String[] args) {
		int[] arr = {1, 1, 1, 1};
		System.out.println(getLargestSubArray(arr));
	}

	private static long getLargestSubArray(int[] array) {
		int maxLength = -1;
		int[] sumArray = new int[array.length];
		int max = -array.length - 1;
		int min = array.length + 1;
		int START = -1;
		int END = -1;
		for(int i = 0; i < array.length; i++) {
			array[i] = (array[i] == 0) ? -1 : 1;
		}
		min = max = sumArray[0] = array[0];
		for (int i = 1; i < array.length; i++) {
			sumArray[i] = sumArray[i - 1] + array[i];
			max = Math.max(max, sumArray[i]);
			min = Math.min(min, sumArray[i]);
		}
		int[] hash = new int[max - min + 1];
		for (int i = 0; i < hash.length; i++) {
			hash[i] = -1;
		}
		for(int i = 0; i < sumArray.length; i++) {
			if (hash[sumArray[i] - min] == -1) {
				hash[sumArray[i] - min] = i;
			} else {
				if (i - hash[sumArray[i] - min] > maxLength) {
					maxLength = i - hash[sumArray[i] - min];
					START = hash[sumArray[i] - min] + 1;
					END = i;
				}
			}
		}
		System.out.println("START = " + START +"\tEND = " + END);
		for (int i = START; i <= END && maxLength != -1; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		return maxLength;
	}
}
