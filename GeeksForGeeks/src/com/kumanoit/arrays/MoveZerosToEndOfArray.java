/**
 * Move all zeroes to end of array
Given an array of random numbers, Push all the zero’s of a given array to the end of the array.
 For example, if the given arrays is {1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0}, it should be changed to 
 {1, 9, 8, 4, 2, 7, 6, 0, 0, 0, 0}.
 The order of all other elements should be same. Expected time complexity is O(n) and extra space is O(1).
 */
package com.kumanoit.arrays;

import com.kumanoit.common.CommonUtils;
import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 20, 2015
 * MoveZerosToEndOfArray.java
 */
public class MoveZerosToEndOfArray {

	public static void main(String[] args) {
		int[] array = {0, 0, 0};
		ArrayUtility.printArray(array);
		move(array);
		ArrayUtility.printArray(array);
	}

	private static void move(int[] array) {
		int end = 0;
		int zeroIndex = -1;
		while(end < array.length && array[end] != 0) {
			end++;
		}
		zeroIndex = end++;
		while (end < array.length) {
			if (array[end] != 0) {
				CommonUtils.swapNumbers(array, end, zeroIndex);
				zeroIndex++;
			}
			end++;
		}
	}
}
