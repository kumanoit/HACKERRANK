/**
 * http://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
 */
package com.kumanoit.matrix;

import com.kumanoit.utils.arrays.ArrayUtility;

public class RotateMatrix {

	public static void main(String[] args) {
		int[][] mat = {	{1,2,3},
						{4,5,6},
						{7,8,9}
					};
		ArrayUtility.printMatrix(mat);
		rotateLeft(mat);
		ArrayUtility.printMatrix(mat);
	}

	private static void rotateLeft(int[][] mat) {
		int dim = mat.length;
		for (int k = 0; k < dim / 2; k++) {
			for (int i = k; i < dim - k - 1; i++) {
				int start_i = k;
				int start_j = i;
				int oldValue = mat[start_i][start_j];
				int iter_i = start_i;
				int iter_j = start_j;
				do {
					int next_i = dim - iter_j - 1;
					int next_j = iter_i;
					int nextValue = mat[next_i][next_j];
					mat[next_i][next_j] = oldValue;
					oldValue = nextValue;
					iter_i = next_i;
					iter_j = next_j;
				} while (!((start_i == iter_i) && (start_j == iter_j)));
			}
		}
	}
}
