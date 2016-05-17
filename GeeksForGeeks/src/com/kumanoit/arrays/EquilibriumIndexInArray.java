/**
 * Equilibrium index of an array
Equilibrium index of an array is an index such that the sum of elements at
 lower indexes is equal to the sum of elements at higher indexes. For example, in an arrya A:

A[0] = -7, A[1] = 1, A[2] = 5, A[3] = 2, A[4] = -4, A[5] = 3, A[6]=0

3 is an equilibrium index, because:
A[0] + A[1] + A[2] = A[4] + A[5] + A[6]

6 is also an equilibrium index, because sum of zero elements is zero, i.e.,
 A[0] + A[1] + A[2] + A[3] + A[4] + A[5]=0

7 is not an equilibrium index, because it is not a valid index of array A.

Write a function int equilibrium(int[] arr, int n); that given a sequence arr[]
 of size n, returns an equilibrium index (if any) or -1 if no equilibrium indexes exist.
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 21, 2015
 * EquilibriumIndexInArray.java
 */
public class EquilibriumIndexInArray {

	public static void main(String[] args) {
		int[][] array = {
				{-7, 1, 5, 2, -4, 3, 0}
		};
		for (int[] arr : array) {
			callMain(arr);
		}
	}

	private static void callMain(int[] array) {
		getEquilibriumIndex(array);
	}

	private static void getEquilibriumIndex(int[] arr) {
		int sum = 0;
		for(int index = 0; index < arr.length; index++) {
			sum += arr[index];
		}
		
		int leftSum = arr[0];
		for(int index = 1; index < arr.length; index++) {
			if (leftSum == (sum - leftSum - arr[index])) {
				System.out.println(index);
			}
			leftSum += arr[index];
		}
	}
}
