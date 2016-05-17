package com.kumanoit.strings;

public class RemoveAllDuplicates {

	public static void main(String[] args) {
		String string = "geeksforgeeks";
		removeAllDuplicates(string.toCharArray());
	}

	private static void removeAllDuplicates(char[] str) {
		int[] count = new int[26];
		int lastIndex = 0;
		for(int index = 0; index < str.length; index++) {
			if (count[str[index] - 'a'] == 1) {
				continue;
			}
			count[str[index] - 'a']++;
			str[lastIndex++] = str[index];
		}
		System.out.println("\nAfter removal of duplicates the string is : ");
		for (int index = 0; index < lastIndex; index++) {
			System.out.print(str[index]);
		}
	}
}
