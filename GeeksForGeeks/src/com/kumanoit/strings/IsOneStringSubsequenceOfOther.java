package com.kumanoit.strings;

public class IsOneStringSubsequenceOfOther {

	public static void main(String[] args) {
		String str1 = "AXY";
		String str2 = "YADXCP";
		if (isSubsequence(str1, str2, 0, 0)) {
			System.out.println("Yes it is subsequence.");
		} else {
			System.out.println("No, it is not a subsequence.");
		}
	}

	/**
	 * string 2 contains subsequence string1
	 * @param string1
	 * @param string2
	 * @param i
	 * @param j
	 * @return
	 */
	private static boolean isSubsequence(String string1, String string2, int i, int j) {
		if (string1.length() == i) {
			return true;
		}
		if (string2.length() == j) {
			return false;
		}
		if (string1.charAt(i) == string2.charAt(j)) {
			return isSubsequence(string1, string2, i + 1, j + 1);
		}
		return isSubsequence(string1, string2, i, j + 1);
	}
}
