package com.kumanoit.common;

public class PrintAllPaths {

	private void printPaths(int[][] mat, int m, int n, int i, int j, int[] path, int po)
	{
		if(i==m)
		{
			for(int k=j+1; k<n; k++)
				path[po++]=mat[i-1][k];
			printPath(path, po);
			return;
		}
		if(j==n)
		{
			for(int k=i+1; k<m; k++)
				path[po++]=mat[k][j-1];
			printPath(path, po);
			return;
		}
		path[po] = mat[i][j];
		printPaths(mat, m, n, i+1, j, path, po+1);
		printPaths(mat, m, n, i, j+1, path, po+1);
		
	}
	private void printPath(int[] path, int po) {
		System.out.println("Path is :");
		for(int i=0;i<=po;i++)
			System.out.print(" "+path[i]);
		System.out.println();
	}
	public static void main(String[] args) {
		 int mat[][] = { {1, 2, 3}, {4, 5, 6} };
		 int[] path = new int[5];
		 PrintAllPaths allPaths = new PrintAllPaths();
		 allPaths.printPaths(mat, 2, 3, 0, 0, path, 0);
	}

}