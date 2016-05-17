package com.kumanoit.strings;

public class PrintAllPalindromePermutations {

	private static int count = 0;

	public static void main(String[] args) {
		String str = "aabd";
//		printAllPalindromePermutations(str);
		printPer(str.toCharArray(), 0, str.length() - 1);
	}

	private static void printAllPalindromePermutations(String string) {
		int[] count = new int[26];
		int numOddOccurrences = 0;
		char oddCharacter = '\0';
		int n = string.length();
		char[] output = new char[n/2];
		int k = 0;

		for (int i = 0; i < string.length(); i++) {
			count[string.charAt(i) - 'a']++;
		}

		for (int i = 0; i < count.length; i++) {
			if (count[i] % 2 == 1) {
				numOddOccurrences++;
				oddCharacter = (char) (i + 'a');
				count[i]--;
			}
			if (numOddOccurrences > 1) {
				System.out.println("Can't create palindrome strings.");
				return;
			}
			while (count[i] > 0) {
				output[k++] = (char) (i + 'a');
				count[i] -= 2;
			}
		}
		printPermutation(output, 0, k - 1, oddCharacter);
	}

	private static void printPermutation(char[] output, int beg, int end,
		char oddCharacter) {
		if (beg == end) {
			StringBuilder stringBuilder = new StringBuilder(new String(output));
			if (oddCharacter != '\0') {
				stringBuilder.append(oddCharacter);
			}
			stringBuilder.append(reverseString(output));
			System.out.println(++count + " " + stringBuilder);
		}
		for (int index = beg; index <= end; index++) {
			swap(output, index, beg);
			printPermutation(output, beg + 1, end, oddCharacter);
			swap(output, index, beg);
			while (index + 1 < output.length && output[index] == output[index + 1]) {
				index++;
			}
		}
	}

	private static void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static String reverseString(char[] string) {
		char[] reversedString = new char[string.length];
		for (int i = 0, k = string.length - 1; i < string.length; i++, k--) {
			reversedString[i] = string[k];
		}
		return new String(reversedString);
	}

	private static void printPer(char[] string, int beg, int end) {
		if (beg == end) {
			System.out.println(new String(string));
			return;
		}
		for (int index = beg; index <= end; index++) {
			swap(string, index, beg);
			printPer(string, beg + 1, end);
			swap(string, index, beg);
			while (index + 1 < string.length && string[index] == string[index + 1]) {
				index++;
			}
		}
	}
}
