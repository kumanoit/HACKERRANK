package dynamicProgramming;

import java.util.Scanner;
public class StockMaximize {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfTestCases = in.nextInt();
		for(int i = 0; i < numberOfTestCases; i++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for(int j = 0; j < n; j++) {
				arr[i] = in.nextInt();
			}
			System.out.println(getMaximumStockPrice(arr));
		}
		in.close();
	}

//	private static long getMaximumStockPrice(int[] arr) {
//		return getMaximumStockPrice(arr, 0, arr.length - 1);
//	}

//	private static long getMaximumStockPrice(int[] arr, int i, int j) {
//		if(i == j) {
//			return 0;
//		}
//		int sum = arr[i];
//		long maxSum = Long.MIN_VALUE;
//		for(int k = i + 1; k <= j; k++) {
//			int temp = (k - i) * arr[k] - sum;
//			maxSum = Math.max(getMaximumStockPrice(arr, i, k - 1), Math.max(maxSum, temp));
//			sum += arr[k];
//		}
//		return maxSum;
//	}
//	
	private static long getMaximumStockPrice(int[] arr) {
		System.out.println("Getting solution");
		int len = arr.length;
		long[] m = new long[len + 1];
		long[] sum = new long[len + 1];
		m[0] = m[1] = 0;
		sum[0] = 0;
		sum[1] = arr[0];

		for(int i = 2; i <= len; i++) {
			m[i] = Long.MIN_VALUE;
			sum[i] = sum[i - 1] + arr[i - 1];
			for(int j = 0; j < i; j++) {
				m[i] = Math.max(m[i], m[j] + (i - j - 1) * arr[i - 1] - (sum[i - 1] - sum[j]));
			}
		}
		return m[len];
	}

}
