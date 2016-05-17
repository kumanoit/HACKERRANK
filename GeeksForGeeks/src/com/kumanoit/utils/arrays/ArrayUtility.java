package com.kumanoit.utils.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kumanoit Dec 9, 2015
 * ArrayUtility.java
 */
public class ArrayUtility {

  /**
   * Prints your array.
   * @param arr
   */
  public static <E> void printArray(E[] arr) {
    for (E element : arr) {
      System.out.print(element + " ");
    }
    System.out.println();
  }

  public static <E> void printMatrix(E[][] matrix) {
	  for (E[] mat : matrix) {
		  printArray(mat);
	  }
  }

  public static <E> void printMatrix(int[][] matrix) {
	  for (int i = 0; i < matrix.length; i++) {
		  System.out.println();
		  for (int j = 0; j < matrix[i].length; j++) {
			  System.out.print(matrix[i][j] + "\t");
		  }
	  }
  }
  public static void printArray(int[] arr) {
	for (int index = 0; index < arr.length; index++) {
		System.out.print(arr[index] + " ");
	}
	System.out.println();
  }

  public static void printArray(char[] arr) {
	for (int index = 0; index < arr.length; index++) {
		System.out.print(arr[index] + " ");
	}
	System.out.println();
  }

  public static void reverse(int[] arr) {
	  for (int beg = 0, last = arr.length - 1; beg < last; beg++, last--) {
		  int temp = arr[beg];
		  arr[beg] = arr[last];
		  arr[last] = temp;
	  }
  }
}
