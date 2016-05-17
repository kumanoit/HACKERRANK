/**
 * Given a binary string, count number of substrings that start and end with 1.
Given a binary string, count number of substrings that start and end with 1. 
For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 18, 2015
 * CountStringStartingEndingOneInBinaryString.java
 */
public class CountStringStartingEndingOneInBinaryString {

	public static void main(String[] args) {
		int[] array = {0,0,1,0,0,1,0,1};
        getCountSubstringStartingEndingWithOne(array);
	}

	 private static void getCountSubstringStartingEndingWithOne(int[] arr) {
	        int oneCount = 0;
	        for (int index = 0; index < arr.length; index++) {
	            if(arr[index] == 1) {
	                oneCount++;;
	            }
	        }
	        oneCount--;
	        System.out.println(oneCount * (oneCount + 1) / 2);
	    }
}
