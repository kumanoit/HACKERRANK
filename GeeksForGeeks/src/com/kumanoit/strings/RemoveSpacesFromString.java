/**
 * Remove spaces from a given string
Given a string, remove all spaces from the string and return it.

Input:  "g  eeks   for ge  eeks  "
Output: "geeksforgeeks"
 */
package com.kumanoit.strings;

/**
 * @author kumanoit Jan 10, 2016
 * RemoveSpacesFromString.java
 */
public class RemoveSpacesFromString {

	public static void main(String[] args) {
		String string = "g  eeks   for ge  eeks  ";
		System.out.println(">>>" + removeSpace(string) + "<<<");
	}

	private static StringBuilder removeSpace(String string) {
		StringBuilder str = new StringBuilder();
		for (int index = 0; index < string.length(); index++) {
			if (string.charAt(index) == ' ') {
				continue;
			}
			str.append(string.charAt(index));
		}
		return str;
	}
}
