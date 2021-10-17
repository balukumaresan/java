package com.balu.gl.algorithms.skyscraper.analyzer.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class SkyScraperAnalyzer {

	List<Integer> result;
	int i = 0;
	Stack<Integer> stack;
	List<Integer> queue = new ArrayList<>();

	public void analyze(List<Integer> floorSizes) {

		if (floorSizes == null) {
			return;
		}
		int max = Collections.max(floorSizes);

		int current = floorSizes.get(i);

		if (floorSizes.get(i) == max) {

			Collections.max(stack);
		} else {
			if (queue == null) {
				stack = new Stack<>();
			}
			stack.add(current);
//			queue.add(current);
		}
	}

	public void analyze2(List<Integer> floorSizes) {
		
		List<Integer> sortedList = sortedList(floorSizes);
		int max = Collections.max(sortedList);
		int day = 0;
//		int removalIndex =0;
		for (int i=0; i <floorSizes.size(); i++) {
			day= day+1;
			System.out.println("");
			System.out.println("Day: " + day);
			int current = floorSizes.get(i);
			if (current == max) {
				System.out.print(current + " ");
				sortedList.remove(0);
				max = sortedList.isEmpty() ? 0 : Collections.max(sortedList);
				if(null != queue && !queue.isEmpty()) {
					Iterator<Integer> iterator = queue.iterator();
					while (iterator.hasNext()) {
						if (stack.peek() == max) {
							sortedList.remove(0);
							max = sortedList.isEmpty() ? 0 : Collections.max(sortedList);
							stack.pop();
							System.out.print(iterator.next() + " ");
						}
					}
//					for (int j = 0; j < stack.size(); j++) {
//						if (stack.peek() == max) {
//							sortedList.remove(0);
//							max = sortedList.isEmpty() ? 0 : Collections.max(sortedList);
//							System.out.print(stack.pop() + " ");
//						}
//					}
				}
			}
			else {
				System.out.println("");
				if (queue == null) {
					queue = new ArrayList<>();
				}
				queue.add(current);
//				queue.add(current);
				Collections.sort(queue);
				Collections.reverse(queue);
				
			}
		}
	}
	
	public List<Integer> analyzeFloorSize(int noOfFloors, ArrayList<Integer> floorSizes) {
		List<Integer> result = new ArrayList<>();
		if (floorSizes.size() == 0) {
			return new ArrayList<>();
		}
		int maxSizeOfFloor = Collections.max(floorSizes);

		ArrayList<Integer> sortedList = (ArrayList<Integer>) sortedList(floorSizes);

		int maxIndex = floorSizes.size() - 1;

		for (int i = 0; i < floorSizes.size(); i++) {
			int currrentSize = floorSizes.get(i);

			if (currrentSize == sortedList.get(maxIndex)) {
				result.add(currrentSize);
				maxIndex--;
			} else {
				result.add(0);
				System.out.println("");
			}
		}

		return result;

	}

	public List<Integer> sortedList(List<Integer> input) {
		List<Integer> sorted = new  ArrayList<>();
		for ( int i = 0; i < input.size(); i++) {
			sorted.add(input.get(i));
		}
		Collections.sort(sorted);
		Collections.reverse(sorted);
		return sorted;
	}

}
