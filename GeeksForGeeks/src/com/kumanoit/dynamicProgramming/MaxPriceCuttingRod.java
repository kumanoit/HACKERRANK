package com.kumanoit.dynamicProgramming;

public class MaxPriceCuttingRod {

	public static void main(String[] args) {
//		int price[]={1, 5, 8, 9, 10, 17, 17, 20}; // sol : 22
		int price[]={3, 5, 8, 9, 10, 17, 17, 20, 32, 3, 45}; // sol : 22
		System.out.println(getMaximumPriceRecursion(price, price.length));
		System.out.println(getMaximumPriceDP(price));
	}

	private static int getMaximumPriceRecursion(int[] price, int length) {
		if (length <= 0) {
			return 0;
		}
		if (length == 1) {
			return 0;
		}
		int maxPrice = 0;
		for (int i = 1; i < length; i++) {
			maxPrice = Math.max(
						maxPrice, 
						Math.max(price[i - 1] + getMaximumPriceRecursion(price, length - i),
								price[i - 1] + price[length - i - 1])
						);
		}
		return maxPrice;
	}

	private static int getMaximumPriceDP(int[] price) {
		int length = price.length;
		int[] mp = new int[length + 1];
		mp[0] = 0;
		mp[1] = 0; // if length of rod is 1 and cutting is compulsory then we can't cut
		for (int i = 2; i <= length; i++) {
			mp[i] = 0;
			for (int j = 1; j < i; j++) {
				mp[i] = Math.max(mp[i],
							Math.max(price[j - 1] + mp[i - j], price[j - 1] + price[i - j - 1])
						);
			}
		}
		return mp[length];
	}
}
