package warmup.eulersCriterion;
//https://www.hackerrank.com/challenges/eulers-criterion
import java.util.Scanner;

public class EulersCriterion {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numberOfTestCases = in.nextInt();
		for(int i = 0; i < numberOfTestCases; i++) {
			int a = in.nextInt();
			int m = in.nextInt();
			System.out.println(getSolution(a, m));
		}
		in.close();
	}
	
	private static String getSolution(int a, int m) {
		if(a == 0) {
			return "YES";
		}
		int flag = getModulus(a, (m - 1) / 2, m);
		if(flag == 1) {
			return "YES";
		} else {
			return "NO";
		}
	}

	private static int getModulus(long a, int n, int p) {
		if(a == 0) {
			return 0;
		}
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return (int) (a % p);
		}
		if(n % 2 == 0) 
			return getModulus((a * a) % p, n / 2, p);
		return (int) ((a * getModulus((a * a) % p, n / 2, p)) % p);
	}
}
