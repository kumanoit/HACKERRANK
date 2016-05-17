/**
 * http://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
Rearrange an array in maximum minimum form
Given a sorted array of positive integers, rearrange the array alternately i.e first element should be maximum value, second minimum value, third second max, fourth second min and so on.

Examples:

Input  : arr[] = {1, 2, 3, 4, 5, 6, 7} 
Output : arr[] = {7, 1, 6, 2, 5, 3, 4}

Input  : arr[] = {1, 2, 3, 4, 5, 6} 
Output : arr[] = {6, 1, 5, 2, 4, 3}
 */
package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

public class RearrangeArrayInMaximumMinimumForm {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5, 6};
		rearrangeAlternatively(arr);	
	}

	private static void rearrangeAlternatively(int[] arr) {
		ArrayUtility.printArray(arr);
		for (int index = 0; index < arr.length; index++) {
			if (arr[index] > 0) {
				transform(arr, index, arr[index]);
			}
		}
		for (int index = 0; index < arr.length; index++) {
			arr[index] *= -1;
		}
		ArrayUtility.printArray(arr);
	}

	private static void transform(int[] arr, int index, int oldValue) {
		int nextIndex = index < arr.length / 2 ? 2 * index + 1 : 2 * (arr.length - index - 1);
		if (arr[nextIndex] < 0) {
			return;
		}
		int nextValue = arr[nextIndex];
		arr[nextIndex] = -oldValue;
		transform(arr, nextIndex, nextValue);
	}
}
