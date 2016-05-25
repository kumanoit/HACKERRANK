/**
 * Dynamic Programming | Set 3 (Longest Increasing Subsequence)
We have discussed Overlapping Subproblems and
 Optimal Substructure properties in Set 1 and Set 2 respectively.

Let us discuss Longest Increasing Subsequence (LIS) 
problem as an example problem that can be solved using Dynamic Programming.
The longest Increasing Subsequence (LIS) problem is to find the length of the 
longest subsequence of a given sequence such that all elements of the 
subsequence are sorted in increasing order. For example, length of LIS for 
{ 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 */
package com.kumanoit.dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	private static int maxLis = 1;
	public static void main(String[] args) {
		int arr[] = {8,7,6,5,4,3};
		System.out.println("Via DP : " + getLisDP(arr, arr.length));
		System.out.println("Lis    : " + getLis(arr, arr.length) + "  maxLis =  " + maxLis);
	}

	private static int getLis(int[] arr, int size) {
		if (size == 1) {
			return 1;
		}

		int localMax = 1;
		int max = 0;
		for (int i = 1; i < size; i++) {
			localMax = getLis(arr, i);
			if (arr[i - 1] < arr[size - 1]) {
				if (localMax + 1 > max) {
					max = localMax + 1;
				}
			}
		}
		maxLis = Math.max(max, maxLis);
		return max;
	}

	private static int getLisDP(int[] arr, int size) {
		int[] map = new int[size];
		for (int i = 0; i < size; i++) {
			map[i] = 1;
		}
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j]) {
					map[i] = Math.max(map[j] + 1, map[i]);
				}
			}
		}
		System.out.println(Arrays.toString(map));
		return map[size - 1];
	}
}
