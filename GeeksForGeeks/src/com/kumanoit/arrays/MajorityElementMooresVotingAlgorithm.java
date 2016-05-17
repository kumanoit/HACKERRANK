/**
 * Majority Element
Majority Element: A majority element in an array A[] of size n is an element
 that appears more than n/2 times (and hence there is at most one such element).

Write a function which takes an array and emits the majority element
 (if it exists), otherwise prints NONE as follows:

       I/P : 3 3 4 2 4 4 2 4 4
       O/P : 4 

       I/P : 3 3 4 2 4 4 2 4
       O/P : NONE
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 22, 2015
 * MajorityElementMooresLaw.java
 */
public class MajorityElementMooresVotingAlgorithm {

	public static void main(String[] args) {
		int[][] arrays = {{3, 3, 4, 2, 4, 4, 2, 4, 4},
				{3, 3, 4, 2, 4, 4, 2, 4}};
		for (int[] array : arrays) {
			callme(array);
		}
	}

	private static void callme(int[] arr) {
		getMajorityElement(arr);
	}

	private static void getMajorityElement(int[] arr) {
		int major = arr[0];
		int count = 1;
		for (int index = 1; index < arr.length; index++) {
			if (major == arr[index]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				major = arr[index];
				count = 1;
			}
		}
		count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == major) {
				count++;
			}
		}
		if(count > arr.length / 2) {
			System.out.println("Majority element is : " + major);
		} else {
			System.out.println("No majority element.");
		}
		
	}
}
