package com.kumanoit.arrays;

import java.util.Arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 18, 2015
 * PythagoreanTriplet.java
 */
public class PythagoreanTriplet {

	public static void main(String[] args) {
		int[] array = {10, 4, 6, 12, 5, 3, 13};
		findPythagoreanTriplet(array);
	}

	private static void findPythagoreanTriplet(int[] array) {
		Arrays.sort(array);
		int[] sqarray = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			sqarray[i] = array[i] * array[i];
		}

		ArrayUtility.printArray(array);
		ArrayUtility.printArray(sqarray);
		for (int i = array.length - 1; i > 1; i--) {
			int secondLast = i - 1;
			int beg = 0;
			while (beg < secondLast) {
				int sum = sqarray[beg] + sqarray[secondLast];
				if (sum == sqarray[i]) {
					System.out.println(array[i] + " = " + array[beg]
						+ " + " + array[secondLast]);
					beg++;
					secondLast--;
				} else if (sum > sqarray[i]) {
					secondLast--;
				} else {
					beg++;
				}
			}
		}
	}
}
