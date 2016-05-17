package com.kumanoit.strings;

public class PrintAllInterleavingOfTwoStrings {

	public static void main(String[] args) {
		String str1 = "ABC";
		String str2 = "XYZ";
		char[] output = new char[str1.length() + str2.length()];
		printAllInterleavings(str1, str2, output, 0, 0, 0);
	}

	private static void printAllInterleavings(String str1, String str2,
		char[] output, int level, int i, int j) {
		if (str1.length() == i && str2.length() == j) {
			System.out.println(new String(output).trim());
			return;
		}

		if (str1.length() == i) {
			System.out.println(new String(output).trim() + str2.substring(j));
			return;
		}

		if (str2.length() == j) {
			System.out.println(new String(output).trim() + str1.substring(i));
			return;
		}

		output[level] = str1.charAt(i);
		printAllInterleavings(str1, str2, output, level + 1, i + 1, j);

		output[level] = str2.charAt(j);
		printAllInterleavings(str1, str2, output, level + 1, i, j + 1);
		output[level] = ' ';
	}
}
