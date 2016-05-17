package com.kumanoit.strings;

import com.kumanoit.common.CommonUtils;
import com.kumanoit.utils.arrays.ArrayUtility;

public class Permutation {

	public static void main(String[] args) {
		String string = new String("AB");
//		printAllPermutation(string.toCharArray(), 0);
		printAllPermutationsWithRepetition(string.toCharArray(), string.length(), new char[string.length()], 0);
//		allLexicographicRecur(string.toCharArray(), new char[string.length()], string.length() - 1, 0);
	}

	private static void printAllPermutation(char[] string, int beg) {
		if (beg == string.length) {
			ArrayUtility.printArray(string);
			return;
		}
		for (int i = beg; i < string.length; i++) {
			CommonUtils.swapNumbers(string, i, beg);
			printAllPermutation(string, beg + 1);
			CommonUtils.swapNumbers(string, i, beg);
		}
	}

	private static void printAllPermutationsWithRepetition(char[] string,
		int end, char[] output, int level) {
		if (level == end) {
			System.out.println(new String(output));
			return;
		}
		for (int index = 0; index < end; index++) {
			output[level] = string[index];
			printAllPermutationsWithRepetition(string, end, output, level + 1);
		}
	}

	private static void allLexicographicRecur (char[] str, char[] data, int last, int index)
	{
	    int i, len = str.length;
	 
	    // One by one fix all characters at the given index and recur for 
	    // the/ subsequent indexes
	    for ( i=0; i<len; i++ )
	    {
	        // Fix the ith character at index and if this is not the last 
	        // index then recursively call for higher indexes
	        data[index] = str[i] ;
	 
	        // If this is the last index then print the string stored in
	        // data[]
	        if (index == last)
	            System.out.println(new String(data));
	        else // Recur for higher indexes
	            allLexicographicRecur (str, data, last, index+1);
	    }
	}
	 
}
