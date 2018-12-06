package com.demo.alg.chapter13;

public class RBdelete {

	// 用节点v替换u
	private static void transplant(RBNode T, RBNode u, RBNode v) {
		// u是树根
		if (u.p == T.nil) {
			T.root = v;
		} else if (u == u.p.left) {
			u.p.left = v;
		} else {
			u.p.right = v;
		}
		v.p = u.p;
	}

	public static void delete(RBNode T, RBNode z) {
		// 对应p183页
		RBNode y = z;
		Color originalColor = y.color;
		RBNode x = null;

		if (z.left == T.nil) {
			x = z.right;
			transplant(T, z, z.right);
		} else if (z.right == T.nil) {
			x = z.left;
			transplant(T, z, z.left);
		} else {
			// y替换z，y是z的后继
			y = BinarySearchTree.min(T, z.right);
			originalColor = y.color;
			x = y.right;

			if (y.p == z) {
				x.p = y;
			} else {
				transplant(T, y, y.right);
				y.right = z.right;
				y.right.p = y;
			}
			transplant(T, z, y);
			y.left = z.left;
			y.left.p = y;
			y.color = z.color;
		}

		if (originalColor == Color.BLACK) {
			delete_fixup(T, x);
		}
	}

	private static void delete_fixup(RBNode T, RBNode x) {
		while (x != T.root && x.color == Color.BLACK) {
			if (x == x.p.left) {
				RBNode w = x.p.right;
				if (w.color == Color.RED) {
					w.color = Color.BLACK;
					x.p.color = Color.RED;
					RBinsert.left_rotate(T, x.p);
					w = x.p.right;
				}
				if (w.left.color == Color.BLACK && w.right.color == Color.BLACK) {
					w.color = Color.RED;
					x = x.p;
				} else {
					if (w.right.color == Color.BLACK) {
						w.left.color = Color.BLACK;
						w.color = Color.RED;
						RBinsert.right_rotate(T, w);
						w = x.p.right;
					}
					w.color = x.p.color;
					x.p.color = Color.BLACK;
					w.right.color = Color.BLACK;
					RBinsert.left_rotate(T, x.p);
					x = T.root;
				}
			} else {
				RBNode w = x.p.left;
				if (w.color == Color.RED) {
					w.color = Color.BLACK;
					x.p.color = Color.RED;
					RBinsert.left_rotate(T, x.p);
					w = x.p.left;
				}
				if (w.right.color == Color.BLACK && w.left.color == Color.BLACK) {
					w.color = Color.RED;
					x = x.p;
				} else {
					if (w.left.color == Color.BLACK) {
						w.right.color = Color.BLACK;
						w.color = Color.RED;
						RBinsert.right_rotate(T, w);
						w = x.p.left;
					}
					w.color = x.p.color;
					x.p.color = Color.BLACK;
					w.left.color = Color.BLACK;
					RBinsert.left_rotate(T, x.p);
					x = T.root;
				}
			}
		}
		x.color = Color.BLACK;
	}

}
