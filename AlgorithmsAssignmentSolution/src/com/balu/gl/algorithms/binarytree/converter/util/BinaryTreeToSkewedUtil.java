package com.balu.gl.algorithms.binarytree.converter.util;

import com.balu.gl.algorithms.util.Node;

public class BinaryTreeToSkewedUtil {

	Node headNode = null;
	Node prevNode = null;

	public Node convert(Node rootNode) {
		convertBinarySearchTreeToSkewed(rootNode);
		return headNode;
	}

	public void convertBinarySearchTreeToSkewed(Node rootNode) {

		if (null == rootNode) {
			return;
		}

		convertBinarySearchTreeToSkewed(rootNode.getLeft());

		if (null == headNode) {
			headNode = rootNode;
			rootNode.setLeft(null);
			prevNode = rootNode;
		} else {
			prevNode.setRight(rootNode);
			rootNode.setLeft(null);
			prevNode = rootNode;
		}

		convertBinarySearchTreeToSkewed(rootNode.getRight());
	}

	public void traverseRightSkewed(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.getRight() == null ? root.getData() : (root.getData()) + "->");
		traverseRightSkewed(root.getRight());
	}
}
