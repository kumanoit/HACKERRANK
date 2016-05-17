package com.kumanoit.strings;

public class CheckIfStringIsInterleavingOfTwoStrings {

	public static void main(String[] args) {
		String str1 = "XXY";
		String str2 = "XZX";
		String str3 = "XXYXZX";
		if (isInterleaving(str1, str2, str3)) {
			System.out.println("Interleaving strings");
		} else {
			System.out.println("Non-interleaving strings.");
		}
	}

	private static boolean isInterleaving(String str1, String str2, String str3) {
	 	int m = str1.length();
		int n = str2.length();
		if (m + n != str3.length()) {
			return false;
		}
		boolean[][] table = new boolean[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 && j == 0) {
					table[i][j] = true;
				} else if (j == 0 && str1.charAt(i - 1) == str3.charAt(i - 1)) {
					table[i][j] = table[i - 1][j];
				} else if (i == 0 && str2.charAt(j - 1) == str3.charAt(j - 1)) {
					table[i][j] = table[i][j - 1];
				} else if (i != 0 && j != 0 && 
							str1.charAt(i - 1) == str3.charAt(i + j - 1) &&
							str2.charAt(j - 1) == str3.charAt(i + j - 1)) {
					table[i][j] = table[i][j - 1] || table[i - 1][j];
				} else if (i != 0 && str1.charAt(i - 1) == str3.charAt(i + j - 1)) {
					table[i][j] = table[i - 1][j];
				} else if (j != 0 && str2.charAt(j - 1) == str3.charAt(i + j - 1)) {
					table[i][j] = table[i][j - 1];
				}
			}
		}
		return table[m][n];
	}
}
