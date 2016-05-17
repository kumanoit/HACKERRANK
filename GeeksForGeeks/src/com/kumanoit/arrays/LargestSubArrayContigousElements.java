/**
 * Given an array of distinct integers, find length of the longest subarray which contains numbers that can be arranged in a continuous sequence.

Examples:

Input:  arr[] = {10, 12, 11};
Output: Length of the longest contiguous subarray is 3

Input:  arr[] = {14, 12, 11, 20};
Output: Length of the longest contiguous subarray is 2

Input:  arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
Output: Length of the longest contiguous subarray is 5
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 19, 2015
 * LargestSubArrayContigousElements.java
 */
public class LargestSubArrayContigousElements {

	public static void main(String[] args) {
		int arr[] = {1, 56, 58, 57, 90, 92, 94, 93, 91, 45};
		getLength(arr);
	}

	private static void getLength(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int maxLength = -1;
		int BEG = -1;
		int END = -1;
		for (int i = 0; i < arr.length - 1; i++) {
			min = max = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);
				if (j - i == max - min && maxLength < (j - i + 1)) {
					maxLength = j - i + 1;
					BEG = i;
					END = j;
				}
			}
		}
		System.out.println("Maxlength is = " + maxLength);
		for (int index = BEG; index <= END; index++) {
			System.out.print(arr[index] + "\t");
		}
	}
}
