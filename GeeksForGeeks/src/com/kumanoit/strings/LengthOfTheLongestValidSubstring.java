/**
 * Length of the longest valid substring
Given a string consisting of opening and closing parenthesis, find length of the longest valid parenthesis substring.

Examples:

Input : ((()
Output : 2
Explanation : ()

Input: )()())
Output : 4
Explanation: ()() 

Input:  ()(()))))
Output: 6
Explanation:  ()(()))
 */
package com.kumanoit.strings;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Jan 9, 2016
 * LengthOfTheLongestValidSubstring.java
 */
public class LengthOfTheLongestValidSubstring {

	public static void main(String[] args) {
		String string = ")()())";
		System.out.println("Max Length is " + getLength(string));
	}

	private static int getLength(String str) {
		int[] arr = new int[str.length()];
		int maxLength = -1;
		int START_INDEX = -1;
		int END_INDEX = -1;

		for (int i = 0; i < str.length(); i++) {
			arr[i] = (str.charAt(i) == '(') ? -1 : 1;
		}

		int min = arr[0];
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = arr[i] + arr[i - 1];
			min = Math.min(arr[i], min);
			max = Math.max(arr[i], max);
		}

		ArrayUtility.printArray(arr);
		int[] hash = new int[max - min + 1];
		for(int i = 0; i < hash.length; i++) {
			hash[i] = -1;
		}

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				maxLength = i + 1;
				START_INDEX = 0;
				END_INDEX = i;
			}
			if (hash[arr[i] - min] == -1) {
				hash[arr[i] - min] = i;
			} else {
				if (i - hash[arr[i] - min] > maxLength) {
					maxLength = i - hash[arr[i] - min];
					START_INDEX = 1 + hash[arr[i] - min];
					END_INDEX = i + 1;
				}
			}
		}
		System.out.println("Start = " + START_INDEX);
		System.out.println("End = " + END_INDEX);
		return maxLength;
	}
}
