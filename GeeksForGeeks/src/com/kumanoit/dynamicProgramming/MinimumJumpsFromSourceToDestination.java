package com.kumanoit.dynamicProgramming;

public class MinimumJumpsFromSourceToDestination {

	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 0, 0, 2, 1, 1, 6, 8, 9};
		int source = 0;
		int destination = arr.length - 1;
		System.out.println("Recursive approach : "
				+ getMinimumJumpsRecursive(arr, source, destination));
		System.out.println("Recursive approach : " + getMinimumJumpsDP(arr));
	}

	private static int getMinimumJumpsRecursive(int[] arr, int source, int destination) {
		if (source >= destination) {
			return 0;
		}
		if (arr[source] == 0) {
			return Integer.MAX_VALUE;
		}
		int minJumps = Integer.MAX_VALUE;
		for (int i = 1; i <= arr[source]; i++) {
			minJumps = Math.min(minJumps,
				getMinimumJumpsRecursive(arr, source + i, destination));
		}
		return minJumps + 1;
	}

	private static int getMinimumJumpsDP(int[] arr) {
		int[] jumps = new int[arr.length];
		jumps[0] = 0;
		for (int i = 1; i < arr.length; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (j + arr[j] >= i) {// && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
				}
			}
		}
		return jumps[jumps.length - 1];
	}
}
