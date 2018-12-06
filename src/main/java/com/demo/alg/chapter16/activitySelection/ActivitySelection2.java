package com.demo.alg.chapter16.activitySelection;

import java.util.ArrayList;
import java.util.List;

/**
 * 迭代贪心算法
 * 
 * @author Administrator
 *
 */
public class ActivitySelection2 {

	static List<Integer> recursive_activity_selector(int[] s, int[] f) {
		List<Integer> ret = new ArrayList<Integer>();
		int k = 1;
		ret.add(k);

		// 在Sk-n中寻找第一个结束的活动
		for (int m = 2; m < s.length; m++) {
			if (s[m] >= f[k]) {
				ret.add(m);
				k = m;
			}
		}

		return ret;
	}
}
