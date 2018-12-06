package com.demo.alg.chapter14;

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
		v.size = u.size;
		v.p = u.p;
	}

	public static void delete(RBNode T, RBNode z) {
		// 对应p183页
		RBNode y = z;
		Color originalColor = y.color;
		RBNode x = null;

		if (z.left == T.nil || z.right == T.nil) {
			y = z;
		} else {
			y = BinarySearchTree.min(T, z.right);
		}
		RBNode p = y.p;
		while (p != T.nil) {
			p.size--;
			p = p.p;
		}

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

		// 如果被删除的结点是黑色的，则需要调整
		if (originalColor == Color.BLACK) {
			delete_fixup(T, x);
		}
	}

	private static void delete_fixup(RBNode T, RBNode x) {
		// 如果这个额外的黑色在一个根结点或一个红结点上，结点会吸收额外的黑色，成为一个黑色的结点
		while (x != T.root && x.color == Color.BLACK) {
			// 若x是其父的左结点（右结点的情况相对应）
			if (x == x.p.left) {
				// 令w为x的兄弟，根据w的不同，分为三种情况来处理
				// 执行删除操作前x肯定是没有兄弟的，执行删除操作后x肯定是有兄弟的
				RBNode w = x.p.right;
				// 第一种情况：w是红色的
				if (w.color == Color.RED) {
					// 改变w和p[x]的颜色
					w.color = Color.BLACK;
					x.p.color = Color.RED;
					// 对p[x]进行一次左旋
					RBinsert.left_rotate(T, x.p);
					// 令w为x的新兄弟
					// 转为2.3.4三种情况之一
					w = x.p.right;
				}
				// 第二情况：w为黑色，w的两个孩子也都是黑色
				if (w.left.color == Color.BLACK && w.right.color == Color.BLACK) {
					// 去掉w和x的黑色
					// w只有一层黑色，去掉变为红色，x有多余的一层黑色，去掉后恢复原来颜色
					w.color = Color.RED;
					// 在p[x]上补一层黑色
					// 现在新x上有个额外的黑色，转入for循环继续处理
					x = x.p;
				} else {// 第三种情况，w是黑色的,w->left是红色的,w->right是黑色的
					if (w.right.color == Color.BLACK) {
						// 改变w和left[x]的颜色
						w.left.color = Color.BLACK;
						w.color = Color.RED;
						// 对w进行一次右旋
						RBinsert.right_rotate(T, w);
						// 令w为x的新兄弟
						// 此时转变为第四种情况
						w = x.p.right;
					}
					// 第四种情况：w是黑色的,w->left是黑色的,w->right是红色的
					// 修改w和p[x]的颜色
					w.color = x.p.color;
					x.p.color = Color.BLACK;
					w.right.color = Color.BLACK;
					// 对p[x]进行一次左旋
					RBinsert.left_rotate(T, x.p);
					// 此时调整已经结束，将x置为根结点是为了结束循环
					x = T.root;
				}
			} else {// 若x是其父的左结点（右结点的情况相对应）
				RBNode w = x.p.left;
				if (w.color == Color.RED) {
					w.color = Color.BLACK;
					x.p.color = Color.RED;
					RBinsert.right_rotate(T, x.p);
					w = x.p.left;
				}
				if (w.right.color == Color.BLACK && w.left.color == Color.BLACK) {
					w.color = Color.RED;
					x = x.p;
				} else {
					if (w.left.color == Color.BLACK) {
						w.right.color = Color.BLACK;
						w.color = Color.RED;
						RBinsert.left_rotate(T, w);
						w = x.p.left;
					}
					w.color = x.p.color;
					x.p.color = Color.BLACK;
					w.left.color = Color.BLACK;
					RBinsert.right_rotate(T, x.p);
					x = T.root;
				}
			}
		}
		x.color = Color.BLACK;
	}

}
