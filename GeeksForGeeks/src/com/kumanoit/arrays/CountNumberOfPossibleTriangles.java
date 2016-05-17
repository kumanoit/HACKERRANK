/**
 * Count the number of possible triangles
Given an unsorted array of positive integers. Find the number of triangles that 
can be formed with three different array elements as three sides of triangles. 
For a triangle to be possible from 3 values, the sum of any two values (or sides) 
must be greater than the third value (or third side).
For example, if the input array is {4, 6, 3, 7}, the output should be 3. 
There are three triangles possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}. 
Note that {3, 4, 7} is not a possible triangle.

As another example, consider the array {10, 21, 22, 100, 101, 200, 300}. 
There can be 6 possible triangles: {10, 21, 22}, {21, 100, 101}, {22, 100, 101}, 
{10, 100, 101}, {100, 101, 200} and {101, 200, 300}
 */
package com.kumanoit.arrays;

import java.util.Arrays;

/**
 * @author kumanoit Dec 20, 2015
 * CountNumberOfPossibleTriangles.java
 */
public class CountNumberOfPossibleTriangles {

	public static void main(String[] args) {
		int array[] = {10, 21, 22, 100, 101, 200, 300};
		System.out.println(getTriangleCount(array));
	}

	private static long getTriangleCount(int[] array) {
		Arrays.sort(array);
		int count = 0;
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = i+1; j < array.length; j++) {
				int k = array.length - 1;
				while(j < k) {
					int sum = array[i] + array[j];
					if (sum > array[k]) {
						count += k - j;
						for (int index = k; index > j; index--) {
							System.out.println(array[i] + "," + array[j]
								+ ", " + array[index]);
						}
						break;
					} else {
						k--;
					}
				}
			}
		}
		return count;
	}
}
