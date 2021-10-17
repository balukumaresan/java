package com.balu.gl.algorithms.skyscraper.analyzer.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * Analyze the passed in floor sizes and gives the suggestion when can the floor
 * can be assembled
 * 
 * @author baluk
 *
 */
public class SkyScraperAnalyzer {

	private Stack<Integer> stack;

	public void analyze2(List<Integer> floorSizes) {

		List<Integer> sortedList = sortedList(floorSizes);
		int max = sortedList.get(0);
		int day = 0;
		for (int i = 0; i < floorSizes.size(); i++) {
			day = day + 1;
			System.out.println("");
			System.out.println("Day: " + day);
			int current = floorSizes.get(i);
			if (current == max) {
				System.out.print(current + " ");
				sortedList.remove(0);
				max = sortedList.isEmpty() ? 0 : sortedList.get(0);
				if (null != stack && !stack.isEmpty()) {
					Iterator<Integer> iterator = stack.iterator();
					while (iterator.hasNext()) {
						if (stack.peek() == max) {
							sortedList.remove(0);
							max = sortedList.isEmpty() ? 0 : sortedList.get(0);
							System.out.print(stack.pop() + " ");
						} else {
							break;
						}
					}
				}
			} else {
				System.out.println("");
				if (stack == null) {
					stack = new Stack<>();
				}
				stack.push(current);
				Collections.sort(stack);
			}
		}
	}

	public List<Integer> sortedList(List<Integer> input) {
		List<Integer> sorted = new ArrayList<>();
		for (int i = 0; i < input.size(); i++) {
			sorted.add(input.get(i));
		}
		Collections.sort(sorted);
		Collections.reverse(sorted);
		return sorted;
	}
}
