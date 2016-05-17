package com.kumanoit.strings;

public class CheckIfStringsAreAnagrams {

	public static void main(String[] args) {
		String string1 = "teacher";
		String string2 = "cheater";
		if (areAnagrams(string1, string2)) {
			System.out.println("Strings are anagrams.");
		} else {
			System.out.println("Strings are not anagrams.");
		}
	}

	private static boolean areAnagrams(String string1, String string2) {
		if (string1.length() != string2.length()) {
			return false;
		}
		int count[] = new int[256];
		for (int index = 0; index < string1.length(); index++) {
			count[string1.charAt(index)]++;
			count[string2.charAt(index)]--;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
