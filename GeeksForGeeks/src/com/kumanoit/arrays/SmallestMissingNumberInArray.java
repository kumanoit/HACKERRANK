/**
 * Find the smallest positive number missing from an unsorted array
You are given an unsorted array with both positive and negative elements.
You have to find the smallest positive number missing from the array in O(n)
time using constant extra space. You can modify the original array.

Examples

 Input:  {2, 3, 7, 6, 8, -1, -10, 15}
 Output: 1

 Input:  {2, 3, -7, 6, 8, 1, -10, 15 }
 Output: 4

 Input: {1, 1, 0, -1, -2}
 Output: 2 
 */
package com.kumanoit.arrays;

import java.util.Arrays;

public class SmallestMissingNumberInArray {

	public static void main(String[] args) {
		int[][] array =  {
				{2, 3, -7, 6, 8, 1, -10, 15},
				{2, 3, 7, 6, 8, -1, -10, 15},
				{1, 1, 0, -1, -2}
				};
		for (int[] subArray : array) {
			callAll(subArray);
		}
	}

	private static void callAll(int[] array) {
		getSmallestMissingNumber(array);
		getSmallest2(array);
		getSmallestNumber3(array);
		System.out.println();
	}

	/**
	 * NAIVE APPROACH O(n^2)
	 * @param array
	 */
	private static void getSmallestMissingNumber(int[] array) {
		for(int index = 1; index <= array.length; index++) {
			int j = 0;
			for (j = 0; j < array.length; j++) {
				if (array[j] == index) {
					break;
				}
			}
			if (j == array.length) {
				System.out.println("1. (O(n^2)) Smallest Missing Number = "
					+ index);
				break;
			}
		}
	}

	/**
	 * Sort then match index with the value at that index
	 * O(nlgn)
	 */
	private static void getSmallest2(int[] array) {
		int[] newArray = Arrays.copyOf(array, array.length);
		Arrays.sort(newArray);
		int i = 0;
		while(newArray[i] < 0) {
			i++;
		}
		for (int index = i; index < newArray.length; index++) {
			if (newArray[index] != (index + 1 - i)) {
				System.out.println("2. O(nlgn) Smallest missing number = " + (index + 1 -i));
				break;
			}
		}
	}

	/**
	 * O(n)
	 */

	private static void getSmallestNumber3(int[] array) {
		int[] newArray = Arrays.copyOf(array, array.length);
		int firstNegativeIndex = seggregate(newArray);
		for(int i = 0; i < firstNegativeIndex; i++) {
			int j = Math.abs(newArray[i]);
			if (j < firstNegativeIndex) {
				newArray[j - 1] *= -1;
			}
		}
		for(int index = 0; index < firstNegativeIndex; index++) {
			if (newArray[index] > 0) {
				System.out.println("3.Smallest missing number = " + (index+1));
				break;
			}
		}
	}

	private static int seggregate(int[] array) {
		int start = 0;
		int end = 0;
		while(start < array.length && array[start] > 0) {
			start++;
		}
		end = start + 1;
		while(end < array.length) {
			if (array[end] > 0 && start != end) {
				int tmp = array[start];
				array[start] = array[end];
				array[end] = tmp;
				start++;
			}
			end++;
		}
		return start;
	}
}
