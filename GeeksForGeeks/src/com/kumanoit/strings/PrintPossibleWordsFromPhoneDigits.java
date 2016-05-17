/**
 * Print all possible words from phone digits
Before advent of QWERTY keyboards, texts and numbers were placed on the
 same key. For example 2 has “ABC” if we wanted to write anything starting 
 with ‘A’ we need to type key 2 once. If we wanted to type ‘B’, press key 2 
 twice and thrice for typing ‘C’. below is picture of such keypad.
 */
package com.kumanoit.strings;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Jan 17, 2016
 * PrintPossibleWordsFromPhoneDigits.java
 */
public class PrintPossibleWordsFromPhoneDigits {

	public static void main(String[] args) {
		String[] words = {"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
		int num = 123;
		int[] number = getNumberArray(num);
		printPossibleWords(words, 0, number, new char[number.length]);
	}

	private static void printPossibleWords(String[] words, int index, int[] number, char[] output) {
		if (index == number.length) {
			ArrayUtility.printArray(output);
			return;
		}
		if (words[number[index]].length() == 0) {
			output[index] = ' ';
			printPossibleWords(words, index + 1, number, output);
			return;
		}
		
		for(int i = 0; i < words[number[index]].length(); i++) {
			output[index] = words[number[index]].charAt(i);
			printPossibleWords(words, index + 1, number, output);
		}
	}

	private static int[] getNumberArray(int num) {
		int len = 0;
		int temp = num;
		while(temp > 0) {
			len++;
			temp /= 10;
		}
		int[] number = new int[len];
		temp = num;
		int i = len - 1;
		while(temp > 0) {
			number[i--] = temp % 10;
			temp /= 10;
		}
		return number;
	}
}
