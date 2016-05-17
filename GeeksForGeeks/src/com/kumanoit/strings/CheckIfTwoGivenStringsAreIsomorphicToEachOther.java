/**
 * Check if two given strings are isomorphic to each other
Two strings str1 and str2 are called isomorphic if there is a one to one
 mapping possible for every character of str1 to every character of str2.
  And all occurrences of every character in 'str1' map to same character in 'str2'

Examples:

Input:  str1 = "aab", str2 = "xxy"
Output: True
'a' is mapped to 'x' and 'b' is mapped to 'y'.

Input:  str1 = "aab", str2 = "xyz"
Output: False
One occurrence of 'a' in str1 has 'x' in str2 and 
other occurrence of 'a' has 'y'.
 */
package com.kumanoit.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author kumanoit Jan 9, 2016
 * CheckIfTwoGivenStringsAreIsomorphicToEachOther.java
 */
public class CheckIfTwoGivenStringsAreIsomorphicToEachOther {

	public static void main(String[] args) {
		String str1 = "ababbbba";
		String str2 = "cdcddddc";
		System.out.println(isIsomorphic(str1, str2));
	}

	private static boolean isIsomorphic(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}

		Map<Character, Character> map = new HashMap<Character, Character>();
		Set<Character> visited = new HashSet<Character>();
		for (int i = 0; i < str1.length(); i++) {
			if (!map.keySet().contains(str1.charAt(i))) {
				if (visited.contains(str2.charAt(i))) {
					return false;
				}
				map.put(str1.charAt(i), str2.charAt(i));
			} else {
				if (!map.get(str1.charAt(i)).equals(str2.charAt(i))) {
					return false;
				}
			}
		}
		return true;
	}
}
