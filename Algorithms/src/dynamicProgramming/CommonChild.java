package dynamicProgramming;
//https://www.hackerrank.com/challenges/common-child
import java.util.Scanner;

public class CommonChild {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String strA = in.next();
		String strB = in.next();
		System.out.println(getSolution(strA, strB));
		in.close();
	}

	private static int getSolution(String strA, String strB) {
		int n = strA.length();
		int m = strB.length();
		int[][] mat = new int[n + 1][m + 1];
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(strA.charAt(i - 1) == strB.charAt(j - 1)) {
					mat[i][j] = mat[i - 1][j - 1] + 1;
				} else {
					mat[i][j] = Math.max(mat[i - 1][j], mat[i][j - 1]); 
				}
			}
		}
		return mat[n][m];
	}
}