package com.kumanoit.arrays;

public class SubArraySizeKMaximumAverage {

	public static void main(String[] args) {
		int[] arr = {1, 12, -5, -6, 50, 3};
		int k = 4;
		getAverage(arr, k);
	}

	private static double getAverage(int[] arr, int k) {
		long sum = 0;
		long maxSum;
		int begIndex = 0;
		int endIndex = k - 1;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}
		maxSum = sum;
		int beg = 0;
		int last = k;
		while (last < arr.length) {
			long newSum = sum + arr[last] - arr[beg];
			if (maxSum < newSum) {
				maxSum = newSum;
				begIndex = beg + 1;
				endIndex = last;
			}
			last++;
			beg++;
		}
		System.out.println("Starting index : " + begIndex);
		System.out.println("Ending index :   " + endIndex);
		return (double) maxSum / k;
	}
}
