/**
 * Given a string, print all possible palindromic partitions
Given a string, find all possible palindromic partitions of given string.

Example:
Input: nitin
Output: n i t i n
		n iti n
		nitin

Input: geeks
Output: g e e k s
		g ee k s
 */
package com.kumanoit.strings;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Jan 10, 2016
 * PrintAllPalindromicPartition.java
 */
public class PrintAllPalindromicPartition {

	public static void main(String[] args) {
		String str = "nitin";
		getLongestPalidromicString(str);
	}

	private static void getLongestPalidromicString(String str) {
		int[][] m = new int[str.length()][str.length()];
		boolean[][] isPal = new boolean[str.length()][str.length()];

		for (int i = 0; i < str.length(); i++) {
			m[i][i] = 1;
			isPal[i][i] = true;
		}

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				m[i][i+1] = 1;
				isPal[i][i + 1] = true;
			}
		}

		for(int len = 3; len <= str.length(); len++) {
			for(int i = 0; i < str.length() - len + 1; i++) {
				int j = i + len - 1;
				if (isPal[i + 1][j - 1] && str.charAt(i) == str.charAt(j)) {
					m[i][j] = 1;
					isPal[i][j] = true;
				}
			}
		}

//		for(int len = 1; len <= str.length(); len++) {
//			for(int i = 0; i < str.length() - len + 1; i++) {
//				int j = i + len - 1;
//				
//			}
//		}

		ArrayUtility.printMatrix(m);
		System.out.println("\n");
		for(int i = 0; i < str.length(); i++) {
			for (int j = 0; j < str.length(); j++) {
				if (isPal[i][j]) {
					System.out.println(str.substring(i, j + 1) + "\t");
				}
			}
		}
	}
}
