package com.demo.alg.chapter12;

public class BinarySearchTreeDel {

	// 用节点v替换u
	private static void transplant(Node u, Node v) {
		// u是树根
		if (u.p == null) {
			u = v;
		} else if (u == u.p.left) {
			u.p.left = v;
		} else {
			u.p.right = v;
		}
		if (v != null) {
			v.p = u.p;
		}
	}

	public static void delete(Node T, Node z) {
		// 对应p167页4种情况
		if (z.left == null) {
			transplant(z, z.right);
		} else if (z.right == null) {
			transplant(z, z.left);
		} else {
			Node y = BinarySearchTree.min(z.right);
			if (y.p != z) {
				transplant(y, y.right);
				y.right = z.right;
				y.right.p = y;
			}
			transplant(z, y);
			y.left = z.left;
			y.left.p = y;
		}
	}

}
