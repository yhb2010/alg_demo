package com.demo.alg.chapter12;

public class Test {

	public static void main(String[] args) {
		Node T = new Node(15, null, null, null);
		Node z = new Node(6, null, null, null);
		BinarySearchTree.insert(T, z);
		z = new Node(18, null, null, null);
		BinarySearchTree.insert(T, z);
		z = new Node(3, null, null, null);
		BinarySearchTree.insert(T, z);
		z = new Node(7, null, null, null);
		BinarySearchTree.insert(T, z);
		z = new Node(2, null, null, null);
		BinarySearchTree.insert(T, z);
		z = new Node(4, null, null, null);
		BinarySearchTree.insert(T, z);
		z = new Node(13, null, null, null);
		BinarySearchTree.insert(T, z);
		z = new Node(9, null, null, null);
		BinarySearchTree.insert(T, z);
		z = new Node(17, null, null, null);
		BinarySearchTree.insert(T, z);
		z = new Node(20, null, null, null);
		BinarySearchTree.insert(T, z);
		z = new Node(19, null, null, null);
		BinarySearchTree.insert(T, z);
		z = new Node(25, null, null, null);
		BinarySearchTree.insert(T, z);

		BinarySearchTree.walk(T);

		System.out.println("找到：" + BinarySearchTree.search(T, 7));
		System.out.println("找到：" + BinarySearchTree.search(T, 180));

		System.out.println("找到最小：" + BinarySearchTree.min(T));
		System.out.println("找到最大：" + BinarySearchTree.max(T));

		System.out
				.println("找到后继："
						+ BinarySearchTree.getSuccessor(BinarySearchTree
								.search(T, 13)));
		System.out
				.println("找到后继："
						+ BinarySearchTree.getSuccessor(BinarySearchTree
								.search(T, 18)));

		System.out.print("删除后：");
		// BinarySearchTreeDel.delete(T, BinarySearchTree.search(T, 4));
		// BinarySearchTreeDel.delete(T, BinarySearchTree.search(T, 13));
		// BinarySearchTreeDel.delete(T, BinarySearchTree.search(T, 6));
		BinarySearchTreeDel.delete(T, BinarySearchTree.search(T, 18));
		BinarySearchTree.walk(T);
	}

}
