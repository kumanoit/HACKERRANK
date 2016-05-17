/**
Given an array arr[], find the maximum j – i such that arr[j] > arr[i].

Examples:

  Input: {34, 8, 10, 3, 2, 80, 30, 33, 1}
  Output: 6  (j = 7, i = 1)

  Input: {9, 2, 3, 4, 5, 6, 7, 8, 18, 0}
  Output: 8 ( j = 8, i = 0)

  Input:  {1, 2, 3, 4, 5, 6}
  Output: 5  (j = 5, i = 0)

  Input:  {6, 5, 4, 3, 2, 1}
  Output: -1 
 */
package com.kumanoit.arrays;

public class MaximiseJMinusISuchThatArrJgtArrI {

	public static void main(String[] args) {
		int[][] array = {
				{34, 8, 10, 3, 2, 80, 30, 33, 1},
				{9, 2, 3, 4, 5, 6, 7, 8, 18, 0},
				{1, 2, 3, 4, 5, 6},
				{6, 5, 4, 3, 2, 1}};
		for (int[] arr : array) {
			callMain(arr);
		}
	}
	private static void callMain(int[] array) {
		getMaximum(array);
	}

	private static void getMaximum(int[] array) {
		if (array.length <= 2) {
			return;
		}
		int I = -1;
		int J = -1;
		int[] left = new int[array.length];
		int[] right = new int[array.length];
		int maxLength = -1;

		left[0] = array[0];
		for (int i = 1; i < array.length; i++) {
//			left[i] = (array[i] < array[left[i - 1]]) ? i : left[i - 1];
			left[i] = Math.min(array[i], left[i - 1]);
		}

		right[array.length - 1] = array[array.length- 1];
		for (int i = array.length - 2; i >= 0; i--) {
//			right[i] = (array[i] > array[right[i + 1]]) ? i : right[i + 1];
			right[i] = Math.max(array[i], right[i + 1]);
		}

		int i = 0;
		int j = 0;
		while (i < array.length && j < array.length) {
			if (i > j) {
				break;
			}
			if (left[i] < right[j]) {
				if(maxLength < j - i) {
					maxLength = j - i;
					I = i;
					J = j;
				}
				j++;
			} else {
				i++;
			}
		}
		System.out.println("Minimum j - i, (" + J + " - " + I + ") " + maxLength);
		
	}
}
