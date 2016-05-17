/**
 * Rearrange array in alternating positive & negative items with O(1) extra space
Given an array of positive and negative numbers, arrange them in an alternate fashion such that every positive number is followed by negative and vice-versa maintaining the order of appearance.
Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array. If there are more negative numbers, they too appear in the end of the array.

Example:

Input:  arr[] = {1, 2, 3, -4, -1, 4}
Output: arr[] = {-4, 1, -1, 2, 3, 4}

Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0} 
This question has been asked at many places (See this and this)

The above problem can be easily solved if O(n) extra space is allowed. It becomes interesting due to the limitations that O(1) extra space and order of appearances.
The idea is to process array from left to right. While processing, find the first out of place element in the remaining unprocessed array. An element is out of place if it is negative and at odd index, or it is positive and at even index. Once we find an out of place element, we find the first element after it with opposite sign. We right rotate the subarray between these two elements (including these two).
 */
package com.kumanoit.arrays;

import java.util.Arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 19, 2015
 * RearrangeNegativePostitiveAlternately.java
 */
public class RearrangeNegativePostitiveAlternately {

	public static void main(String[] args) {
		int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8};
		int arr1[] = Arrays.copyOf(arr, arr.length);
		ArrayUtility.printArray(arr);
		segregatePositiveNegativeNumber(arr);
		ArrayUtility.printArray(arr);
		System.out.println("\n\nAnother approach");
		ArrayUtility.printArray(arr1);
		rearrange(arr1);
		ArrayUtility.printArray(arr1);
	}

	private static void rearrange(int[] arr) {
		int wi = -1;
		for (int index = 0; index < arr.length; index++) {
			if (wi == -1) {
				if (((index & 1) == 0 && arr[index] >= 0) ||
					((index & 1) == 1 && arr[index] < 0))	{
					wi = index;
				}
			} else {
				if ((arr[wi] < 0 && arr[index] >=0) ||
					(arr[wi] >= 0 && arr[index] < 0)) {
					rotateRight(arr, wi, index);
					if (index - wi >= 2) {
						wi = wi + 2;
					} else {
						wi = -1;
					}
				}
			}
		}
	}

	private static void rotateRight(int[] array, int start, int end) {
		int temp = array[end];
		if (start == end) {
			return;
		}
		for(int i = end; i > start; i--) {
			array[i] = array[i - 1];
		}
		array[start] = temp;
	}

	private static void segregatePositiveNegativeNumber(int[] array) {
		int end = array.length - 1;
		int start = 0;
		while (start < end) {
			while (array[start] < 0) {
				start++;
			}
			while (array[end] >= 0) {
				end--;
			}
			if (start < end) {
				int temp = array[start];
				array[start] = array[end];
				array[end] = temp;
				start++;
				end--;
			}
		}
		ArrayUtility.printArray(array);
		start = 1;
		end++;
		while (end < array.length && array[start] < 0) {
			int temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start += 2;
			end++;
		}
	}
}
