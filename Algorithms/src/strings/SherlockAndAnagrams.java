//https://www.hackerrank.com/challenges/sherlock-and-anagrams
package strings;

import java.util.Scanner;

public class SherlockAndAnagrams {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numberOfTestCase = in.nextInt();
		
		for(int i = 0; i < numberOfTestCase; i++) {
			String str = in.next();
			System.out.println(getSolution(str));
		}
		in.close();
	}

	/**
	 * @param str
	 * @return total count of unordered anagrams
	 */
	private static long getSolution(String str) {
		long m = getSingleLength(str);
		int n = str.length();
		for(int len = 2; len < n; len++) {
			for(int i = 0 ; i < n - len + 1; i++) {
				for(int j = i + 1; j + len - 1 < n; j++) {
					if(isAnagramic(str, i, j, len)) {
//						System.out.println(str.substring(i, i + len) + "\t" + str.substring(j, j +len));
						m++;
					}
				}
			}
		}
		return m;
	}

	/**
	 * @param str
	 * @param i
	 * @param j
	 * @param len
	 * @return true : if str(i, i + len) is anagram of str(j, j + len)
	 * false : otherwise
	 */
	private static boolean isAnagramic(String str, int i, int j, int len) {
		int[] count = new int[26];
		for(int index = 0; index < len; index++) {
			count[str.charAt(index + i) - 'a']++;
			count[str.charAt(index + j) - 'a']--;
		}
		for(int index = 0; index < 26; index++) {
			if(count[index] > 0) {
				return false;
			}
		}
		return true;
	}

	/**
	 * @param str
	 * @return single length anagrams
	 * if there are n occurences of a character say x then the total pair will be n(n-1)/2
	 */
	private static long getSingleLength(String str) {
		long sol = 0;
		int[] count = new int[26];
		int len = str.length();
		for(int i = 0; i < len; i++) {
			count[str.charAt(i) - 'a']++;
		}
		for(int i = 0; i < 26; i++) {
			int cnt = count[i];
			sol += cnt * (cnt - 1) / 2;
		}
		return sol;
	}
}
