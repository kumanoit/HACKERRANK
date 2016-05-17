/**
 * Given an unsorted array of nonnegative integers,
 * Find a continous subarray which adds to a given number.

Examples:

Input: arr[] = {1, 4, 20, 3, 10, 5}, sum = 33
Ouptut: Sum found between indexes 2 and 4

Input: arr[] = {1, 4, 0, 0, 3, 10, 5}, sum = 7
Ouptut: Sum found between indexes 1 and 4

Input: arr[] = {1, 4}, sum = 0
Output: No subarray found
There may be more than one subarrays with sum as the given sum.
The following solutions print first such subarray.

Source: Google Interview Question
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 21, 2015
 * SubArrayWithGivenSum.java
 */
public class SubArrayWithGivenSum {

	public static void main(String[] args) {
		int[] array = {1, 4, 0, 0, 3, 10, 5};
		int x = 71;
		findSubArrayWithGivenSum(array, x);
	}

	private static void findSubArrayWithGivenSum(int[] array, int x) {
		if (x != 0) {
	        int start = 0;
	        int end = 0;
	        int sum = 0;
	        while(end < array.length) {
	            if (sum == x) {
	                for (int i = start; i < end; i++) {
	                    System.out.print(array[i] + " ");
	                }
	                System.out.println();
	                return;
	            } else if (sum > x) {
	                sum -= array[start++];
	            } else {
	                sum += array[end++];
	            }
	        }
		}
        
        System.out.println("No subArray found.");
    }
}
