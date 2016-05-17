/**
 * Minimum number of swaps required for arranging pairs adjacent to each other
There are n-pairs and therefore 2n people. everyone has one unique number ranging from 1 to 2n. All these 2n persons are arranged in random fashion in an Array of size 2n. We are also given who is partner of whom. Find the minimum number of swaps required to arrange these pairs such that all pairs become adjacent to each other.

Example:

Input:
n = 3  
pairs[] = {1->3, 2->6, 4->5}  // 1 is partner of 3 and so on
arr[] = {3, 5, 6, 4, 1, 2}

Output: 2
We can get {3, 1, 5, 4, 6, 2} by swapping 5 & 6, and 6 & 1
 */
package com.kumanoit.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kumanoit Dec 18, 2015
 * MinimumSwapsToArrangePairs.java
 */
public class MinimumSwapsToArrangePairs {

	public static void main(String[] args) {
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>();
		pairs.put(1, 3);
		pairs.put(2, 6);
		pairs.put(3, 1);
		pairs.put(4, 5);
		pairs.put(5, 4);
		pairs.put(6, 2);
		Integer[] array = {3, 4, 6, 2, 1, 5};
		System.out.println(getMinimumSwaps(pairs, array, 0));
	}

	private static int getMinimumSwaps(Map<Integer, Integer> pairs, Integer[] arr, int startIndex) {

		if (startIndex >= arr.length) {
			return 0;
		}
		if (arr[startIndex] == pairs.get(arr[startIndex + 1])) {
			return getMinimumSwaps(pairs, arr, startIndex + 2);
		}

		int pairIndex = getIndex(pairs.get(arr[startIndex]), arr, startIndex + 2);
		swap(arr, startIndex + 1, pairIndex);
		int minSwapsA = getMinimumSwaps(pairs, arr, startIndex + 2);
		swap(arr, startIndex + 1, pairIndex);

		pairIndex = getIndex(pairs.get(arr[startIndex + 1]), arr, startIndex + 2);
		swap(arr, startIndex, pairIndex);
		int minSwapsB = getMinimumSwaps(pairs, arr, startIndex + 2);
		swap(arr, startIndex, pairIndex);

		return 1 + Math.min(minSwapsA, minSwapsB);
	}

	private static void swap(Integer[] arr, int indexA, int indexB) {
		arr[indexA] = arr[indexA] ^ arr[indexB];
		arr[indexB] = arr[indexA] ^ arr[indexB];
		arr[indexA] = arr[indexA] ^ arr[indexB];
	}

	private static int getIndex(Integer element, Integer arr[], int start) {
		for (int i = start; i < arr.length; i++) {
			if (arr[i] == element) {
				return i;
			}
		}
		return -1;
	}
}
