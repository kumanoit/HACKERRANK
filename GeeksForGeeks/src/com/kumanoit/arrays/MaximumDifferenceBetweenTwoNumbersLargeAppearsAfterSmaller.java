/**
 * Maximum difference between two elements such that larger element appears after 
 * the smaller number
Given an array arr[] of integers, find out the difference between any two elements 
such that larger element appears after the smaller number in arr[].

Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 
(Diff between 10 and 2). If array is [ 7, 9, 5, 6, 3, 2 ] then returned value 
should be 2 (Diff between 7 and 9)
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 21, 2015
 * MaximumDifferenceBetweenTwoNumbersLargeAppearsAfterSmaller.java
 */
public class MaximumDifferenceBetweenTwoNumbersLargeAppearsAfterSmaller {

	public static void main(String[] args) {
		int[] arr = { 7, 9, 5, 6, 3, 2 };
		getSolution(arr);
	}

	private static void getSolution(int[] arr) {
		int min = arr[0];
		int maxDifference = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			} else if (arr[i] > min) {
				maxDifference = Math.max(maxDifference, Math.abs(arr[i] - min));
			}
		}
		System.out.println(maxDifference);
	}
}
