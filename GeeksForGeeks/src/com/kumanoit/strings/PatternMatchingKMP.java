package com.kumanoit.strings;

import com.kumanoit.utils.arrays.ArrayUtility;

public class PatternMatchingKMP {

	public static void main(String[] args) {
		String text =    "BACBABABACABCBAB";//"ABABABABABABACCCBABABACBABCABCBA";
		String pattern = "ABABACA";//"ABABABABA";
		System.out.println("KMP");
		matchPattern(text, pattern);
		System.out.println("DFA");
		PatternMatchingDFA.DFA(text, pattern);
		System.out.println("Brute force");
		PatternMatchingBruteForce.matchPattern(text, pattern);
	}

	private static int[] buildKey(String pattern) {
		int k = -1;
		int[] fun = new int[pattern.length()];
		fun[0] = -1;
		for (int i = 1; i < pattern.length(); i++) {
			while (k > -1 && (pattern.charAt(k + 1) != pattern.charAt(i))) {
				k = fun[k];
			}
			if (pattern.charAt(k + 1) == pattern.charAt(i)) {
				k++;
			}
			fun[i] = k;
		}
		ArrayUtility.printArray(fun);
		return fun;
	}
	public static void matchPattern(String text, String pattern) {
		int[] fun = buildKey(pattern);
		int k = -1;
		for (int i = 0; i < text.length(); i++) {
			while (k > -1 && pattern.charAt(k + 1) != text.charAt(i)) {
				k = fun[k];
			}
			if (pattern.charAt(k + 1) == text.charAt(i)) {
				k++;
			}
			if (k == pattern.length() - 1) {
				System.out.println("Pattern found at index : " + (i - pattern.length() + 1));
				k = fun[k];
			}
		}
	}
}
