package com.demo.alg.chapter15.optimalBST;

public class OptimalBST {

	int[][] root = null;
	double[][] w = null;
	double[][] e = null;

	public void optimalBST(double[] p, double[] q, int n) {
		int MaxVal = Integer.MAX_VALUE;
		w = new double[n + 2][n + 2];// 子树概率总和
		e = new double[n + 2][n + 2];// 子树期望代价，最终结果是e[1][n]
		root = new int[n + 2][n + 2];// 记录根节点

		// 初始化只包括虚拟键的子树
		for (int i = 1; i <= n + 1; ++i) {
			//当j=i-1时，子树只包含伪关键字d(i-1)
			w[i][i - 1] = q[i - 1];
			e[i][i - 1] = q[i - 1];
		}

		// 由下到上，由左到右逐步计算
		//l=1时，针对i=1...n计算e[i,i]，w[i,i]，当l=2时，针对针对i=1...n-1计算e[i,i+1]，w[i,i+1]
		for (int len = 1; len <= n; ++len) {
			for (int i = 1; i <= n - len + 1; ++i) {
				int j = i + len - 1;
				e[i][j] = MaxVal;
				w[i][j] = w[i][j - 1] + p[j] + q[j];
				// 求取最小代价的子树的根
				for (int k = i; k <= j; ++k) {
					double temp = e[i][k - 1] + e[k + 1][j] + w[i][j];
					if (temp < e[i][j]) {
						e[i][j] = temp;
						root[i][j] = k;
					}
				}
			}
		}
	}

	// 输出最优二叉查找树所有子树的根
	public void printRoot(int n) {
		System.out.println("各子树的根：");
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= n; ++j) {
				System.out.print(root[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	// 打印最优二叉查找树的结构
	// 打印出[i,j]子树，它是根r的左子树和右子树
	public void printOptimalBST(int n, int i, int j, int r) {
		int rootChild = root[i][j];// 子树根节点
		if (rootChild == root[1][n]) {
			// 输出整棵树的根
			System.out.println("k" + rootChild + "是根");
			printOptimalBST(n, i, rootChild - 1, rootChild);
			printOptimalBST(n, rootChild + 1, j, rootChild);
			return;
		}

		if (j < i - 1) {
			return;
		} else if (j == i - 1)// 遇到虚拟键
		{
			if (j < r) {
				System.out.println("d" + j + "是" + "k" + r + "的左孩子");
			} else
				System.out.println("d" + j + "是" + "k" + r + "的右孩子");
			return;
		} else// 遇到内部结点
		{
			if (rootChild < r) {
				System.out.println("k" + rootChild + "是" + "k" + r + "的左孩子");
			} else
				System.out.println("k" + rootChild + "是" + "k" + r + "的右孩子");
		}

		printOptimalBST(n, i, rootChild - 1, rootChild);
		printOptimalBST(n, rootChild + 1, j, rootChild);
	}

	/**
	 * 最优二叉查找树的期望代价
	 * 
	 * @return
	 */
	public double gete(int n) {
		return e[1][n];
	}

}
