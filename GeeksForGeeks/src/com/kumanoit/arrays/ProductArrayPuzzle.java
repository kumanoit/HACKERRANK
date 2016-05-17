/**
 * A Product Array Puzzle
Given an array arr[] of n integers, construct a Product Array prod[] 
(of same size) such that prod[i] is equal to the product of all the elements of arr[] except arr[i]. Solve it without division operator and in O(n).

Example:
arr[] = {10, 3, 5, 6, 2}
prod[] = {180, 600, 360, 300, 900}
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 21, 2015
 * ProductArrayPuzzle.java
 */
public class ProductArrayPuzzle {

	public static void main(String[] args) {
		int[] arr = {10, 3, 5, 6, 2};
		getProductArray(arr);
	}

	private static void getProductArray(int[] array) {
		int[] left = new int[array.length];
		int[] right = new int[array.length];

		left[0] = 1;
		for (int index = 1; index < array.length; index++) {
			left[index] = left[index - 1] * array[index - 1];
		}

		right[array.length - 1] = 1;
		for (int index = array.length - 2; index >= 0; index--) {
			right[index] = right[index + 1] * array[index + 1];
		}

		for (int index = 0; index < array.length; index++) {
			System.out.print(left[index] * right[index] + " ");
		}
	}
}
