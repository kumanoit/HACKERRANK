/**
 * Reverse an array without affecting special characters
Given a string, that contains special character together with alphabets (‘a’ to ‘z’ and ‘A’ to ‘Z’), reverse the string in a way that special characters are not affected.

Examples:

Input:   str = "a,b$c"
Output:  str = "c,b$a"
Note that $ and , are not moved anywhere.  
Only subsequence "abc" is reversed

Input:   str = "Ab,c,de!$"
Output:  str = "ed,c,bA!$"
 */
package com.kumanoit.strings;

/**
 * @author kumanoit Jan 9, 2016
 * ReverseAnArrayWithoutAffectingSpecialCharacters.java
 */
public class ReverseAnArrayWithoutAffectingSpecialCharacters {

	public static void main(String[] args) {
		StringBuilder string = new StringBuilder("a,b$c");
		reverse(string);
		System.out.println(string);
	}

	private static void reverse(StringBuilder str) {
		int len = str.length();
		int i = 0;
		int j = len - 1;
		while(i < j) {
			if (isSpecialCharacter(str.charAt(i))) {
				i++;
				continue;
			}
			if (isSpecialCharacter(str.charAt(j))) {
				j--;
				continue;
			}
			char ch = str.charAt(i);
			str.setCharAt(i, str.charAt(j));
			str.setCharAt(j, ch);
			i++;
			j--;
		}
	}

	private static boolean isSpecialCharacter(char ch) {
		if ((ch >= 'a' && ch <= 'z')
			|| (ch >= 'A' && ch <= 'Z')
			|| (ch >= '0' && ch <= '9')
			) {
			return false;
		}
		return true;
	}
}
