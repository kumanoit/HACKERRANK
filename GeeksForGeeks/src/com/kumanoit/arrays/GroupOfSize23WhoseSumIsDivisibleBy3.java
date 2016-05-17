/**
 * Count all possible groups of size 2 or 3 that have sum as multiple of 3
Given an unsorted integer (positive values only) array of size ‘n’, we can form a group of two or three, the group should be such that the sum of all elements in that group is a multiple of 3. Count all possible number of groups that can be generated in this way.

Input: arr[] = {3, 6, 7, 2, 9}
Output: 8
// Groups are {3,6}, {3,9}, {9,6}, {7,2}, {3,6,9},
//            {3,7,2}, {7,2,6}, {7,2,9}


Input: arr[] = {2, 1, 3, 4}
Output: 4
// Groups are {2,1}, {2,4}, {2,1,3}, {2,4,3}
 */
package com.kumanoit.arrays;

import com.kumanoit.common.CommonUtils;

/**
 * @author kumanoit Dec 20, 2015
 * GroupOfSize23WhoseSumIsDivisibleBy3.java
 */
public class GroupOfSize23WhoseSumIsDivisibleBy3 {

	public static void main(String[] args) {
		int[] array = {3, 6, 7, 2, 9};
		System.out.println(getCount(array));
	}

	private static long getCount(int[] array) {
		int one = 0;
		int two = 0;
		int three = 0;

		for (int index = 0; index < array.length; index++) {
			if (array[index] % 3 == 0) {
				three++;
			} else if (array[index] % 3 == 2) {
				two++;
			} else {
				one++;
			}
		}

		return CommonUtils.getCombination(three, 3)
				+ CommonUtils.getCombination(two, 3)
				+ CommonUtils.getCombination(one, 3)
				+ (CommonUtils.getCombination(one, 1) * CommonUtils.getCombination(two, 1) * CommonUtils.getCombination(three, 1))
				+ CommonUtils.getCombination(three, 2)
				+ (CommonUtils.getCombination(two, 1) * CommonUtils.getCombination(one, 1));
	}
}
