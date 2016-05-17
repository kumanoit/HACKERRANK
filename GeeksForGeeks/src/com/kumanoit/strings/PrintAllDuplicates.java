/**
 * http://www.geeksforgeeks.org/print-all-the-duplicates-in-the-input-string/
 * Write an efficient C program to print all the duplicates and their counts in the input string
 */
package com.kumanoit.strings;

public class PrintAllDuplicates {

	public static void main(String[] args) {
		String string = "geeksforgeeks";
		char[] str = string.toCharArray();
		printAllDuplicates(str);
	}

	private static void printAllDuplicates(char[] str) {
		int[] count = new int[26];
		for (int index = 0; index < str.length; index++) {
			count[str[index] - 'a']++;
		}
		for (int index = 0; index < count.length; index++) {
			if (count[index] == 0) {
				continue;
			}
			System.out.println((char)(index + 'a') + " occurs " + count[index] + " times.");
		}
	}
}
