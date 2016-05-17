package com.kumanoit.arrays;

public class CountStrictlyIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = {4, 3, 2, 1};
		System.out.println("Total count is : " + getCount(arr));
	}

	private static int getCount(int[] arr) {
		int len = 1;
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				len++;
			} else {
				count += (len * (len - 1)) / 2;
				len = 1;
			}
		}
		if (len > 1) {
			count += (len * (len - 1)) / 2;
		}
		return count;
	}
}
