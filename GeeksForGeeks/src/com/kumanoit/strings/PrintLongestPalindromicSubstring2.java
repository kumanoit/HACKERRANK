package com.kumanoit.strings;

public class PrintLongestPalindromicSubstring2 {

	public static void main(String[] args) {
		String string = "ama";//"forgeeksskeegfor";
		printLongestPalindromicSubstring(string);
	}

	private static void printLongestPalindromicSubstring(String string) {
		char[] str = string.toCharArray();
		int n = str.length;
		int maxLength = 1;
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			// For odd scenario
			int left = i - 1;
			int right = i + 1;
			while (left >= 0 && right < n) {
				if (str[left] == str[right]) {
					left--;
					right++;
				} else {
					break;
				}
			}
			int oddLength = right - left - 1;
			if (maxLength < oddLength) {
				maxLength = oddLength;
				start = left + 1;
				end = right - 1;
			}
			// for even scenario
			left = i;
			right = i + 1;
			while(left >= 0 && right < n) {
				if (str[left] == str[right]) {
					left--;
					right++;
				} else {
					break;
				}
			}
			int evenLength = right - left - 1;

			if (maxLength < evenLength) {
				maxLength = evenLength;
				start = left + 1;
				end = right - 1;
			}
		}
		System.out.println("Maximum length of palindromic substring is " + maxLength + 
				" and string is " + string.substring(start, end + 1));
	}
}
