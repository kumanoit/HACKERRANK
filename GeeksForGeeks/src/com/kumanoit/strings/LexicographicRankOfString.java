package com.kumanoit.strings;

import com.kumanoit.common.CommonUtils;

public class LexicographicRankOfString {

	public static void main(String[] args) {
		String string = "YTOJE";
		System.out.println("\nRank of given string is " + getLexicographicRank(string));
		System.out.println("\nRank of given string is " + getLexicographicRank2(string));
	}

	private static int getLexicographicRank(String string) {
		int rank = 1;
		for (int index = 0; index < string.length() - 1; index++) {
			int k = 0;
			for (int next = index + 1; next < string.length(); next++) {
				if (string.charAt(index) > string.charAt(next)) {
					k++;
				}
			}
			rank += k * CommonUtils.getFactorial(string.length() - index - 1);
		}
		return rank;
	}

	private static void update(int[] count, char ch) {
		for(int i = (int) ch; i < count.length; i++) {
			--count[i];
		}
	}
	private static int getLexicographicRank2(String string) {
		int rank = 1;
		int[] count = new int[256];
		for (int i = 0; i < string.length(); i++) {
			count[string.charAt(i)]++;
		}
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}
		long fact = CommonUtils.getFactorial(string.length());
		for (int i = 0; i < string.length(); i++) {
			fact = fact / (string.length() - i);
			rank += count[string.charAt(i) - 1] * fact;
			update(count, string.charAt(i));
		}
		return rank;
	}

//	private static int getRank(String string) {
//		int rank = 0;
//		for (int i = 0; i < string.length(); i++) {
//			rank = rank * 26 + (string.charAt(i) - 'A');
//		}
//		return rank;
//	}
}
