package warmup.halloweenParty;
//https://www.hackerrank.com/challenges/halloween-party
import java.math.BigInteger;
import java.util.Scanner;

public class HalloweenParty {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int numberOfTestCase = in.nextInt();
		if(numberOfTestCase < 1 || numberOfTestCase > 10) {
			System.exit(0);
		}
		
		for(int i = 0; i < numberOfTestCase; i++) {
			int  num = in.nextInt();
			if(num < 2|| num > 10000000) {
				System.exit(0);
			}
			System.out.println(getMaxPieces(num));
		}
		in.close();
	}
	private static BigInteger getMaxPieces(int n) {
		BigInteger a = BigInteger.valueOf(n / 2);
		BigInteger b = BigInteger.valueOf(n - n/2);
		return a.multiply(b);
	}
}
