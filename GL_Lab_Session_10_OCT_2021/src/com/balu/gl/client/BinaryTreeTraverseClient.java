package com.balu.gl.client;

import java.util.ArrayList;

import com.balu.gl.util.BinaryTreeTraverseUtility;
import com.balu.gl.util.Node;

/**
 * Client app to find the Longest path of a Leaf from the Root.
 * 
 * @author baluk
 *
 */
public class BinaryTreeTraverseClient {

	public static void main(String[] args) {
		BinaryTreeTraverseUtility binaryUtility = new BinaryTreeTraverseUtility();

		Node rootNode = binaryUtility.newNode(100);

		Node leftNode1 = binaryUtility.newNode(20);
		rootNode.setLeft(leftNode1);

		Node rightNode1 = binaryUtility.newNode(130);
		rootNode.setRight(rightNode1);

		Node rightNode2 = binaryUtility.newNode(50);
		leftNode1.setRight(rightNode2);

		Node leftNode2 = binaryUtility.newNode(10);
		leftNode1.setLeft(leftNode2);

		Node leftNode3 = binaryUtility.newNode(5);
		leftNode2.setLeft(leftNode3);

		Node leftNode4 = binaryUtility.newNode(110);
		rightNode1.setLeft(leftNode4);

		Node rightNode3 = binaryUtility.newNode(140);
		rightNode1.setRight(rightNode3);

		ArrayList<Integer> result = binaryUtility.findLongestPath(rootNode);

		for (int i = result.size() - 1; i >= 0; i--) {
			System.out.print(i > 0 ? result.get(i) + "->" : result.get(i));
		}
	}
}
