package com.demo.alg.chapter15.cutrod;

import com.demo.alg.util.CompareUtils;

public class Method1 {

	/**
	 * 速度很慢。我们可以发现，长度为7时，将其切割为长度4与长度3的钢条，并对两个钢条分别求最优解：长度4的最优解为r[4] = 10（2 +
	 * 2），长度3的最优解为r[3] = 8，即可得r[7] =r[4]+ r[3] =>原问题的最优解等于子问题的最优解之和的最大值
	 * 
	 * @param p
	 *            ：价格数组
	 * @param n
	 *            ：钢条长度
	 * @return
	 */
	public static int cutrod(int[] p, int n) {
		if (n == 0) {
			// 长度为0，没有收益
			return 0;
		}
		int q = Integer.MIN_VALUE;
		// 我们将钢条左边切割下长度为 i 的一段，只对右边剩下的长度为 n-i
		// 的一段继续进行切割（递归求解），对左边的一段不再进行切割。即问题分解的方式为：将长度为n
		// 的钢条分解为左边开始一段，以及剩余部分继续分解的结果。这样，不做任何切割的方案就可以描述为：第一段的长度为n ，收益为
		// pn，剩余部分长度为0，对应的收益为r0=0。
		for (int i = 1; i <= n; i++) {
			System.out.println("n=" + n + ", i=" + i);
			q = CompareUtils.max(q, p[i] + cutrod(p, n - i));
			System.out.println("q=" + q);
		}
		return q;
	}

	public static void main(String[] args) {
		// TODO 自动生成方法存根
		// 钢条的价格price[0]表示0米长钢条的价格，price[5]代表5米长钢条的价格
		int price[] = { 0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };

		long l1 = System.currentTimeMillis();
		System.out.println(cutrod(price, 3));
		long l2 = System.currentTimeMillis();
		System.out.println(l2 - l1);
		// cutrod(price, 8);
	}

}
