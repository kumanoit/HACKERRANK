package com.kumanoit.strings;

public class ReturnMaximumOccuringCharacter {

	public static void main(String[] args) {
		String string = "geeksforgeeks";
		System.out.println("\nMaximum occuring character is \"" + getMaximumOccuringCharacter(string) + "\"");
	}

	private static char getMaximumOccuringCharacter(String string) {
		char[] str = string.toCharArray();
		int[] count = new int[26];
		for (int index = 0; index < str.length; index++) {
			count[str[index] - 'a']++;
		}
		int maxIndex = 0;
		for (int index = 0; index < count.length; index++) {
			if (count[index] > count[maxIndex]) {
				maxIndex = index;
			}
		}
		return (char) (maxIndex + 'a');
	}
}
