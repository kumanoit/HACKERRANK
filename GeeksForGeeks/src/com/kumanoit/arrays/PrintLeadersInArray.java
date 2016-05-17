/**
 * http://www.geeksforgeeks.org/leaders-in-an-array/
 * Leaders in an array
Write a program to print all the LEADERS in the array. 
An element is leader if it is greater than all the elements to its right side.
And the rightmost element is always a leader. 
For example int the array {16, 17, 4, 3, 5, 2}, leaders are 17, 5 and 2.

Let the input array be arr[] and size of the array be size.
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 21, 2015
 * PrintLeadersInArray.java
 */
public class PrintLeadersInArray {

	public static void main(String[] args) {
		int[] array = {16, 17, 4, 3, 5, 2};
		printLeaders(array);
	}

	private static void printLeaders(int[] array) {
		int max = array[array.length - 1];
		System.out.println(max);
		for(int i = array.length - 2; i >= 0; i--) {
			if (array[i] > max) {
				System.out.println(array[i]);
				max = array[i];
			}
		}
	}
}
