/**
 * Given an array of distinct integers and a sum value. Find count of triplets with sum smaller than given sum value. Expected Time Complexity is O(n2).

Examples:

Input : arr[] = {-2, 0, 1, 3}
        sum = 2.
Output : 2
Explanation :  Below are triplets with sum less than 2
               (-2, 0, 1) and (-2, 0, 3) 

Input : arr[] = {5, 1, 3, 4, 7}
        sum = 12.
Output : 4
Explanation :  Below are triplets with sum less than 12
               (1, 3, 4), (1, 3, 5), (1, 3, 7) and 
               (1, 4, 5)
 */
package com.kumanoit.arrays;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author kumanoit Dec 9, 2015
 * TripletWithSumLessThanGivenNumber.java
 */
public class CountTripletWithSumLessThanGivenNumber {

  public static void main(String[] args) {

    Scanner in = new Scanner(System.in);
    System.out.print("Enter size of array.");
    int lengthOfArray = in.nextInt();
    int[] arr = new int[lengthOfArray];
    for(int index = 0; index < lengthOfArray; index++) {
      System.out.print("Enter element " + ( 1 + index) + " : ");
      arr[index] = in.nextInt();
    }
    System.out.print("Enter maxSumLimit. ");
    int limit = in.nextInt();
    System.out.println("Maximum triplet from brute force approach is : " +  getSolution(arr, limit));
    System.out.println("Maximum triplet from smart approach is : " +  getSolutionBruteForce(arr, limit));
    in.close();
  }

 /**
   * A brute force attempt O(n^3)
   * @param arr
   * @param limit
   * @return
   */
  private static int getSolutionBruteForce(int arr[], int limit) {
      int length = arr.length;
      int count = 0;
      for(int i = 0; i < length - 2; i++) {
          for(int j = i + 1; j < length - 1; j++) {
              for(int k = j + 1; k < length; k++) {
                  if (arr[i] + arr[j] + arr[k] < limit) {
                      count++;
                  }
              }
          }
      }
      return count;
  }

  /**
   * first array is sorted O(nlg(n))
   * then loop is run O(n^2)
   * total complexity O(n^2)
   * @param arr
   * @param limit
   * @return
   */
  private static int getSolution(int[] arr, int limit) {
    int count = 0;
    int len = arr.length;
    Arrays.sort(arr);
    for(int index = 0; index < len - 2; index++) {
      int beg = index + 1;
      int last = len - 1;
      while(beg < last) {
        int sum = arr[index] + arr[beg] + arr[last];
        if (sum < limit) {
          count += (last - beg); // TODO : important step
          beg++;
//          last = len - 1;
        } else {
          last--;
        }
      }
    }
    return count;
  }

}
