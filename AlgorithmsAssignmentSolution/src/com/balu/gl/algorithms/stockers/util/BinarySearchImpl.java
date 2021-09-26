package com.balu.gl.algorithms.stockers.util;

public class BinarySearchImpl {

	public static boolean search(double[] arr, double searchKey) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] < searchKey) {
				low = mid + 1;
			} else if (arr[mid] > searchKey) {
				high = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}

}
