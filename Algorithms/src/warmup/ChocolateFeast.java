package warmup;
//https://www.hackerrank.com/challenges/chocolate-feast
import java.util.Scanner;

public class ChocolateFeast {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTestCase = in.nextInt();
		if(numberOfTestCase < 1 || numberOfTestCase > 1000) {
			System.exit(0);
		}

		for(int i = 0; i < numberOfTestCase; i++) {
			int n = in.nextInt();
			int c = in.nextInt();
			int m = in.nextInt();
			if(n < 2 || n > 100000) {
				System.exit(0);
			}
			if(c < 1 || c > n) {
				System.exit(0);
			}
			if(m < 2 || m > n) {
				System.exit(0);
			}
			System.out.println(getTotalNumberOfChocolates(n, c, m));
		}
		in.close();
	}
	
	private static int getTotalNumberOfChocolates(int n, int c, int m) {
		int numChocolatesEaten = n / c;
		int wrapperRemaining = numChocolatesEaten;
		while(wrapperRemaining >= m) {
			int newChocolatesEaten = wrapperRemaining / m;
			wrapperRemaining = wrapperRemaining % m + newChocolatesEaten;
			numChocolatesEaten += newChocolatesEaten;
		}
		return numChocolatesEaten;
	}

}
