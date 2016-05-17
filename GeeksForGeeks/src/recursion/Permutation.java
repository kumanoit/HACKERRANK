package recursion;

import java.util.Scanner;

public class Permutation {

	public static void main(String[] args) {
		String name = "/abc";
		String filePath = "hdfs://localhost/abc/def/ghi/jkl/mno";
		System.out.println(filePath.substring(filePath.indexOf(name)));
//		Scanner in = new Scanner(System.in);
//		String str = in.next();
//		permutation(str, 0, str.length() - 1);
//		in.close();
	}

	private static void permutation(String str, int start, int end) {
		if (start == end) {
			System.out.println(str);
			return;
		}
		for (int i = start; i <= end; i++) {
			String string = swap(str, i, start);
			permutation(string, start + 1, end);
		}
	}

	private static String swap(String str, int i, int j) {
		String newString = str.substring(0,i);
		newString += str.charAt(j);
		newString += str.substring(i + 1, j);
		newString += str.charAt(i);
		newString += str.substring(j + 1, str.length());
		return newString;
	}
}
