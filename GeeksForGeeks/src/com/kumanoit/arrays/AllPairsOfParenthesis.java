/**
 * Print all combinations of n number of parenthesis
 */
package com.kumanoit.arrays;

import java.util.Scanner;

/**
 * @author kumanoit Dec 9, 2015
 * AllPairsOfParenthesis.java
 */
public class AllPairsOfParenthesis {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int size = in.nextInt();
    printParenthesis(size, 0, new char[size * 2], 0);
    in.close();
  }

  /**
   * prints all combinations of n parenthesis
   * @param open
   * @param closed
   * @param output
   * @param level
   */
  private static void printParenthesis(int open, int closed,
    char[] output, int level) {
    if (open == 0 && closed == 0) {
      for (char ch : output) {
        System.out.print(ch);
      }
      System.out.println();
    }

    if (open > 0) {
      output[level] = '(';
      printParenthesis(open - 1, closed + 1, output, level + 1);
    }

    if (closed > 0) {
      output[level] = ')';
      printParenthesis(open, closed - 1, output, level + 1);
    }
  }
}
