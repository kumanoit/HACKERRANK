package com.kumanoit.arrays;

public class MinimumNumberOfMergeOperationsToMakePalindrome {

	public static void main(String[] args) {
		int arr[] = {1, 4, 1};
		System.out.println("Minimum number of operations required is = " + getMinOperations(arr, 0, arr.length - 1));
	}

	private static int getMinOperations(int[] arr, int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (arr[i] == arr[j]) {
			return getMinOperations(arr, i + 1, j - 1);
		}
		if (arr[i] > arr[j]) {
			arr[j - 1] += arr[j];
			return 1 + getMinOperations(arr, i, j - 1);
		}
		arr[i+1] += arr[i];
		return 1 + getMinOperations(arr, i + 1, j);
	}
}
