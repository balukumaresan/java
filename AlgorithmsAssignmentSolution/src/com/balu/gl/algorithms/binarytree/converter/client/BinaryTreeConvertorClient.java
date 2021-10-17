package com.balu.gl.algorithms.binarytree.converter.client;

import com.balu.gl.algorithms.binarytree.converter.util.BinaryTreeToSkewedUtil;
import com.balu.gl.algorithms.util.BinaryTreeTraverseUtility;
import com.balu.gl.algorithms.util.Node;

public class BinaryTreeConvertorClient {

	public static void main(String[] args) {
		
		BinaryTreeTraverseUtility btTraverseUtility =  new BinaryTreeTraverseUtility();

		Node node = btTraverseUtility.newNode(50);
		node.setLeft(btTraverseUtility.newNode(30));
		node.setRight(btTraverseUtility.newNode(60));
		node.getLeft().setLeft(btTraverseUtility.newNode(10));
		node.getRight().setLeft(btTraverseUtility.newNode(55));
		
		BinaryTreeToSkewedUtil binaryTreeToSkewedUtil = new BinaryTreeToSkewedUtil();
		Node headNode = binaryTreeToSkewedUtil.convert(node);
		binaryTreeToSkewedUtil.traverseRightSkewed(headNode);
	}

}
