/**
 * http://www.geeksforgeeks.org/find-the-element-that-appears-once/
 * Given an array where every element occurs three times, except one element which occurs only once. Find the element that occurs once. Expected time complexity is O(n) and O(1) extra space.
Examples:

Input: arr[] = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3}
Output: 2
 */
package com.kumanoit.others;

/**
 * @author kumanoit Jan 17, 2016
 * FindElementAppearsOnceOthersThrice.java
 */
public class FindElementAppearsOnceOthersThrice {

	public static void main(String[] args) {
		int[] array = {12, 1, 12, 3, 12, 1, 1, 2, 3, 3};
		System.out.println(getSingleOccurringNumber(array));
	}

	private static int getSingleOccurringNumber(int[] array) {
		int one = 0;
		int two = 0;
		for (int i = 0; i < array.length; i++) {
			two = two | (array[i] & one);
			one ^= array[i];
			int commonBits = ~(one & two);
			one &= commonBits;
			two &= commonBits;
		}
		return one;
	}
}
