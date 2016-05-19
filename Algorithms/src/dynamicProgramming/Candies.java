//https://www.hackerrank.com/challenges/candies
package dynamicProgramming;

import java.util.Scanner;

public class Candies {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(getSolution(arr, arr.length, 0, 1));
		in.close();
	}
	
	private static long getSolution(int[] arr, int size, int index, int startVal) {

		if (index >= size) {
			return 0;
		}

		if (index == size - 1) {
			return startVal;
		}

		if(arr[index] < arr[index + 1]) {
			return startVal + getSolution(arr, size,index + 1, startVal + 1);
		} else if (arr[index] == arr[index + 1]) {
			return startVal + getSolution(arr, size, index + 1, 1);
		} else {
			int i = index;
			while (i + 1 < size && arr[i] > arr[i + 1]) {
				i++;
			}
			int n = i - index + 1;
			return n * (n + 1) / 2 + getSolution(arr, size, i + 1, 1);
		}
	}
}
