package com.kumanoit.strings;

public class PrintLongestCommonSubsequence {

	private static final int UP = 1;
	private static final int LEFT = 2;
	private static final int DIAG = 3;
//	“AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
	public static void main(String[] args) {
		String string1 = "ABCDGH";//"AGGTAB";//
		String string2= "AEDFHR";//"GXTXAYB";//
		printLCS(string1, string2);
	}

	private static void printLCS(String string1, String string2) {
		int m = string1.length();
		int n = string2.length();

		int[][] map = new int[m + 1][n + 1];
		int[][] s = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
					map[i][j] = map[i - 1][j - 1] + 1;
					s[i][j] = DIAG;
				} else if (map[i - 1][j] > map[i][j - 1]) {
					s[i][j] = UP;
					map[i][j] = map[i - 1][j];
				} else {
					s[i][j] = LEFT;
					map[i][j] = map[i][j - 1];
				}
				}
			}
		System.out.println("Length of longest common subsequence is " + map[m][n]);
		printLCSString(s, m, n, string1);
	}

	static void printLCSString(int[][] s, int i, int j, String str) {
		if (i == 0 || j == 0) {
			return;
		}
		if (s[i][j] == DIAG) {
			printLCSString(s, i - 1, j - 1, str);
			System.out.print(str.charAt(i - 1));
		} else if (s[i][j] == UP) {
			printLCSString(s, i - 1, j, str);
		} else {
			printLCSString(s, i, j - 1, str);
		}
	}
}
