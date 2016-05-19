package challenges;

import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[]args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		int k = in.nextInt();
		System.out.println(getEncryptedString(n, s, k));
		in.close();
	}

	private static String getEncryptedString(int n, String str, int k) {
		String encryptedString = "";
		k = k % 26;
		for(int index = 0; index < str.length(); index++) {
			int ch = str.charAt(index);
			char newCh;
			if(ch >= 'a' && ch <= 'z') {
				if (ch + k > 'z') {
					newCh = (char) ((ch + k) % 'z' + 'a' - 1);
				} else {
					newCh = (char) (ch + k);
				}
			} else if(ch >= 'A' && ch <= 'Z') {
				if (ch + k > 'Z') {
					newCh = (char) ((ch + k) % 'Z' + 'A' - 1);
				} else {
					newCh = (char) (ch + k);
				}
			} else {
				newCh = (char) ch;
			}
			encryptedString += newCh;
		}
		return encryptedString;
	}
}
