/**
 * Given an array of integers print the missing elements that lie in range 0-99. If there are more than one missing, collate them, otherwise just print the number.

Note that the input array may not be sorted and may contain numbers outside the range [0-99], but only this range is to be considered for printing missing elements.

Examples

     Input: {88, 105, 3, 2, 200, 0, 10}
     Output: 1
             4-9
             11-87
             89-99


     Input: {9, 6, 900, 850, 5, 90, 100, 99}
     Output: 0-4
             7-8
             10-89
             91-98
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 18, 2015
 * PrintMissingElementFromZeroToNinetyNine.java
 */
public class PrintMissingElementFromZeroToNinetyNine {

	public static void main(String[] args) {
		int[] array = {88, 105, 3, 2, 200, 0, 10};
		getSolution(array);
	}

	private static void getSolution(int[] array) {
		int[] map = new int[100];
		for (int i = 0; i < array.length; i++) {
			if(array[i] < 0 || array[i] > 99) {
				continue;
			}
			map[array[i]] = 1;
		}
		int iter = 0;
		while(iter < 100) {
			if (map[iter] == 1) {
				iter++;
				continue;
			}
			int beg = iter + 1;
			while(beg < map.length && map[beg] == 0) {
				beg++;
			}
			if (iter + 1 < beg) {
				System.out.println(iter + "-" + (beg-1));
			} else {
				System.out.println(iter);
			}
			iter = beg;
		}
	}
}
