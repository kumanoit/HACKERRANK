/**
 * Input: arr[]   = {2, 0, 2}
Output: 2
Structure is like below
| |
|_|
We can trap 2 units of water in the middle gap.

Input: arr[]   = {3, 0, 0, 2, 0, 4}
Output: 10
Structure is like below
     |
|    |
|  | |
|__|_| 
We can trap "3*2 units" of water between 3 an 2,
"1 unit" on top of bar 2 and "3 units" between 2 
and 4.  See below diagram also.

Input: arr[] = [0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1]
Output: 6
       | 
   |   || |
_|_||_||||||
Trap "1 unit" between first 1 and 2, "4 units" between
first 2 and 3 and "1 unit" between second last 1 and last 2 
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 18, 2015
 * TrappingRainWater.java
 */
public class TrappingRainWater {

	
	public static void main(String[] args) {

		int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		getTrappedWater(arr);
	}

	private static void getTrappedWater(int[] arr) {
		int[] left = new int[arr.length];
		int[] right = new int[arr.length];
		int trappedWater = 0;

		left[0] = arr[0];
		for (int i = 1; i < arr.length; i++) {
			left[i] = Math.max(left[i - 1], arr[i]);
		}

		right[arr.length - 1] = arr[arr.length - 1];
		for (int i = arr.length - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], arr[i]);
		}

		for (int i = 0; i < arr.length; i++) {
			trappedWater += Math.min(left[i], right[i]) - arr[i];
		}

		System.out.println(trappedWater);
	}
}
