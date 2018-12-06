package com.demo.alg.chapter13;

public class RBNode {

	int key;// 关键字
	RBNode left;// 左孩子
	RBNode right;// 右孩子
	RBNode p;// 父结点
	Color color;// red or black
	RBNode nil;// 哨兵（叶节点）
	RBNode root;// 根

	public RBNode(int key) {
		super();
		this.key = key;
	}

	public RBNode(int key, Color color) {
		super();
		this.key = key;
		this.color = color;
	}

	public RBNode(int key, RBNode left, RBNode right, RBNode p, Color color) {
		super();
		this.key = key;
		this.left = left;
		this.right = right;
		this.p = p;
		this.color = color;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", color=" + color.getName() + ", p.key="
				+ p.key + ", right.key=" + right.key + ", left.key=" + left.key
				+ "]";
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
		RBNode other = (RBNode) obj;
		if (key != other.key)
			return false;
		return true;
	}

}
