/**
 * http://www.geeksforgeeks.org/find-the-two-numbers-with-odd-occurences-in-an-unsorted-array/
 * Find the two numbers with odd occurrences in an unsorted array
Given an unsorted array that contains even number of occurrences for all numbers except two numbers. Find the two numbers which have odd occurrences in O(n) time complexity and O(1) extra space.

Examples:

Input: {12, 23, 34, 12, 12, 23, 12, 45}
Output: 34 and 45

Input: {4, 4, 100, 5000, 4, 4, 4, 4, 100, 100}
Output: 100 and 5000

Input: {10, 20}
Output: 10 and 20
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 20, 2015
 * TwoNumbersWithOddOccurrences.java
 */
public class TwoNumbersWithOddOccurrences {

	public static void main(String[] args) {
		int[] arr = {10, 20};
		printTwoNumbersWithOddOccurrences(arr);
	}

	private static void printTwoNumbersWithOddOccurrences(int[] arr) {
		int xor = 0;
		int xorA = 0;
		int xorB = 0;
		for(int i = 0; i < arr.length; i++) {
			xor ^= arr[i];
		}

		int mask = xor & ~(xor - 1);
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & mask) > 0 && (arr[i] & mask) > 0) {
				xorA ^= arr[i];
			} else {
				xorB ^= arr[i];
			}
		}
		System.out.println(xorA + "\t" + xorB);
	}
}
