/**
 * Find a triplet that sum to a given value
Given an array and a value, find if there is a triplet in array whose sum is
 equal to the given value. If there is such a triplet present in array, 
 then print the triplet and return true. Else return false.
  For example, if the given array is {12, 3, 4, 1, 6, 9} and given sum is 24,
   then there is a triplet (12, 3 and 9) present in array whose sum is 24.
 */
package com.kumanoit.arrays;

import java.util.Arrays;

/**
 * @author kumanoit Dec 21, 2015
 * TripletSumToGivenValue.java
 */
public class TripletSumToGivenValue {

	public static void main(String[] args) {
		int[] array = {12, 3, 4, 1, 6, 9};
		int sum = 24;
		getTriplet(array, sum);
	}

	private static void getTriplet(int[] array, int SUM) {
        Arrays.sort(array);
        for(int i = 0; i < array.length; i++) {
            int start = i + 1;
            int last = array.length - 1;
            while(start < last) {
                int sum = array[i] + array[start] + array[last];
                if (sum < SUM) {
                    start++;
                } else if (sum > SUM) {
                    last--;
                } else {
                    System.out.println("Triplet : " + array[i] + " + " + 
                        array[start] + " + " + array[last] + " = " + sum);
                    start++;
                    last--;
                }
            }
        }
    }
}
