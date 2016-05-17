/**
 * Arrange given numbers to form the biggest number
Given an array of numbers, arrange them in a way that yields the largest value.
For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives
the largest value. And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4},
then the arrangement 998764543431 gives the largest value.

A simple solution that comes to our mind is to sort all numbers in descending order,
but simply sorting doesn’t work. For example, 548 is greater than 60, but in output 60
comes before 548. As a second example, 98 is greater than 9, but 9 comes before 98 in output.

So how do we go about it? The idea is to use any comparison based sorting algorithm. 
In the used sorting algorithm, instead of using the default comparison, write a comparison
function myCompare() and use it to sort numbers. Given two numbers X and Y, how should myCompare() decide which number to put first – we compare two numbers XY (Y appended at the end of X) and YX (X appended at the end of Y). If XY is larger, then X should come before Y in output, else Y should come before. For example, let X and Y be 542 and 60. To compare X and Y, we compare 54260 and 60542. Since 60542 is greater than 54260, we put Y first.
 */
package com.kumanoit.arrays;

import com.kumanoit.common.CommonUtils;
import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 20, 2015
 * ArrangeNumberToFormBiggestNumber.java
 */
public class ArrangeNumberToFormBiggestNumber {

	public static void main(String[] args) {
		int[] array = {1, 34, 3, 98, 9, 76, 45, 4};
		arrangeNumbers(array);
		ArrayUtility.printArray(array);
	}

	private static void arrangeNumbers(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (append(array[j],array[j + 1]) < append(array[j + 1], array[j])) {
					int temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
	}

	private static long append(int a, int b) {
		int result = a;
		int palinB = CommonUtils.getPalindrome(b);
		while (palinB > 0) {
			result = result * 10 + palinB % 10;
			palinB /= 10;
		}
		return result;
	}
}
