package warmup.angryProfessor;
//https://www.hackerrank.com/challenges/angry-professor
import java.util.Scanner;

public class AngryProfessor {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTestCase = in.nextInt();
		if(numberOfTestCase < 1 || numberOfTestCase > 10) {
			System.exit(0);
		}
		for(int i = 0; i < numberOfTestCase; i++) {
			int n = in.nextInt();
			if(n < 1 || n > 1000) {
				System.exit(0);
			}
			int k = in.nextInt();
			if(k < 1 || k > n) {
				System.exit(0);
			}
			int[] time = new int[n];
			for(int j = 0; j < n; j++) {
				time[j] = in.nextInt();
			}
			System.out.println(getSolution(time, n, k));
		}
		in.close();
	}

	private static String getSolution(int[] time, int n, int k) {

		for(int i = 0; i < n; i++) {
			if(time[i] <= 0) {
				k--;
				if(k == 0) {
					return "NO";
				}
			}
		}
		return "YES";
	}
}
