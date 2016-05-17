/**
 * Replace every element with the greatest element on right side
Given an array of integers, replace every element with the next greatest element
 (greatest element on the right side) in the array. Since there is no element next
  to the last element, replace it with -1. 
  For example, if the array is {16, 17, 4, 3, 5, 2}, then it should be modified to {17, 5, 5, 5, 2, -1}.

The question is very similar to this post and solutions are also similar.

A naive method is to run two loops. The outer loop will one by one pick array 
elements from left to right. The inner loop will find the greatest element 
present after the picked element. Finally the outer loop will replace the picked 
element with the greatest element found by inner loop. The time complexity of this method will be O(n*n).
A tricky method is to replace all elements using one traversal of the array. 
The idea is to start from the rightmost element, move to the left side one by one, 
and keep track of the maximum element. Replace every element with the maximum element.
 */
package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 20, 2015
 * ReplaceEveryElementWithGreatestElementOnRHS.java
 */
public class ReplaceEveryElementWithGreatestElementOnRHS {

	public static void main(String[] args) {
		int[] arr = {16, 17, 4, 3, 5, 2};
		ArrayUtility.printArray(arr);
		replace(arr);
		ArrayUtility.printArray(arr);
	}

	private static void replace(int[] array) {
		int max = -1;
		for (int index = array.length - 1; index >= 0; index--) {
			if (array[index] > max) {
				int prevMax = max;
				max = array[index];
				array[index] = prevMax;
			} else {
				array[index] = max;
			}
		}
	}
}
