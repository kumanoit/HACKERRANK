package com.kumanoit.strings;

public class RunLengthEncoding {

	public static void main(String[] args) {
		String string = "wwwwaaadexxxxxx";
		getEncoding(string);
	}

	private static void getEncoding(String string) {
		int end = 0;
		StringBuilder strbuilder = new StringBuilder();
		while (end < string.length()) {
			strbuilder.append(string.charAt(end));
			int count = 1;
			while (end + 1 < string.length() && string.charAt(end) == string.charAt(end + 1)) {
				count++;
				end++;
			}
			end++;
			strbuilder.append(count);
		}
		System.out.println(strbuilder);
	}
}
