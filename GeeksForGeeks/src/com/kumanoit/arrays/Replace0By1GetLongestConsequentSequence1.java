/**
 * Find Index of 0 to be replaced with 1 to get longest continuous sequence of 1s in a binary array
Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to get longest continuous sequence of 1s. Expected time complexity is O(n) and auxiliary space is O(1).
Example:

Input: 
   arr[] =  {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1}
Output:
  Index 9
Assuming array index starts from 0, replacing 0 with 1 at index 9 causes
the maximum continuous sequence of 1s.

Input: 
   arr[] =  {1, 1, 1, 1, 0}
Output:
  Index 4
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 19, 2015
 * Replace0By1GetLongestConsequentSequence1.java
 */
public class Replace0By1GetLongestConsequentSequence1 {

	public static void main(String[] args) {
		int arr[] =  {0, 1, 1, 1, 1, 0, 0, 1};
		System.out.println(getIndexOfZero(arr));
	}

	private static int getIndexOfZero(int[] arr) {
		int index= -1;
		int end = 0;
		int beg = 0;
		int zeroCount = 0;
		int lastZeroIndex = -1;
		int longestLength = -1;
		int zeroIndex = -1;
		while (end < arr.length) {
			if (arr[end] == 0) {
				zeroCount++;
				lastZeroIndex = end;
				if (zeroCount > 1) {
					while(arr[beg] == 1) {
						beg++;
					}
					beg++;
					zeroCount--;
				}
			}
			if (longestLength < end - beg + 1) {
				longestLength = end - beg + 1;
				zeroIndex = lastZeroIndex;
			}
			end++;
		}
		return zeroIndex;
	}
}
