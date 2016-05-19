package strings;
//https://www.hackerrank.com/challenges/substring-diff
import java.util.Scanner;

public class SubStringDiff {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numberOfTestCase = in.nextInt();
		
		for(int i = 0; i < numberOfTestCase; i++) {
			int mismatchCount = in.nextInt();
			String strA = in.next();
			String strB = in.next();
			System.out.println(getSolution(strA, strB, mismatchCount));
		}
		in.close();
	}

	private static int getSolution(String strA, String strB, int misMatchesCount) {
		int n = strA.length();
		int MAX = Integer.MIN_VALUE;
		int[][] m = new int[n + 1][n + 1];

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(strA.charAt(i - 1) == strB.charAt(j - 1)) {
					m[i][j] = m[i - 1][j - 1] + 1;
					if(m[i][j] > MAX) {
						MAX = m[i][j];
					}
				}
			}
		}
		return MAX + misMatchesCount;
	}
}
