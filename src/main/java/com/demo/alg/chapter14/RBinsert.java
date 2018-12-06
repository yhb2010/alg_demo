package com.demo.alg.chapter14;

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

		y.size = x.size;
		x.size = x.left.size + x.right.size + 1;

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

		y.size = x.size;
		x.size = x.left.size + x.right.size + 1;
	}

	/**
	 * 在插入元素时，分两阶段，阶段一：从根开始向下遍历，
	 * 直到元素找到可以插入的位置；阶段二：通过旋转来维护红黑性质。在阶段一，我们只需在遍历时经由的所有结点的size增加1便可，时间为
	 * O(lg(n))，在阶段二最多会有O(lg(n))次旋转，每次旋转只需O(1)的时间：重新计算被旋转的元素的size，看下图：
	 * 
	 * 在LEFT_ROTATE里加入下列两行代码以维护size信息： y.size = x.size; x.size = x.left.size +
	 * x.right.size + 1综上所述，插入元素的两个阶段里，维护size息共需O(lg(n))的时间。
	 * 
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
			x.size = x.size + 1;
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
		// 将新插入的结点转为红色
		z.color = Color.RED;
		// 从新插入的结点开始，向上调整
		insert_fixup(T, z);
	}

	private static void insert_fixup(RBNode T, RBNode z) {
		// 唯一需要调整的情况，就是违反性质2的时候，如果不违反性质2，调整结束
		while (z.p.color == Color.RED) {
			// p[z]是左孩子时，有三种情况
			if (z.p == z.p.p.left) {
				// 令y是z的叔结点
				RBNode y = z.p.p.right;
				// 第一种情况，z的叔叔y是红色的
				if (y.color == Color.RED) {
					// 将p[z]和y都着为黑色以解决z和p[z]都是红色的问题
					z.p.color = Color.BLACK; // case 1
					// 将p[p[z]]着为红色以保持性质5
					z.p.p.color = Color.RED; // case 1
					y.color = Color.BLACK; // case 1
					// 把p[p[z]]当作新增的结点z来重复while循环
					z = z.p.p; // case 1
				} else {
					// 第二种情况：z的叔叔是黑色的，且z是右孩子
					if (z == z.p.right) {
						// 对p[z]左旋，转为第三种情况
						z = z.p; // case 2
						left_rotate(T, z); // case 2
					}
					// 第三种情况：z的叔叔是黑色的，且z是左孩子
					// 交换p[z]和p[p[z]]的颜色，并右旋
					z.p.color = Color.BLACK; // case 3
					z.p.p.color = Color.RED; // case 3
					right_rotate(T, z.p.p); // case 3
				}
			} else {// p[z]是右孩子时，有三种情况，与上面类似
				RBNode y = z.p.p.left;
				if (y.color == Color.RED) {
					z.p.color = Color.BLACK;
					y.color = Color.BLACK;
					z.p.p.color = Color.RED;
					z = z.p.p;
				} else {
					if (z == z.p.left) {
						z = z.p;
						right_rotate(T, z);
					}
					z.p.color = Color.BLACK;
					z.p.p.color = Color.RED;
					left_rotate(T, z.p.p);
				}
			}

		}

		T.root.color = Color.BLACK;
	}
}
