package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

public class SegregateEvenOdd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		segregateEvenOdd(new int[]{12, 34, 45, 9, 8, 90, 3});
	}

	private static void segregateEvenOdd(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		ArrayUtility.printArray(arr);
		while (left < right) {
			if ((arr[left] & 1) == 0) {
				left++;
			} else if ((arr[right] & 1) == 1) {
				right--;
			} else {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		ArrayUtility.printArray(arr);
	}
}
