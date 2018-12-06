package com.demo.alg.chapter12;

public class BinarySearchTree {

	// 二叉查找树T的插入，插入z
	public static void insert(Node T, Node z) {
		// 找到要插入的位置
		Node y = null;
		Node x = T;

		// 若x为空,x是要插入的位置，x的父是z->p
		while (x != null) {
			y = x;
			if (z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		// 修改指针，注意树为空的情况
		z.p = y;
		if (y == null)
			T = z;// T是一个空的二叉树
		else if (z.key < y.key)
			y.left = z;
		else
			y.right = z;
	}

	public static void walk(Node T) {
		if (T != null) {
			walk(T.left);
			System.out.println(T);
			walk(T.right);
		}
	}

	public static Node search(Node T, int k) {
		while (T != null && k != T.key) {
			if (k < T.key) {
				T = T.left;
			} else {
				T = T.right;
			}
		}
		return T;
	}

	public static Node min(Node T) {
		while (T.left != null) {
			T = T.left;
		}
		return T;
	}

	public static Node max(Node T) {
		while (T.right != null) {
			T = T.right;
		}
		return T;
	}

	// 返回后继节点，即大于T.key的最小关键字的节点
	public static Node getSuccessor(Node T) {
		// 如果右节点非空，那么后继节点就是T的右子树的最左节点
		if (T.right != null) {
			return min(T.right);
		}

		Node successor = T.p;
		while (successor != null && T == successor.right) {
			T = successor;
			successor = successor.p;
		}
		return successor;
	}

}
