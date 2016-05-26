/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * Dynamic Programming | Set 4 (Longest Common Subsequence)
We have discussed Overlapping Subproblems and Optimal Substructure properties 
in Set 1 and Set 2 respectively. We also discussed one example problem in Set 3.
Let us discuss Longest Common Subsequence (LCS) problem as one more example
 problem that can be solved using Dynamic Programming.

LCS Problem Statement: Given two sequences, find the length of longest 
subsequence present in both of them. A subsequence is a sequence that appears 
in the same relative order, but not necessarily contiguous. 
For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of 
“abcdefg”. So a string of length n has 2^n different possible subsequences.

It is a classic computer science problem, the basis of diff (a file comparison 
program that outputs the differences between two files), and has applications in 
bioinformatics.

Examples:
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
package com.kumanoit.dynamicProgramming;

public class LongestCommonSubsequence {

	private static final char NORTH_WEST = 'D';
	private static final int NORTH = 'N';
	private static final int WEST = 'W';
	public static void main(String[] args) {
		String X = "AGGTAB";//"ABCDGH";
		String Y = "GXTXAYB";//"AEDFHR";
		System.out.println("Normal : " + getLCS(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
		System.out.println("\nVia DP : " + getLCSDP(X.toCharArray(), Y.toCharArray(), X.length(), Y.length()));
	}

	/**
	 * O(2^n)
	 * @param X
	 * @param Y
	 * @param m
	 * @param n
	 * @return
	 */
	private static int getLCS(char[] X, char[] Y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (X[m - 1] == Y[n - 1]) {
			return 1 + getLCS(X, Y, m - 1, n - 1);
		}
		return Math.max(getLCS(X, Y, m - 1, n), getLCS(X, Y, m, n - 1));
	}

	/**
	 * O(n^2)
	 * @param X
	 * @param Y
	 * @param m
	 * @param n
	 * @return
	 */
	private static int getLCSDP(char[] X, char[] Y, int m, int n) {
		int[][] mat = new int[m + 1][n + 1];
		char[][] s = new char[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			mat[i][0] = 0;
		}
		for (int i = 0; i <= n; i++) {
			mat[0][i] = 0;
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <=n; j++) {
				if (X[i - 1] == Y[j - 1]) {
					mat[i][j] = mat[i - 1][j - 1] + 1;
					s[i][j] = NORTH_WEST;
				} else {
					if (mat[i - 1][j] > mat[i][j - 1]) {
						mat[i][j] = mat[i - 1][j];
						s[i][j] = NORTH;
					} else {
						mat[i][j] = mat[i][j - 1];
						s[i][j] = WEST;
					}
				}
			}
		}
		System.out.println("Your longest common subsequence is : ");
		printLCS(X, s, m, n);
		return mat[m][n];
	}

	private static void printLCS(char[] X, char[][] s, int m, int n) {
		if (m == 0 || n == 0) {
			return;
		}
		if (s[m][n] == NORTH_WEST) {
			printLCS(X, s, m - 1, n - 1);
			System.out.print(X[m - 1]);
		} else if (s[m][n] == NORTH) {
			printLCS(X, s, m - 1, n);
		} else {
			printLCS(X, s, m, n - 1);
		}
	}
}

