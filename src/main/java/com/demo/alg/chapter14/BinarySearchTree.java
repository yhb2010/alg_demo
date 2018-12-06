package com.demo.alg.chapter14;

public class BinarySearchTree {

	public static RBNode min(RBNode T, RBNode x) {
		while (x.left != T.nil) {
			x = x.left;
		}
		return x;
	}

	/**
	 * 选择第i小的元素
	 * 
	 * @param x
	 * @return
	 */
	public static RBNode OS_SELECT(RBNode x, int i) {
		// 令x左子树中点的个数为r-1,
		int r = x.left.size + 1;
		// 那么x是x树中第r大的结点
		if (i == r) {
			return x;
		} else if (i < r) {// 第i大的元素在x->left中
			return OS_SELECT(x.left, i);
		} else {// 第i大的元素在x->right中
			return OS_SELECT(x.right, i - r);
		}
	}

	/**
	 * 找到某个元素的秩（即元素在集合的排序）
	 * 
	 * @param T
	 * @param x
	 * @return
	 */
	public static int OS_RANK(RBNode T, RBNode x) {
		// 置r为以x为根的子树中key[x]的秩
		int r = x.left.size + 1;
		RBNode y = x;
		while (y != T.root) {
			// 若y是p[y]的右孩子，p[y]和p[y]左子树中所有结点前于x
			if (y == y.p.right) {
				r = r + y.p.left.size + 1;
			}
			y = y.p;
		}
		return r;
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
