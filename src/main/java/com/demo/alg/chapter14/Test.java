package com.demo.alg.chapter14;

public class Test {

	public static void main(String[] args) {
		// 哨兵节点（叶节点，和根节点的父节点）
		RBNode nil = new RBNode(Integer.MIN_VALUE, Color.BLACK, 0);
		// 初始化根节点
		RBNode T = new RBNode(41, nil, nil, nil, Color.BLACK, 1);
		T.root = T;
		T.nil = nil;

		RBNode z = new RBNode(26, 1);
		RBinsert.insert(T, z);
		z = new RBNode(17, 1);
		RBinsert.insert(T, z);
		z = new RBNode(14, 1);
		RBinsert.insert(T, z);
		z = new RBNode(21, 1);
		RBinsert.insert(T, z);
		z = new RBNode(30, 1);
		RBinsert.insert(T, z);
		z = new RBNode(47, 1);
		RBinsert.insert(T, z);
		z = new RBNode(10, 1);
		RBinsert.insert(T, z);
		z = new RBNode(16, 1);
		RBinsert.insert(T, z);
		z = new RBNode(19, 1);
		RBinsert.insert(T, z);
		z = new RBNode(21, 1);
		RBinsert.insert(T, z);
		z = new RBNode(28, 1);
		RBinsert.insert(T, z);
		z = new RBNode(38, 1);
		RBinsert.insert(T, z);
		z = new RBNode(7, 1);
		RBinsert.insert(T, z);
		z = new RBNode(12, 1);
		RBinsert.insert(T, z);
		z = new RBNode(14, 1);
		RBinsert.insert(T, z);
		z = new RBNode(20, 1);
		RBinsert.insert(T, z);
		z = new RBNode(35, 1);
		RBinsert.insert(T, z);
		z = new RBNode(39, 1);
		RBinsert.insert(T, z);
		z = new RBNode(3, 1);
		RBinsert.insert(T, z);

		System.out.println(BinarySearchTree.OS_SELECT(T.root, 17));
		System.out.println(BinarySearchTree.OS_RANK(T,
				BinarySearchTree.search(T, T.root, 38)));
		
		RBdelete.delete(T, BinarySearchTree.search(T, T.root, 10));
	}

}
