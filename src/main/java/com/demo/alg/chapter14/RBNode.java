package com.demo.alg.chapter14;

/**
 * 一棵 顺序统计树 T 通过在红黑树的每个结点中存入附加信息而成。在一个结点 x 内，增加域 x.size 。该域包含以结点 x
 * 为根的子树的（内部）结点数（包括 x 本身），即子树的大小。设 T.nil.size 为0，则有 x.size = x.left.size +
 * x.right.size + 1
 * 
 * @author Administrator
 *
 */
public class RBNode {

	int key;// 关键字
	RBNode left;// 左孩子
	RBNode right;// 右孩子
	RBNode p;// 父结点
	Color color;// red or black
	int size;// x.left.size+x.right.size+1
	RBNode nil;// 哨兵（叶节点）
	RBNode root;// 根

	public RBNode(int key, int size) {
		super();
		this.key = key;
		this.size = size;
	}

	public RBNode(int key, Color color, int size) {
		super();
		this.key = key;
		this.color = color;
		this.size = size;
	}

	public RBNode(int key, RBNode left, RBNode right, RBNode p, Color color,
			int size) {
		super();
		this.key = key;
		this.left = left;
		this.right = right;
		this.p = p;
		this.color = color;
		this.size = size;
	}

	@Override
	public String toString() {
		return "Node [key=" + key + ", color=" + color.getName() + ", p.key="
				+ p.key + ", right.key=" + right.key + ", left.key=" + left.key
				+ ", size=" + size + "]";
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
