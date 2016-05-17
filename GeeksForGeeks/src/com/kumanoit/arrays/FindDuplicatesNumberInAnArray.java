/**
 * Find duplicates in O(n) time and O(1) extra space
Given an array of n elements which contains elements from 0 to n-1,
 with any of these numbers appearing any number of times. 
 Find these repeating numbers in O(n) and using only constant memory space.

For example, let n be 7 and array be {1, 2, 3, 1, 3, 6, 6}, 
the answer should be 1, 3 and 6.

This problem is an extended version of following problem.
 */
package com.kumanoit.arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kumanoit Dec 21, 2015
 * FindDuplicatesNumberInAnArray.java
 */
public class FindDuplicatesNumberInAnArray {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 1, 3, 6, 6};
		findDuplicates(arr);
	}

	private static void findDuplicates(int[] arr) {
		Set<Integer> duplicates = new HashSet<Integer>();
		for(int i = 0; i < arr.length; i++) {
			int j = arr[i] > 0 ? arr[i] : -arr[i];
			if (arr[j] > 0) {
				arr[j] = -arr[j];
			} else {
				duplicates.add(Math.abs(j));
			}
		}
		System.out.println("There are " + duplicates.size() + " duplicates number.");
		duplicates.forEach(item -> System.out.print(item + " "));
	}
}
