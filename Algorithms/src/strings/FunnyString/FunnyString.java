package strings.FunnyString;
//https://www.hackerrank.com/challenges/funny-string
import java.util.Scanner;

public class FunnyString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTestCase = in.nextInt();
		for (int i = 0; i < numberOfTestCase; i++) {
			String str = in.next();
			getSolution(str);
		}
		in.close();
	}
	
	private static void getSolution(String str) {
		int len = str.length();
		int i = 0;
		int j = len - 1;
		boolean flag = true;
		while (i < len - 1) {
			int diff1 = Math.abs(str.charAt(i + 1) - str.charAt(i));
			int diff2 = Math.abs(str.charAt(j - 1) - str.charAt(j)); 
//			System.out.println(diff1 + "\t" + diff2);
			if (diff1 != diff2) {
				flag = false;
				break;
			}
			i++;
			j--;
		}
		if (flag) {
			System.out.println("Funny");
		} else {
			System.out.println("Not Funny");
		}
	}

}
