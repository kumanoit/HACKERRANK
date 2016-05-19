package companyProgrammingChallenges;



import java.util.Scanner;

public class TwoSetBitSum {

	private static final int MAX = 10000007;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number =in.nextInt();
		System.out.println(getSolution(number));
		System.out.println(getSolution2(number));
		in.close();
	}

	private static boolean getTotalSetBits(int number) {
		int setBitCount = 0;
		while (number > 0 && setBitCount < 3) {
			if ((number & 1) == 1) {
				setBitCount++;
			}
			number >>= 1;
		}
		return setBitCount == 2;
	}

	private static int getSolution(int number) {
		int sum = 0;
		for (int i = 2; i <= number; i++) {
			if(getTotalSetBits(i)) {
				sum = (sum + i) % MAX;
			}
		}
		return sum;
	}

	private static int getLeftmostSetBit(int number) {
		int count = 0;
		while(number > 0) {
			number >>= 1;
			count++;
		}
		return count;
	}

	private static long getPower(int base, int exponent) {
		if (base == 0 || base == 1) {
			return base;
		}
		if (exponent == 0) {
			return 1;
		}
		if(exponent == 1) {
			return base;
		}
		if ((base & 1) == 1) {
			return (base * getPower((base * base) % MAX, exponent / 2) % MAX);
		}
		return getPower((base * base) % MAX, exponent / 2) % MAX;
	}

	private static long getSolution2(int number) {
		int firstLeftMostSetBit = getLeftmostSetBit(number);
		int n = firstLeftMostSetBit - 1;
		long solution = 0;
		while(n > 1) {
			solution = (solution + (n * getPower(2, n - 1) - 1) % MAX) % MAX ;
			n--;
		}
		int newNumber = number ^ (1 << (firstLeftMostSetBit - 1));
		int secondLeftMostSetBit = getLeftmostSetBit(newNumber);
		while(secondLeftMostSetBit > 0) {
			solution = (solution + (1 << (firstLeftMostSetBit - 1) | 1 << (secondLeftMostSetBit - 1))) % MAX;
			secondLeftMostSetBit--;
		}
		return solution;
	}
}
