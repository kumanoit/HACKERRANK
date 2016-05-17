/**
 * Given three arrays sorted in non-decreasing order, print all common elements in these arrays.

Examples:

ar1[] = {1, 5, 10, 20, 40, 80}
ar2[] = {6, 7, 20, 80, 100}
ar3[] = {3, 4, 15, 20, 30, 70, 80, 120}
Output: 20, 80

int ar1[] = {1, 5, 5}
int ar2[] = {3, 4, 5, 5, 10}
int ar3[] = {5, 5, 10, 20}
Output: 5, 5
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 19, 2015
 * CommonElementsThreeSortedArrays.java
 */
public class CommonElementsThreeSortedArrays {

	public static void main(String[] args) {
		int ar1[] = {1, 5, 5};
		int ar2[] = {3, 4, 5, 5, 10};
		int ar3[] = {5, 5, 10, 20};
		getCommonElement(ar1, ar2, ar3);
	}

	private static void getCommonElement(int[] a, int[] b, int[] c) {
		int[] output = new int[Math.min(Math.min(a.length, b.length), c.length)];
		int i = 0;
		int j = 0;
		int k = 0;
		int m = 0;
		while(i < a.length && j < b.length && k < c.length) {
			if (a[i] == b[j] && b[j] == c[k]) {
				output[m++] = a[i];
				i++; j++; k++;
			} else if (a[i] < b[j]) {
				i++;
			} else if (b[j] < c[k]) {
				j++;
			} else {
				k++;
			}
		}
		for(int index = 0; index < m; index++) {
			System.out.print(output[index] + "\t");
		}
	}
}
