/**
 * Find the minimum distance between two numbers
Given an unsorted array arr[] and two numbers x and y,
 find the minimum distance between x and y in arr[]. 
 The array might also contain duplicates. You may assume that both x and y are 
 different and present in arr[].

Examples:
Input: arr[] = {1, 2}, x = 1, y = 2
Output: Minimum distance between 1 and 2 is 1.

Input: arr[] = {3, 4, 5}, x = 3, y = 5
Output: Minimum distance between 3 and 5 is 2.

Input: arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}, x = 3, y = 6
Output: Minimum distance between 3 and 6 is 4.

Input: arr[] = {2, 5, 3, 5, 4, 4, 2, 3}, x = 3, y = 2
Output: Minimum distance between 3 and 2 is 1.
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 21, 2015
 * MinimumDistanceBetweenTwoNumbers.java
 */
public class MinimumDistanceBetweenTwoNumbers {

	public static void main(String[] args) {
		int[] array = {2, 5, 3, 5, 4, 4, 2, 3};
		int x = 3;
		int y = 2;
		getMinimumDistance(array, x, y);
	}

	private static void getMinimumDistance(int[] array, int x, int y) {
		int minDistance = array.length;
		int xIndex = -1;
		int yIndex = -1;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == x) {
				xIndex = i;
			} else if(array[i] == y) {
				yIndex = i;
			}
			if (xIndex != -1 && yIndex != -1) {
				minDistance = Math.min(minDistance, Math.abs(xIndex - yIndex));
			}
		}
		System.out.println(minDistance);
	}
}
