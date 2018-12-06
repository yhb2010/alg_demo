package com.demo.alg.chapter13;

public class BinarySearchTree {

	public static RBNode min(RBNode T, RBNode x) {
		while (x.left != T.nil) {
			x = x.left;
		}
		return x;
	}

	public static RBNode search(RBNode T, RBNode x, int k) {
		while (x != T.nil && k != x.key) {
			if (k < x.key) {
				x = x.left;
			} else {
				x = x.right;
			}
		}
		return x;
	}

}
