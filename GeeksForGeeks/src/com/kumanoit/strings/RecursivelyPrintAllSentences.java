/**
 * Recursively print all sentences that can be formed from list of word lists
Given a list of word lists How to print all sentences possible taking one word from a list at a time via recursion?

Example:

Input: {{"you", "we"},
        {"have", "are"},
        {"sleep", "eat", "drink"}}

Output:
  you have sleep
  you have eat
  you have drink
  you are sleep
  you are eat
  you are drink
  we have sleep
  we have eat
  we have drink
  we are sleep
  we are eat
  we are drink 
 */
package com.kumanoit.strings;

import java.util.ArrayList;
import java.util.List;

public class RecursivelyPrintAllSentences {

	public static void main(String[] args) {
		List<List<String>> lists = new ArrayList<List<String>>();
		List<String> listA = new ArrayList<String>();
		listA.add("you");
		listA.add("we");

		List<String> listB = new ArrayList<String>();
		listB.add("have");
		listB.add("are");

		List<String> listC = new ArrayList<String>();
		listC.add("sleep");
		listC.add("drink");
		listC.add("eat");

		lists.add(listA);
		lists.add(listB);
		lists.add(listC);

		printRecursively(lists, new ArrayList<String> (), 0);
	}

	private static void printRecursively(List<List<String>> lists,
		List<String> output, int index) {
		if (index == lists.size()) {
			output.forEach(item -> System.out.print(item + "\t"));
			System.out.println();
			return;
		}

		List<String> list = lists.get(index);
		for (int i = 0; i < list.size(); i++) {
			output.add(list.get(i));
			printRecursively(lists, output, index + 1);
			output.remove(list.get(i));
		}
	}
}
