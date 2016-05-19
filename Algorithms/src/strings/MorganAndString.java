package strings;
//https://www.hackerrank.com/challenges/morgan-and-a-string

import java.util.Scanner;
public class MorganAndString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTestCase = in.nextInt();
		for(int i = 0; i < numberOfTestCase; i++) {
			String strA = in.next();
			String strB = in.next();
			System.out.println(getSolution(strA, strB));
		}
		in.close();
	}
	
	private static StringBuilder getSolution(String strA, String strB) {
		StringBuilder strSolution = new StringBuilder("");
		int i = 0;
		int j = 0;
		while(i < strA.length() && j < strB.length()) {
			if(strA.charAt(i) < strB.charAt(j)) {
				strSolution.append(strA.charAt(i++));
			} else {
				strSolution.append(strB.charAt(j++));
			}
		}
		if(i == strA.length()) {
			if(j < strB.length()) {
				strSolution.append(strB.substring(j));
			}
		}
		if(j == strB.length()) {
			if(i < strA.length()) {
				strSolution.append(strA.substring(i));
			}
		}
		return strSolution;
	}
}
