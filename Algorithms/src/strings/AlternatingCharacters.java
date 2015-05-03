package strings;
//https://www.hackerrank.com/challenges/alternating-characters/submissions/code/2771110
import java.util.Scanner;

public class AlternatingCharacters {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTestCase = in.nextInt();
		for (int i = 0; i < numberOfTestCase; i++) {
			String str = in.next();
			System.out.println(getMinRemovals(str));
		}
		in.close();
	}
	
	private static int getMinRemovals(String str) {
		int solution = 0;
		int len = str.length();
		int i = 0;
		while(i < len) {
			int j = i + 1;
			while(j < len && str.charAt(i) == str.charAt(j)) {
				j++;
			}
			solution += j - i - 1;
			i = j;
		}
		return solution;
	}

}
