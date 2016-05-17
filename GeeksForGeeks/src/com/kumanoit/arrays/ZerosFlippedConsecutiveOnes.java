/**
 * Find zeroes to be flipped so that number of consecutive 1’s is maximized
Given a binary array and an integer m, find the position of zeroes flipping which creates maximum number of consecutive 1s in array.

Examples:

Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
         m = 2
Output:  5 7
We are allowed to flip maximum 2 zeroes. If we flip
arr[5] and arr[7], we get 8 consecutive 1's which is
maximum possible under given constraints 

Input:   arr[] = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1}
         m = 1
Output:  7
We are allowed to flip maximum 1 zero. If we flip 
arr[7], we get 5 consecutive 1's which is maximum 
possible under given constraints.

Input:   arr[] = {0, 0, 0, 1}
         m = 4
Output:  0 1 2
Since m is more than number of zeroes, we can flip
all zeroes.
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 9, 2015
 * ZerosFlippedConsecutiveOnes.java
 */
public class ZerosFlippedConsecutiveOnes {

  public static void main(String[] args) {
//    Scanner in = new Scanner(System.in);
//    int size = in.nextInt();
//    int[] arr = new int[size];
//    for(int index = 0; index < size; index++) {
//      arr[index] = in.nextInt();
//    }
    int[] arr = {1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1};
    int size = arr.length;
    int zeroCount = 1;
    getOptimizedSolution(arr, zeroCount);
    System.out.println("Brute force approach : " + getBruteForceSolution(arr, zeroCount));
//    in.close();
  }

  private static void getOptimizedSolution(int[] arr, int m) {
    int left = 0;
    int right = 0;
    int zeroCount = 0;
    int finalLeft = -1;
    int finalRight = -1;
    int maxLength = -1;

    while(right < arr.length) {
      if (arr[right] == 0) {
        zeroCount++;
        if (zeroCount > m) {
          while(arr[left] != 0) {
            left++;
          }
          left++;
          zeroCount--;
        }
      }
      if (maxLength < (right - left + 1)) {
        maxLength = right - left + 1;
        finalLeft = left;
        finalRight = right;
      }
      right++;
    }
    System.out.println("Max length is " + (finalRight - finalLeft + 1));
    System.out.println("Postion of zeros to be flipped.");
    for (int index = finalLeft; index <= finalRight; index++) {
      if(arr[index] == 0) {
        System.out.print((index + 1) + "\t");
      }
    }
    System.out.println();
  }

  /**
   * O(n^2)
   * @param arr
   * @param zeroLimit
   * @return
   */
  private static int getBruteForceSolution(int[] arr, int zeroLimit) {
    int maxLength = -1;
    int i;
    int j;
    for (i = 0; i < arr.length - 1; i++) {
      int zeroCount = (arr[i] == 0) ? 1 : 0;
      for (j = i+1; j < arr.length; j++) {
        if (zeroCount > zeroLimit) {
          break;
        }
        if (arr[j] == 0) {
          zeroCount++;
        }
      }
      maxLength = Math.max(maxLength, j - i);
    }
    return maxLength;
  }
}
