/** http://www.geeksforgeeks.org/merge-one-array-of-size-n-into-another-one-of-size-mn/
 * 	Merge an array of size n into another array of size m+n
Asked by Binod
Question:
There are two sorted arrays. First one is of size m+n containing only m elements.
 Another one is of size n and contains n elements. 
 Merge these two arrays into the first array of size m+n such that the output is sorted.

Input: array with m+n elements (mPlusN[]).
MergemPlusNNA => Value is not filled/available in array mPlusN[].
There should be n such array blocks.

Input: array with n elements (N[]).
MergeN

Output: N[] merged into mPlusN[] (Modified mPlusN[])
MergemPlusN_Res
 */
package com.kumanoit.arrays;

import com.kumanoit.utils.arrays.ArrayUtility;

/**
 * @author kumanoit Dec 22, 2015
 * MergeArraySizeMIntoNSizedArray.java
 */
public class MergeArraySizeMIntoNSizedArray {

	public static void main(String[] args) {
		int mnarr[] = {2, -1, 7, -1, -1, 10, -1};
        int marr[] = {5, 8, 12, 14};
        ArrayUtility.printArray(mnarr);
        ArrayUtility.printArray(marr);
        merge(marr, mnarr);
        ArrayUtility.printArray(mnarr);
	}

	private static void merge(int[] marr, int[] mnarr) {
        int m = marr.length;
        int mn = mnarr.length;
        int n = mn - m;
        int last = mn - 1;
        for(int i = mn - 1; i >= 0 && last >= n; i--) {
            if (mnarr[i] != -1) {
                int temp = mnarr[i];
                mnarr[i] = mnarr[last];
                mnarr[last] = temp;
                last--;
            }
        }
        ArrayUtility.printArray(mnarr);
        int i = m;
        int j = 0;
        int k = 0;
        while (i < mn && j < m) {
            if (marr[j] < mnarr[i]) {
                mnarr[k++] = marr[j++];
            } else {
                mnarr[k++] = mnarr[i++];
            }
        }
        while (j < m) {
            mnarr[k++] = marr[j++];
        }
//        while (i < mn) {
//            mnarr[k++] = mnarr[i++];
//        }
    }
}
