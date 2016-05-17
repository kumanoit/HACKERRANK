/**
 * Count frequencies of all elements in array in O(1) extra space and O(n) time
Given an unsorted array of n integers which can contain integers from 1 to n. Some elements can be repeated multiple times and some other elements can be absent from the array. Count frequency of all elements that are present and print the missing elements.

Examples:

Input: arr[] = {2, 3, 3, 2, 5}
Output: Below are frequencies of all elements
        1 -> 0
        2 -> 2
        3 -> 2
        4 -> 0
        5 -> 1

Input: arr[] = {4, 4, 4, 4}
Output: Below are frequencies of all elements
        1 -> 0
        2 -> 0
        3 -> 0
        4 -> 4
 */
package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 18, 2015
 * CountFrequencyOfAllElement.java
 */
public class CountFrequencyOfAllElement {

	public static void main(String[] args) {
		int arr[] = {2, 3, 3, 2, 5};
		getFrequencyOfAllElement(arr, arr.length);
	}

	private static void getFrequencyOfAllElement(int[] array, int n) {
		ArrayUtility.printArray(array);
		for(int i = 0; i < n; i++) {
			array[i]--;
		}
		ArrayUtility.printArray(array);
		for(int i = 0; i < array.length; i++) {
			array[array[i] % n] = array[array[i] % n] + n;
		}
		ArrayUtility.printArray(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println((i + 1) + " -> " + array[i]/n);
			array[i] = array[i] % n + 1;
		}
		ArrayUtility.printArray(array);
	}
}
