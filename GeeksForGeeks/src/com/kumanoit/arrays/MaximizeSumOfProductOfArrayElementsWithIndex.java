/**
 * Input: arr[] = {1, 20, 2, 10}
Output: 72
We can 72 by rotating array twice.
{2, 10, 1, 20}
20*3 + 1*2 + 10*1 + 2*0 = 72

Input: arr[] = {10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
Output: 330
We can 330 by rotating array 9 times.
{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
0*1 + 1*2 + 2*3 ... 9*10 = 330
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 18, 2015
 * MaximizeSumOfProductOfArrayElementsWithIndex.java
 */
public class MaximizeSumOfProductOfArrayElementsWithIndex {

	public static void main(String[] args) {
		int arr[] = {2, 10, 1, 20};
		getSolution(arr);
	}

	private static void getSolution(int[] arr) {
		int sum = 0;
		int prevSum = 0;
		int maxSum = 0;
		for (int index = 0; index < arr.length; index++) {
			sum += arr[index];
			prevSum += (index * arr[index]);
		}
		maxSum = prevSum;
		for (int index = arr.length - 1; index > 0; index--) {
			int newSum = prevSum + sum - arr[index] * arr.length;
			maxSum = Math.max(maxSum, newSum);
			prevSum = newSum;
		}
		System.out.println(maxSum);
	}
}
