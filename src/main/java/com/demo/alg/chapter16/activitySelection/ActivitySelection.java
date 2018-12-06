package com.demo.alg.chapter16.activitySelection;

import java.util.List;

/**
 * 有这个定理，就简化了问题，使得最优解中只使用一个子问题，在解决子问题Sij时，在Sij中选择最早结束时间的那个活动。
 * 贪心算法自顶向下地解决每个问题，解决子问题Sij，先找到Sij中最早结束的活动am，然后将am添加到最优解活动集合中，再来解决子问题Smj。
 * 基于这种思想可以采用递归和迭代进行实现。递归实现过程如下所示：
 * 
 * @author Administrator
 *
 */
public class ActivitySelection {

	static void recursive_activity_selector(int[] s, int[] f, int k, int n,
			List<Integer> ret) {
		int m = k + 1;
		// 在Sk-n中寻找第一个结束的活动
		while (m <= n && s[m] < f[k]) {
			m = m + 1;
		}
		if (m <= n) {
			ret.add(m); // 添加到结果中
			recursive_activity_selector(s, f, m, n, ret);
		}
	}
}
