/**
 * Given two strings A and B, the task is to convert A to B if possible. The only operation allowed is to put any character from A and insert it at front. Find if it’s possible to convert the string. If yes, then output minimum no. of operations required for transformation.

Input:  A = "ABD", B = "BAD"
Output: 1
Explanation: Pick B and insert it at front.

Input:  A = "EACBD", B = "EABCD"
Output: 3
Explanation: Pick B and insert at front, EACBD => BEACD
             Pick A and insert at front, BEACD => ABECD
             Pick E and insert at front, ABECD => EABCD
 */
package com.kumanoit.strings;

/**
 * @author kumanoit Jan 10, 2016
 * TransformOneStringToAnother.java
 */
public class TransformOneStringToAnother {

	public static void main(String[] args) {
		String str1 = "ACEBD";
		String str2 = "EABCD";
		System.out.println(getMinimumTransformation(str1, str2));
	}

	private static int getMinimumTransformation(String str1, String str2) {
		String strA = str1.toLowerCase();
		String strB = str2.toLowerCase();
		if (!isAnagram(strA, strB)) {
			return -1;
		}
		int numTransformations = 0;
		for(int i = strA.length() - 1, j = strB.length()- 1; i >=0 && j >= 0; ) {
			while(i >= 0 && strB.charAt(j) != strA.charAt(i)) {
				i--;
				numTransformations++;
			}
			if (i >= 0) {
				i--;
				j--;
			}
		}
		return numTransformations;
	}

	private static boolean isAnagram(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		int[] count = new int[26];
		for(int i = 0; i < str1.length(); i++) {
			count[str1.charAt(i) - 'a']++;
			count[str2.charAt(i) - 'a']--;
		}
		for(int i = 0; i < str1.length(); i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
