/**
 * The cost of a stock on each day is given in an array, find the max profit that
 *  you can make by buying and selling in those days. 
 *  For example, if the given array is {100, 180, 260, 310, 40, 535, 695},
 *  the maximum profit can earned by buying on day 0, selling on day 3.
 *  Again buy on day 4 and sell on day 6. If the given array of prices is sorted in decreasing order,
 *  then profit cannot be earned at all.

If we are allowed to buy and sell only once, then we can use following algorithm.
 Maximum difference between two elements. Here we are allowed to buy and sell multiple times.
  Following is algorithm for this problem.
1. Find the local minima and store it as starting index. If not exists, return.
2. Find the local maxima. and store it as ending index.
 If we reach the end, set the end as ending index.
3. Update the solution (Increment count of buy sell pairs)
4. Repeat the above steps if end is not reached.
 */
package com.kumanoit.arrays;

/**
 * @author kumanoit Dec 20, 2015
 * StockBuySellMaximiseProfit.java
 */
public class StockBuySellMaximiseProfit {

	public static void main(String[] args) {
		int[] array = {5, 4, 3, 2, 1};
		maximiseProfit(array);
	}

	private static void maximiseProfit(int[] array) {
		int profit= 0;
		int start = 0;
		int end = 0;
		int buy = 0;
		while(end < array.length) {
			if(((end + 1 < array.length && array[end] > array[end + 1]) ||
					(end + 1 == array.length)) && buy != end) {
				System.out.print("Buy : = " + buy);
				System.out.println(" Sell : = " + end);
				buy = end + 1;
			}
			end++;
		}
	}
}
