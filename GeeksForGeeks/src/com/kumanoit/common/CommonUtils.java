package com.kumanoit.common;

public class CommonUtils {

	public static long getCombination(int n, int r) {
		if (n < r) {
			return 0;
		}
		return getFactorial(n) / (getFactorial(r) * getFactorial(n - r));
	}

	public static long getFactorial(int n) {
		if (n <= 0) {
			return 1;
		}
		return n * getFactorial(n - 1);
	}

	public static void swapNumbers(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void swapNumbers(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static int getPalindrome(int a) {
		int result = 0;
		while (a > 0) {
			int remainder = a % 10;
			result = result * 10 + remainder;
			a /= 10;
		}
		return result;
	}

	public static int gcd(int a, int b) {
		if (a < b) {
			return gcd(b, a);
		}
		if (b == 0) {
			return a;
		}
		return gcd(b, a%b);
	}

}
