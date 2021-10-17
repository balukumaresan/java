package com.balu.gl.algorithms.util;

import java.util.ArrayList;

/**
 * Utility to find the Longest path of the Leaf from the root node.
 * 
 * @author baluk
 *
 */
public class BinaryTreeTraverseUtility {

	/**
	 * Create a new Node and returns
	 * 
	 * @param data
	 * @return
	 */
	public Node newNode(Integer data) {
		Node temp = new Node();
		temp.setData(data);
		return temp;
	}

	/**
	 * Finds the Longest path of a leaf node
	 * 
	 * @param node
	 * @return
	 */
	public ArrayList<Integer> findLongestPath(Node node) {
		if (null == node) {
			return new ArrayList<Integer>();
		}

		ArrayList<Integer> leftPaths = findLongestPath(node.getLeft());
		ArrayList<Integer> rightPaths = findLongestPath(node.getRight());

		if (rightPaths.size() < leftPaths.size()) {
			leftPaths.add(node.getData());
		} else {
			rightPaths.add(node.getData());
		}
		return (rightPaths.size() > leftPaths.size() ? rightPaths : leftPaths);
	}
}
