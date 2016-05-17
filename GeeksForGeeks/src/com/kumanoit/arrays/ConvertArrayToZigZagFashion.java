/**
 * Example: 
Input:  arr[] = {4, 3, 7, 8, 6, 2, 1}
Output: arr[] = {3, 7, 4, 8, 2, 6, 1}

Input:  arr[] =  {1, 4, 3, 2}
Output: arr[] =  {1, 4, 2, 3}
 */
package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 18, 2015
 * ConvertArrayToZigZagFashion.java
 */
public class ConvertArrayToZigZagFashion {

	public static void main(String[] args) {
		int arr[] = {4, 3, 7, 8, 6, 2, 1};
		getZigZagArray(arr);
		int brr[] = {1, 4, 3, 2};
		getZigZagArray(brr);
	}

	private static void getZigZagArray(int[] arr) {
		boolean flag = true;
		ArrayUtility.printArray(arr);
		for (int index = 0; index < arr.length - 1; index++) {
			if (flag) { //"<"
				if (arr[index] > arr[index + 1]) {
					int temp = arr[index];
					arr[index] = arr[index + 1];
					arr[index + 1] = temp;
				}
			} else { //">"
				if (arr[index] < arr[index + 1]) {
					int temp = arr[index];
					arr[index] = arr[index + 1];
					arr[index + 1] = temp;
				}
			}
			flag = !flag;
		}
		ArrayUtility.printArray(arr);
	}
}
