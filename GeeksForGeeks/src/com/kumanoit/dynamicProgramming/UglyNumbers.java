/**
 * Ugly Numbers
Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, …
shows the first 11 ugly numbers. By convention, 1 is included.
Write a program to find and print the 150’th ugly number.
 */

package com.kumanoit.dynamicProgramming;

import java.util.Arrays;

public class UglyNumbers {

    public static void main(String[] args) {
        int n = 1000;
        System.out.println(getNthUglyNumber(n));
        System.out.println(getNthUglyNumberDP(n));
    }

    private static int getNthUglyNumber(int n) {
        int counter = 2;
        int uglyNumberCount = 1;
        while (uglyNumberCount != n) {
            if (isUgly(counter)) {
                uglyNumberCount++;
            }
            counter++;
        }
        return counter - 1;
    }

    private static boolean isUgly(int number) {
        int n = number;
        while (n % 2 == 0) {
            n /= 2;
        }
        while (n % 3 == 0) {
            n /= 3;
        }
        while (n % 5 == 0) {
            n /= 5;
        }
        return 1 == n;
    }

    private static int getNthUglyNumberDP(int n) {
        int[] uglyNumber = new int[n];
        uglyNumber[0] = 1;
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;
        int nextNum2 = uglyNumber[index_2] * 2;
        int nextNum3 = uglyNumber[index_3] * 3;
        int nextNum5 = uglyNumber[index_5] * 5;
        int nextUglyNumber = 1;
        for (int index = 1; index < n; index++) {
            nextUglyNumber = Math.min(nextNum2, Math.min(nextNum3, nextNum5));
            uglyNumber[index] = nextUglyNumber;
            if (nextUglyNumber == nextNum2) {
                index_2++;
                nextNum2 = uglyNumber[index_2] * 2;
            }
            if (nextUglyNumber == nextNum3) {
                index_3++;
                nextNum3 = uglyNumber[index_3] * 3;
            }
            if (nextUglyNumber == nextNum5) {
                index_5++;
                nextNum5 = uglyNumber[index_5] * 5;
            }
        }
        System.out.println(Arrays.toString(uglyNumber));
        return uglyNumber[n - 1];
    }
}
