package com.demo.alg.chapter13;

public class Test {

	public static void main(String[] args) {
		// 哨兵节点（叶节点，和根节点的父节点）
		RBNode nil = new RBNode(Integer.MIN_VALUE, Color.BLACK);
		// 初始化根节点
		RBNode T = new RBNode(11, nil, nil, nil, Color.BLACK);
		T.root = T;
		T.nil = nil;

		RBNode z = new RBNode(14);
		RBinsert.insert(T, z);
		z = new RBNode(2);
		RBinsert.insert(T, z);
		z = new RBNode(1);
		RBinsert.insert(T, z);
		z = new RBNode(7);
		RBinsert.insert(T, z);
		z = new RBNode(8);
		RBinsert.insert(T, z);
		z = new RBNode(5);
		RBinsert.insert(T, z);
		z = new RBNode(4);
		RBinsert.insert(T, z);
		z = new RBNode(10);
		RBinsert.insert(T, z);
		z = new RBNode(9);
		RBinsert.insert(T, z);
		z = new RBNode(15);
		RBinsert.insert(T, z);
		z = new RBNode(13);
		RBinsert.insert(T, z);
		z = new RBNode(6);
		RBinsert.insert(T, z);
		z = new RBNode(16);
		RBinsert.insert(T, z);
		z = new RBNode(0);
		RBinsert.insert(T, z);

		// RBdelete.delete(T, BinarySearchTree.search(T, T.root, 5));
		RBdelete.delete(T, BinarySearchTree.search(T, T.root, 9));
		//RBdelete.delete(T, BinarySearchTree.search(T, T.root, 11));
	}

}
