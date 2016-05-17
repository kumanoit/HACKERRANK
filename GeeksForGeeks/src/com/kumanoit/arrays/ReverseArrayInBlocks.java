package com.kumanoit.arrays;

import com.kumanoit.common.CommonUtils;

public class ReverseArrayInBlocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static void reverse(int[] arr, int diff) {
		for (int i = 0; i < CommonUtils.gcd(arr.length, diff); i++) {
			int j = i;
			int k = -1;
			int temp = arr[j];
			while (k != i) {
				k = j + diff;
				if (k >= arr.length) {
					k = k % arr.length;
				}
				arr[k] = arr[j];
			}
		}
	}

	private static void method(int[] arr, int index, int oldValue, int k) {
		if (k <= 1) {
			return;
		}
		if (k > arr.length) {
			k = k % arr.length;
		}
		int newIndex = (index + k) % arr.length;
		
	}
}
