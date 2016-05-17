/**
 * http://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * 
 * Longest Palindromic Substring | Set 1
Given a string, find the longest substring which is palindrome.
For example, if the given string is “forgeeksskeegfor”, the output should be “geeksskeeg”.
 */
package com.kumanoit.strings;

public class PrintLongestPalidromicSubstring1 {

	public static void main(String[] args) {
		String string = "amit";//"forgeeksskeegfor";
		printLongestPalindromicSubstring(string);
	}

	private static void printLongestPalindromicSubstring(String string) {
		char[] str = string.toCharArray();
		int n = str.length;
		int[][] mat = new int[n][n];
		int maxLength = 1;
		int start = 0;

		for (int i = 0; i < n; i++) {
			mat[i][i] = 1;
		}

		for (int i = 0; i < n - 1; i++) {
			if (str[i] == str[i + 1]) {
				start = i;
				maxLength = 2;
				mat[i][i + 1] = 1;
			}
		}

		for (int len = 3; len <= n; len++) {
			for (int i = 0; i < n - len + 1; i++) {
				int j = len + i - 1;
				if (mat[i + 1][j - 1] == 1 && str[i] == str[j]) {
					mat[i][j] = 1;
					maxLength = len;
					start = i;
				} else {
					mat[i][j] = 0;
				}
			}
		}
		System.out.println("Largest length of palindrome is " + maxLength);
		for (int i = start; i < start + maxLength; i++) {
			System.out.print(str[i]);
		}
	}
}
