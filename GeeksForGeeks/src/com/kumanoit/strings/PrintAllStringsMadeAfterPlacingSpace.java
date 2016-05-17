/**
 * Print all possible strings that can be made by placing spaces
Given a string you need to print all possible strings that can be made
 by placing spaces (zero or one) in between them.

Input:  str[] = "ABC"
Output: ABC
        AB C
        A BC
        A B C
 */
package com.kumanoit.strings;
/**
 * @author kumanoit May 15, 2016
 * PrintAllStringsMadeAfterPlacingSpace.java
 */
public class PrintAllStringsMadeAfterPlacingSpace {

	public static void main(String[] args) {
		String string = "ABC";
		char[] output = new char[2 * string.length() - 1];
		output[0] = string.charAt(0);
		printAllString(string, 1, string.length(), output, 1);
	}

	private static void printAllString(String string, int beg, int end,
		char[] output, int level) {
		if (beg == end) {
			System.out.println(new String(output));
			return;
		}
		output[level] = string.charAt(beg);
		printAllString(string, beg + 1, end, output, level + 1);
		output[level] = ' ';
		output[level + 1] = string.charAt(beg);
		printAllString(string, beg + 1, end, output, level + 2);
	}
}
