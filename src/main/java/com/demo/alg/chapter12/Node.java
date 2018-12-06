package com.demo.alg.chapter12;

public class Node {

	int key;// 关键字
	Node left;// 左孩子
	Node right;// 右孩子
	Node p;// 父结点

	public Node(int key, Node left, Node right, Node p) {
		super();
		this.key = key;
		this.left = left;
		this.right = right;
		this.p = p;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (key != other.key)
			return false;
		return true;
	}

}
