/**
 * Given an array arr[] of size n where every element is in range from 0 to n-1. Rearrange the given array so that arr[i] becomes arr[arr[i]]. This should be done with O(1) extra space.

Examples:

Input: arr[]  = {3, 2, 0, 1}
Output: arr[] = {1, 0, 3, 2}

Input: arr[] = {4, 0, 2, 1, 3}
Output: arr[] = {3, 4, 2, 0, 1}

Input: arr[] = {0, 1, 2, 3}
Output: arr[] = {0, 1, 2, 3}
If the extra space condition is removed, the question becomes very easy. The main part of the question is to do it without extra space.

The credit for following solution goes to Ganesh Ram Sundaram . Following are the steps.

1) Increase every array element arr[i] by (arr[arr[i]] % n)*n.
2) Divide every element by n.

Let us understand the above steps by an example array {3, 2, 0, 1}
In first step, every value is incremented by (arr[arr[i]] % n)*n
After first step array becomes {7, 2, 12, 9}. 
The important thing is, after the increment operation
of first step, every element holds both old values and new values. 
Old value can be obtained by arr[i]%n and new value can be obtained
by arr[i]/n.

In second step, all elements are updated to new or output values 
by doing arr[i] = arr[i]/n.
After second step, array becomes {1, 0, 3, 2}
 */
package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 20, 2015
 * RearrangeArr_i_becomesArr_Arr_i.java
 */

public class RearrangeArr_i_becomesArr_Arr_i {

	public static void main(String[] args) {
		int arr[]  = {2, 3, 0, 1};
		convert(arr);
	}

	private static void convert(int[] arr) {
		ArrayUtility.printArray(arr);
		int n = arr.length;
		for (int index = 0; index < arr.length; index++) {
			arr[index] += (arr[arr[index]] % n) * n;
		}
		for (int index = 0; index < arr.length; index++) {
			arr[index] = arr[index] / n;
		}
		ArrayUtility.printArray(arr);
	}
}
