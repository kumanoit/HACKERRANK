/**
 * Given a set of time intervals in any order, merge all overlapping intervals
 *  into one and output the result which should have only mutually exclusive intervals.
 *   Let the intervals be represented as pairs of integers for simplicity. 
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }.
The intervals {1,3} and {2,4} overlap with each other, so they should be merged and become {1, 4}.
Similarly {5, 7} and {6, 8} should be merged and become {5, 8}

Write a function which produces the set of merged intervals for the given set of intervals.
 */
package com.kumanoit.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kumanoit Dec 20, 2015
 * MergeOverlappingIntervals.java
 */
public class MergeOverlappingIntervals {

	public static void main(String[] args) {
		List<Pair> pairs = new ArrayList<Pair>();
		pairs.add(new Pair(1, 3));
		pairs.add(new Pair(1, 72));
		pairs.add(new Pair(2, 4));
		pairs.add(new Pair(15, 17));
		pairs.add(new Pair(6, 8));
		pairs.add(new Pair(5, 7));
		pairs.forEach(System.out :: print);
		System.out.println();
		List<Pair> outputPairs = merge(pairs);
		System.out.println();
		outputPairs.forEach(System.out :: print);
	}

	private static List<Pair> merge(List<Pair> pairs) {
		Collections.sort(pairs);
		pairs.forEach(System.out :: print);
		List<Pair> outputPairs = new ArrayList<Pair>();
		Pair pair = new Pair(pairs.get(0));
		outputPairs.add(pair);
		for (int index = 1; index < pairs.size(); index++) {
			Pair newPair = pairs.get(index);
			if (newPair.getX() <= pair.getY()) {
				if (newPair.getY() < pair.getY()) {
					continue;
				} else if (newPair.getY() > pair.getY()) {
					pair.setY(newPair.getY());
				}
			} else {
				Pair nextPair = new Pair(newPair);
				outputPairs.add(nextPair);
				pair = nextPair;
			}
		}
		return outputPairs;
	}
}

class Pair implements Comparable {
	private int x;
	private int y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Pair(Pair pair) {
		this(pair.getX(), pair.getY());
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public int compareTo(Object obj) {
		if (obj instanceof Pair) {
			return this.x - ((Pair) obj).x;
		}
		return -1;
	}

	@Override
	public String toString() {
		return "{" + x  + ", " + y + "}";
	}
}
