package com.demo.alg.chapter15.cutrod;

public class Method3 {

	/**
	 * 自底向上非递归方法解决钢条切割问题， 不仅保存最优收益值，还保存对应的切割方案
	 * 
	 * @param p
	 *            不同长度钢条的价格
	 * @param n
	 *            钢条的总长度
	 */
	public static int[] cutrod(int[] p, int n) {
		int[] r = new int[n + 1]; // 保存2米长钢条的最佳收益
		int[] s = new int[n + 1]; // 保存2米长钢条的切割方案
		r[0] = 0;

		for (int j = 1; j <= n; j++) {
			int q = Integer.MIN_VALUE;
			for (int i = 1; i <= j; i++) {
				if (q < p[i] + r[j - i]) {
					q = p[i] + r[j - i];
					// 保存第一段钢条的最有切割方案
					s[j] = i;
				}
			}
			r[j] = q;
		}
		System.out.println("最终受益: " + r[n]);
		return s;
	}

	/**
	 * 根据算法打印出长度为n的钢条完整的最优切割方案
	 * 
	 * @param p
	 *            不同长度钢条的价格
	 * @param n
	 *            钢条的总长度
	 */
	public static void printCutRodSolution(int[] p, int n) {
		int result[] = cutrod(p, n);
		System.out.print("钢板切除方案: ");
		while (n > 0) {
			System.out.print(result[n] + " ");
			n = n - result[n];
		}
	}

	public static void main(String[] args) {
		// TODO 自动生成方法存根
		// 钢条的价格price[0]表示0米长钢条的价格，price[5]代表5米长钢条的价格
		int price[] = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

		long l1 = System.currentTimeMillis();
		printCutRodSolution(price, 4);
		long l2 = System.currentTimeMillis();
		System.out.println();
		System.out.println(l2 - l1);
	}

}
