package warmup;
//https://www.hackerrank.com/challenges/find-digits
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FindDigits {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTestCase = in.nextInt();
		if(numberOfTestCase < 1 || numberOfTestCase > 15) {
			System.exit(0);
		}
		for(int i = 0; i < numberOfTestCase; i++) {
			BigInteger n = in.nextBigInteger();
			if(n.compareTo(BigInteger.valueOf(Long.valueOf(1))) == -1 ||
			   n.compareTo(new BigInteger("1000000000")) == 1) {
					System.exit(0);
			}
			System.out.println(getNumberOfDigitsThatDivideNumber(n.toString()));
		}
		in.close();
	}
	
	private static int getNumberOfDigitsThatDivideNumber(String n) {
		int count = 0;
		Set<Integer> set = getSetOfNumberThatCanDivideNumber(n);
		for(int i = 0; i < n.length(); i++) {
			if(set.contains(n.charAt(i) - '0')) {
				count++;
			}
		}
		return count;
	}
	
	/*
	 * return a set that contains only those digits from 2 to 9 that can divide
	 * the given number
	 */
	private static Set<Integer> getSetOfNumberThatCanDivideNumber(String str) {
		Set<Integer> set = new HashSet<Integer>();
		BigInteger num = new BigInteger(str);

		//Divisibility test for 1
		set.add(1);
		
		//Divisibility test for 2
		for(int i = 2; i <= 9; i++) {
			if(num.mod(BigInteger.valueOf(i)) == BigInteger.ZERO) {
				set.add(i);
			}
		}
		return set;
	}
}
