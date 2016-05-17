/**
 * http://www.geeksforgeeks.org/reorder-a-array-according-to-given-indexes/
 * Given two integer arrays of same size, “arr[]” and “index[]”, reorder elements in “arr[]” according to given index array. It is not allowed to given array arr’s length.

Example:

Input:  arr[]   = [10, 11, 12];
        index[] = [1, 0, 2];
Output: arr[]   = [11, 10, 12]
        index[] = [0,  1,  2] 

Input:  arr[]   = [50, 40, 70, 60, 90]
        index[] = [3,  0,  4,  1,  2]
Output: arr[]   = [40, 60, 90, 50, 70]
        index[] = [0,  1,  2,  3,   4] 
Expected time complexity O(n) and auxiliary space O(1)
*/
package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 13, 2015
 * ReorderArrayAccordingToOtherIndexArray.java
 */

public class ReorderArrayAccordingToOtherIndexArray {

  public static void main(String[] args) {
    Integer[] array = {50, 40, 70, 60, 90};//{40, 60, 90, 50, 70};//{10, 11, 12};//
    Integer[] index = {3,  0,  4,  1,  2};//{0,  1,  2,  3,   4};//{1, 0, 2};//
    ArrayUtility.printArray(array);
//    getSolution(array, index);
    getSolution2(array, index);
    ArrayUtility.printArray(array);
  }

  private static void getSolution(Integer[] array, Integer[] index) {
    for(int i = 0; i < index.length; i++) {
      if (index[i] != -1) {
        getSolution(array, index, index[i], array[i]);
      }
    }
  }
  private static void getSolution(Integer[] array, Integer[] index,
    int newIndex, int newValue) {
    if (newIndex == -1) {
      return;
    }

    int nextLocation = index[newIndex];
    int nextValue = array[newIndex];
    array[newIndex] = newValue;
    index[newIndex] = -1;
    getSolution(array, index, nextLocation, nextValue);
  }

  private static void getSolution2(Integer[] array, Integer[] indices) {
	  for(int index = 0; index < array.length; index++) {
		  transform(array, indices, index, array[index]);
	  }
  }

  private static void transform(Integer[] arr, Integer[] indices, int index, int oldValue) {
	  int newIndex = indices[index];
	  if (newIndex < 0) {
		  return;
	  }
	  int newValue = arr[newIndex];
	  arr[newIndex] = oldValue;
	  indices[index] = -1;
	  transform(arr, indices, newIndex, newValue);
  }
}
