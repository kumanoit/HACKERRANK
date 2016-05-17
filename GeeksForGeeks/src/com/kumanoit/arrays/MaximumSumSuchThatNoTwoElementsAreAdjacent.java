/**http://www.geeksforgeeks.org/maximum-sum-such-that-no-two-elements-are-adjacent/
 * Maximum sum such that no two elements are adjacent
Question: Given an array of positive numbers, find the maximum sum of a 
subsequence with the constraint that no 2 numbers in the sequence should
 be adjacent in the array. So 3 2 7 10 should return 13 (sum of 3 and 10) or
  3 2 5 10 7 should return 15 (sum of 3, 5 and 7).Answer the question in most efficient way.
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 21, 2015
 * MaximumSumSuchThatNoTwoElementsAreAdjacent.java
 */
public class MaximumSumSuchThatNoTwoElementsAreAdjacent {

	public static void main(String[] args) {
		int[] arr = {3, 2, 5, 10, 7};
		getSolution(arr);
	}

	private static void getSolution(int[] arr) {
		int incl = arr[0];
		int excl = 0;
		for(int i = 1; i < arr.length; i++) {
			int new_excl = Math.max(incl, excl);
			incl = excl + arr[i];
			excl = new_excl;
		}
		System.out.println(Math.max(incl, excl));
	}
}
