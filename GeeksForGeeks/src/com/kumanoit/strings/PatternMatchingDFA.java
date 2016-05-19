package com.kumanoit.strings;

public class PatternMatchingDFA {

	public static void main(String[] args) {
		String text =    "ABABABABABABACCCBABABACBABCABCBA";
		String pattern = "ABABABABA";
		System.out.println("From DFA");
		DFA(text, pattern);
		System.out.println("From Brute force attempt");
		PatternMatchingBruteForce.matchPattern(text, pattern);
	}

	public static void DFA(String text, String pattern) {
		int radix = 26;
		int lastState = 0;
		int[][] dfa = new int[radix][pattern.length()];
		dfa[pattern.charAt(0) - 'A'][0] = 1;
		for (int i = 1; i < pattern.length(); i++) {
			for (int j = 0; j < radix; j++) {
				dfa[j][i] = dfa[j][lastState];
			}
			dfa[pattern.charAt(i) - 'A'][i] = i + 1;
			lastState = dfa[pattern.charAt(i) - 'A'][lastState];
		}

		int state = 0;
		for (int i = 0; i < text.length(); i++) {
			if (state == pattern.length()) {
				System.out.println("Pattern found at index : " + (i - state));
				state = lastState;
			}
			state = dfa[text.charAt(i) - 'A'][state];
		}
	}
}
