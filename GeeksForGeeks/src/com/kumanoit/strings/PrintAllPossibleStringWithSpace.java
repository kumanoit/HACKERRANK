/**
 * Print all possible strings that can be made by placing spaces
Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them.

Input:  str[] = "ABC"
Output: ABC
        AB C
        A BC
        A B C
 */
package com.kumanoit.strings;

/**
 * @author kumanoit Jan 10, 2016
 * PrintAllPossibleStringWithSpace.java
 */
public class PrintAllPossibleStringWithSpace {

	public static void main(String[] args) {
		String str = "ABCDE";
		printSolutions(str, new char[str.length() * 2 - 1], 0, 0);
	}

	private static void printSolutions(String input, char[] output, int level, int index) {
		if (level > 0 && output[level - 1] == input.charAt(input.length() - 1)) {
			for (int i = 0; i < level; i++) {
				System.out.print(output[i]);
			}
			System.out.println();
			return;
		}

		output[level] = input.charAt(index);
		printSolutions(input, output, level + 1, index + 1);
		if (index != input.length() - 1) {
			output[level + 1] = ' ';
			printSolutions(input, output, level + 2, index + 1);
		}
	}
}
