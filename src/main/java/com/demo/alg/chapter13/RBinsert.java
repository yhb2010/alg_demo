package com.demo.alg.chapter13;

public class RBinsert {

	/**
	 * 左旋：当在某个结点x上，做左旋操作时，我们假设它的右孩子y不是NIL[T]，x可以为树内任意右孩子而不是NIL[T]的结点。
	 * 左旋以x到y之间的链为“支轴”进行，它使y成为该孩子树新的根，而y的左孩子b则成为x的右孩子。
	 * 
	 * @param x
	 * @return
	 */
	public static void left_rotate(RBNode T, RBNode x) {

		// 设置y结点
		RBNode y = x.right;
		x.right = y.left;

		if (y.left != T.nil) {
			y.left.p = x;
		}
		y.p = x.p;

		if (x.p == T.nil) {
			T.root = y;
		} else if (x == x.p.left) {
			x.p.left = y;
		} else {
			x.p.right = y;
		}
		y.left = x;
		x.p = y;

	}

	/**
	 * 右旋
	 * 
	 * @param x
	 */
	public static void right_rotate(RBNode T, RBNode x) {

		// 设置y结点
		RBNode y = x.left;
		x.left = y.right;

		if (y.right != T.nil) {
			y.right.p = x;
		}
		y.p = x.p;

		if (x.p == T.nil) {
			T.root = y;
		} else if (x == x.p.left) {
			x.p.left = y;
		} else {
			x.p.right = y;
		}
		y.right = x;
		x.p = y;
	}

	/**
	 * 红黑树T的插入，插入z
	 * 我们可以在O(lgn)时间内完成想一棵含n个结点的红黑树中插入一个新的结点。为了做到这一点，利用TREE-INSERT过程，将结点z插入树T中，
	 * 就好像T是一棵普通的二叉搜索树一样，然后将z着为红色，为了能保持红黑性质，我们设计了一个辅助程序RB-INSERT-FIXUP来对结点重新着色并
	 * 旋转。
	 * 
	 * @param T
	 * @param z
	 */
	public static void insert(RBNode T, RBNode z) {
		// 找到要插入的位置
		RBNode y = T.nil;
		RBNode x = T.root;

		// 若x为空,x是要插入的位置，x的父是z->p
		while (x != T.nil) {
			y = x;
			if (z.key < x.key)
				x = x.left;
			else
				x = x.right;
		}
		// 修改指针，注意树为空的情况
		z.p = y;
		if (y == T.nil)
			T = z;// T是一个空的二叉树
		else if (z.key < y.key)
			y.left = z;
		else
			y.right = z;

		z.left = T.nil;
		z.right = T.nil;
		z.color = Color.RED;
		insert_fixup(T, z);
	}

	private static void insert_fixup(RBNode T, RBNode z) {
		while (z.p.color == Color.RED) {
			if (z.p == z.p.p.left) {
				RBNode y = z.p.p.right;
				if (y.color == Color.RED) {
					z.p.color = Color.BLACK; // case 1
					z.p.p.color = Color.RED; // case 1
					y.color = Color.BLACK; // case 1
					z = z.p.p; // case 1
				} else if (z == z.p.right) {
					z = z.p; // case 2
					left_rotate(T, z); // case 2
				} else {
					z.p.color = Color.BLACK; // case 3
					z.p.p.color = Color.RED; // case 3
					right_rotate(T, z.p.p); // case 3
				}
			} else {
				RBNode y = z.p.p.left;
				if (y.color == Color.RED) {
					z.p.color = Color.BLACK;
					y.color = Color.BLACK;
					z.p.p.color = Color.RED;
					z = z.p.p;
				} else if (z == z.p.left) {
					z = z.p;
					right_rotate(T, z);
				} else {
					z.p.color = Color.BLACK;
					z.p.p.color = Color.RED;
					left_rotate(T, z.p.p);
				}
			}

		}

		T.root.color = Color.BLACK;
	}
}
