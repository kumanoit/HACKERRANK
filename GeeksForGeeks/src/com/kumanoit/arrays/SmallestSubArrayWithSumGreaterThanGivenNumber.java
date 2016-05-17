/**
 * http://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/

 * Smallest subarray with sum greater than a given value
Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.

Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 19, 2015
 * SmallestSubArrayWithSumGreaterThanGivenNumber.java
 */
public class SmallestSubArrayWithSumGreaterThanGivenNumber {

	public static void main(String[] args) {
		int[] array = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};//{1, 4, 45, 6, 0, 19};
		int x = 280;//51;
		getSmallestSubarray(array, x);
		getSmallest(array, x);
	}

	private static void getSmallestSubarray(int[] array, int x) {
		int end = 0;
		int beg = 0;
		int sum = 0;
		int START = -1;
		int END = -1;
		int minLength = array.length + 1;
		while (end < array.length) {
			if (array[end] > x) {
				minLength = 1;
				START = END = end;
				break;
			}
			if (sum <= x) {
				sum += array[end++];
			}
			if (sum > x) {
				if (minLength > end - beg) {
					START = beg;
					END = end - 1;
					minLength = end - beg;
				}
				sum -= array[beg++];
			}
		}
		System.out.println("Min length = " + minLength);
		for (int index = START; index <= END; index++) {
			System.out.print(array[index] + "\t");
		}
	}

	private static void getSmallest(int[] array, int SUM) {
		int start = 0;
		int end = 0;
		int sum = 0;
		int size = array.length;
		int start_index = -1;
		int end_index = -1;
		int minLength = size + 1;

		while (end < size) {
			while (end < size && sum <= SUM) {
				if (array[end] > SUM) {
					start_index = end_index = end;
					break;
				}
				sum += array[end++];
			}
			if (end == size && sum <= SUM) {
				System.out.println("The total sum of all numbers is lesser than given SUM.");
				break;
			}
			while (start < end && sum > SUM) {
				sum -= array[start++];
			}

			if (minLength > end - start + 1) {
				minLength = end - start + 1;
				start_index = start - 1;
				end_index = end - 1;
			}
		}

		System.out.println("\nThe numbers are");
		for (int i = start_index; i <= end_index; i++) {
			System.out.print(array[i] + "  ");
		}

	}
}
