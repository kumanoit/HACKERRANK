/**
 * Maximum Sum Path in Two Arrays
Given two sorted arrays such the arrays may have some common elements. Find the sum of the maximum sum path to reach from beginning of any array to end of any of the two arrays. We can switch from one array to another array only at common elements.

Expected time complexity is O(m+n) where m is the number of elements in ar1[] and n is the number of elements in ar2[].

Examples:

Input:  ar1[] = {2, 3, 7, 10, 12}, ar2[] = {1, 5, 7, 8}
Output: 35
35 is sum of 1 + 5 + 7 + 10 + 12.
We start from first element of arr2 which is 1, then we
move to 5, then 7.  From 7, we switch to ar1 (7 is common)
and traverse 10 and 12.

Input:  ar1[] = {10, 12}, ar2 = {5, 7, 9}
Output: 22
22 is sum of 10 and 12.
Since there is no common element, we need to take all 
elements from the array with more sum.

Input:  ar1[] = {2, 3, 7, 10, 12, 15, 30, 34}
        ar2[] = {1, 5, 7, 8, 10, 15, 16, 19}
Output: 122
122 is sum of 1, 5, 7, 8, 10, 12, 15, 30, 34
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 19, 2015
 * MaximumSumPathIn2SortedArrays.java
 */
public class MaximumSumPathIn2SortedArrays {

	public static void main(String[] args) {
		int ar1[] = {2, 3, 7, 10, 12, 15, 30, 34};
		int ar2[] = {1, 5, 7, 8, 10, 15, 16, 19};
        System.out.println(getSolution(ar1, ar2));
        maxSumPath(ar1,ar1.length, ar2, ar2.length);
	}

	private static int getSolution(int[] a, int[] b) {
		int sumA = 0;
		int sumB = 0;
		int i = 0;
		int j = 0;
		int maxSum = 0;

		while(i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				sumA += a[i++];
			} else if(a[i] > b[j]) {
				sumB += b[j++];
			} else {
//				maxSum = Math.max(Math.max(sumA, sumB), maxSum) + a[i];
				maxSum = Math.max(sumA, sumB) + a[i];
				i++;
				j++;
				sumA = sumB = maxSum;
			}
		}
		while (i < a.length) {
			sumA += a[i++];
		}
		while (j < b.length) {
			sumB += b[j++];
		}
//		return Math.max(Math.max(sumA, sumB), maxSum);
		return Math.max(sumA, sumB);
	}


private static void maxSumPath(int a[], int n1, int b[], int n2) {
	int sum1 = 0;
	int sum2 = 0;
	int maxSum = 0;
	int i = 0;
	int j = 0;
	while(i < n1 && j < n2) {
		if (a[i] < b[j]) {
			sum1 += a[i++];
		} else if (a[i] > b[j]) {
			sum2 += b[j++];
		} else {
			maxSum = Math.max(sum1, sum2) + a[i];
//			printf("\nsum1 = %d\t, sum2 = %d\t maxSum = %d\t a = %d : b = %d",
//				sum1, sum2, maxSum, a[i], b[j]);
			sum1 = sum2 = maxSum;
			i++;
			j++;
		}
	}
	while(i < n1) {
		sum1 += a[i++];
	}

	while(j < n2) {
		sum2 += b[j++];
	}

	maxSum = Math.max(sum1, sum2);
	System.out.println("\nMaximum sum is = " + maxSum);
}

}
