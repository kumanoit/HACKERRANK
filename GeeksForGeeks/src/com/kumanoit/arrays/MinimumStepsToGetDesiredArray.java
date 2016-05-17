/**
 * http://www.geeksforgeeks.org/count-minimum-steps-get-given-desired-array/
 * Count minimum steps to get the given desired array
Consider an array with n elements and value of all the elements is zero. We can perform following operations on the array.

Incremental operations:Choose 1 element from the array and increment its value by 1.
Doubling operation: Double the values of all the elements of array.
 */
package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

public class MinimumStepsToGetDesiredArray {

	public static void main(String[] args) {
		int arr[] = {32, 32, 32};
		System.out.println("Minimum steps to get desired array " + getMinimumCount(arr));
	}

	static int getMinimumCount(int[] arr) {
		ArrayUtility.printArray(arr);
		int count = 0;
		int zeroCount = 0;
		for (int index = 0; index < arr.length; index++) {
			if ((arr[index] & 1) == 1) {
				count++;
				arr[index] -= 1;
			}
			arr[index] /= 2;
			if (arr[index] == 0) {
				zeroCount++;
			}
		}

		if (zeroCount == arr.length) {
			return count;
		}
		return 1 + count + getMinimumCount(arr);
	}
}