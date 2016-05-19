package strings;

import java.util.Scanner;

public class ReverseShuffleMerge {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in.next();
		System.out.println(getSolution(str));
		in.close();
	}

	private static String getSolution(String str) {
		int[] count = new int[26];
		for(int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'a']++;
		}

		String result = "";
		for(int i = 0; i < 26; i++) {
			for(int j = 0; j < count[i] / 2; j++) {
				result = result + (char)('a' + i);
			}
		}
		return result;
	}
}
