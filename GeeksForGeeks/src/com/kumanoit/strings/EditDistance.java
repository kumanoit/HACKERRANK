/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * Given two strings str1 and str2 and below operations that can
 * performed on str1. Find minimum number of edits (operations)
 * required to convert 'str1' into 'str2'.

Insert
Remove
Replace
All of the above operations are of equal cost.
 */
package com.kumanoit.strings;

/**
 * @author kumanoit Jan 9, 2016
 * EditDistance.java
 */
public class EditDistance {

	public static void main(String[] args) {
		String str1 = "";
		String str2 = "sunday";
		System.out.println(getMinEdits(str1, str2, 0, 0));
		System.out.println(getMinEditsDP(str1, str2));
	}

	private static int getMinEdits(String str1, String str2, int i, int j) {
		if (i == str1.length()) {
			return str2.length() - j;
		}
		if (j == str2.length()) {
			return str1.length() - i;
		}
		if (str1.charAt(i) == str2.charAt(j)) {
			return getMinEdits(str1, str2, i + 1, j + 1);
		}
		return 1 + Math.min(
						Math.min(getMinEdits(str1, str2, i, j + 1), 
								 getMinEdits(str1, str2, i + 1, j)
								),
						getMinEdits(str1, str2, i + 1, j + 1));
	}

	private static int getMinEditsDP(String str1, String str2) {
		if (str1.length() == 0) {
			return str2.length();
		}
		if (str2.length() == 0) {
			return str1.length();
		}
		int[][] m = new int[str1.length() + 1][str2.length() + 1];
		for(int i = 0; i <= str1.length(); i++) {
			m[i][0] = i;
		}
		for(int i = 1; i <= str2.length(); i++) {
			m[0][i] = i;
		}
		for(int i = 1; i <= str1.length(); i++) {
			for(int j = 1; j <= str2.length(); j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					m[i][j] = m[i - 1][ j - 1];
				} else {
					m[i][j] = 1 + Math.min(
									Math.min(
											m[i][j - 1],
											m[i - 1][j]
											),
									m[i - 1][j - 1]);
				}
			}
		}
//		ArrayUtility.printMatrix(m);
		return m[str1.length()][str2.length()];
	}
}
