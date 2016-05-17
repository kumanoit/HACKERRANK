package com.kumanoit.arrays;

public class CountZerosToBeFlipped {

	public static void main(String[] args) {
		int[] arr = {0, 0, 0, 1};
		int k = 4;
		System.out.println("\nLargest subarray size is " + getCount(arr, k));
	}

	private static int getCount(int[] arr, int k) {
		int start = 0;
		int zeroCount = 0;
		int maxLength = -1;
		for (int index = 0; index < arr.length; index++) {
			if (arr[index] == 0) {
				zeroCount++;
			}
			if (zeroCount > k) {
				while (arr[start] == 1) {
					start++;
				}
				start++;
				zeroCount--;
			}
			maxLength = Math.max(maxLength, index - start + 1);
		}
		return maxLength;
	}
}
