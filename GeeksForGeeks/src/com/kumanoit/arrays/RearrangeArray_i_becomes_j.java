
/**
 * Given an array of size n where all elements are in range from 0 to n-1,
 *  change contents of arr[] so that arr[i] = j is changed to arr[j] = i.

Examples:

Example 1:
Input: arr[]  = {1, 3, 0, 2};
Output: arr[] = {2, 0, 3, 1};
Explanation for the above output.
Since arr[0] is 1, arr[1] is changed to 0
Since arr[1] is 3, arr[3] is changed to 1
Since arr[2] is 0, arr[0] is changed to 2
Since arr[3] is 2, arr[2] is changed to 3

Example 2:
Input: arr[]  = {2, 0, 1, 4, 5, 3};
Output: arr[] = {1, 2, 0, 5, 3, 4};

Example 3:
Input: arr[]  = {0, 1, 2, 3};
Output: arr[] = {0, 1, 2, 3};

Example 4:
Input: arr[]  = {3, 2, 1, 0};
Output: arr[] = {3, 2, 1, 0};
 */
package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 19, 2015
 * RearrangeArray_i_becomes_j.java
 */
public class RearrangeArray_i_becomes_j {

	public static void main(String[] args) {
		int arr[] = {1, 3, 0, 2};
		getSolutionMultipleSolution(arr);
	}

	private static void getSolutionMultipleSolution(int[] arr) {
		for(int index = 0; index < arr.length; index++) {
			arr[index]++;
		}
		ArrayUtility.printArray(arr);
		getMultipleCycleSolution(arr, 1);
		ArrayUtility.printArray(arr);
		for (int index = 0; index < arr.length; index++) {
			if(arr[index] < 0) {
				getMultipleCycleSolution(arr, -arr[index]);
			}
		}
		ArrayUtility.printArray(arr);
		for(int index = 0; index < arr.length; index++) {
			arr[index] = Math.abs((arr[index] + 1));
		}
		ArrayUtility.printArray(arr);
	}

	private static void getMultipleCycleSolution(int[] arr, int start) {
		int i = start;
		do {
			int j = arr[i - 1];
			int nextIndex = arr[j - 1];
			arr[j - 1] = -i;
			i = nextIndex;
		} while (i != start);
	}
	/**
	 * when there is a single cycle
	 * @param arr
	 * @param start
	 */
	private static void getSolution(int[] arr, int start) {
		int i = start;
		do {
			int j = arr[i];
			int nextIndex = arr[j];
			arr[j] = i;
			i = nextIndex;
		} while (i != start);
		ArrayUtility.printArray(arr);
	}
}
