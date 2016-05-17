/**
 * Write a program to reverse an array or string
 */
package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

public class ReverseAnArray {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4};
		ArrayUtility.printArray(arr);
		reverseArray(arr);
		ArrayUtility.printArray(arr);
	}

	private static void reverseArray(int[] array) {
		for (int i = 0, j = array.length - 1; i < j; i++, j--) {
			int temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
	}
}
