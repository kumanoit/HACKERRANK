/**
 * Check if array elements are consecutive | Added Method 3
Given an unsorted array of numbers, write a function that returns true if array 
consists of consecutive numbers.

Examples:
a) If array is {5, 2, 3, 1, 4}, then the function should return true because the 
array has consecutive numbers from 1 to 5.

b) If array is {83, 78, 80, 81, 79, 82}, then the function should return true 
because the array has consecutive numbers from 78 to 83.

c) If the array is {34, 23, 52, 12, 3 }, then the function should return false 
because the elements are not consecutive.

d) If the array is {7, 6, 5, 5, 3, 4}, then the function should return false 
because 5 and 5 are not consecutive.


 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 21, 2015
 * CheckArrayElementsToBeConsecutive.java
 */
public class CheckArrayElementsToBeConsecutive {

	public static void main(String[] args) {
		int[][] array = {
				{5, 2, 3, 1, 4},
				{83, 78, 80, 81, 79, 82},
				{34, 23, 52, 12, 3},
				{7, 6, 5, 5, 3, 4}
		};
		for (int[] arr : array) {
			callMain(arr);
		}
	}

	private static void callMain(int[] array) {
		System.out.println(checkArrayElementsToBeConsecutive(array));
	}

	private static boolean checkArrayElementsToBeConsecutive(int[] arr) {
		int min = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			min = Math.min(arr[i], min);
			max = Math.max(arr[i], max);
		}
		if (max - min + 1 != arr.length) {
			return false;
		}
		for (int i = 0; i < arr.length; i++) {
			int j;
			if (arr[i] < 0) {
				j = -arr[i] - min;
			} else {
				j = arr[i] - min;
			}

			if (arr[j] < 0) {
				return false;
			} else {
				arr[j] = -arr[j];
			}
		}
		return true;
	}
}
