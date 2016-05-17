/**
 * Given an array of size n, the array contains numbers in range from 0 to k-1 
 * where k is a positive integer and k <= n. Find the maximum repeating number 
 * in this array. For example, let k be 10 the given array be 
 * arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3}, 
 * the maximum repeating number would be 2. Expected time complexity is O(n)
 *  and extra space allowed is O(1). Modifications to array are allowed.
 */
package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 20, 2015
 * MaximumRepeatingNumberOrderNTime.java
 */
public class MaximumRepeatingNumberOrderNTime {

	public static void main(String[] args) {
		int[] array = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3};
		int k = 10;
		ArrayUtility.printArray(array);
		System.out.println(getMaximumRepeatingNumber(array, k));
		ArrayUtility.printArray(array);
	}

	private static int getMaximumRepeatingNumber(int[] array, int k) {
		int mIndex = -1;
		int maximumValue = -1;
		for (int index = 0; index < array.length; index++) {
			array[array[index] % k] += k;
		}
		for (int index = 0; index < array.length; index++) {
			if (array[index] > maximumValue) {
				maximumValue = array[index];
				mIndex = index;
			}
		}

		// restore array
		for(int index = 0; index < array.length; index++) {
			array[index] = array[index] % k;
		}
		return mIndex;
	}
}
