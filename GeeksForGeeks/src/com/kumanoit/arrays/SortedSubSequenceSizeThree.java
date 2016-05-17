/**
 * Find a sorted subsequence of size 3 in linear time
Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and 
i < j < k in 0(n) time. If there are multiple such triplets, then print any one of them.

Examples:

Input:  arr[] = {12, 11, 10, 5, 6, 2, 30}
Output: 5, 6, 30

Input:  arr[] = {1, 2, 3, 4}
Output: 1, 2, 3 OR 1, 2, 4 OR 2, 3, 4

Input:  arr[] = {4, 3, 2, 1}
Output: No such triplet
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 21, 2015
 * SortedSubSequenceSizeThree.java
 */
public class SortedSubSequenceSizeThree {

	public static void main(String[] args) {
		int arr[] = {4, 3, 2, 1};
		getSortedSubSequenceSizeThree(arr);
	}

	private static void getSortedSubSequenceSizeThree(int[] array) {
		if (array.length < 3) {
			return;
		}
		int[] left = new int[array.length];
		int[] right = new int[array.length];

		left[0] = -1;
		int min = array[0];
		for (int index = 1; index < array.length; index++) {
			left[index] = min;
			min = Math.min(min, array[index]);
		}

		right[array.length - 1] = -1;
		int max = array[array.length - 1];
		for (int index = array.length - 2; index >= 0; index--) {
			right[index] = max;
			max = Math.max(max, array[index]);
		}

		for (int index = 1; index < array.length - 1; index++) {
			if (left[index] < array[index] && array[index] < right[index]) {
				System.out.println(left[index] + "\t" + array[index] + "\t" + right[index]);
			}
		}
	}
}
