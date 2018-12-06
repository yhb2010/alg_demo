package com.demo.alg.chapter9.randomSelect;

import com.demo.alg.chapter7.quicksort.NewQuickSort;

public class RandomizedSelect {

	public static int randomized_select(int[] A, int p, int r, int i) {
		if (p == r)
			return A[p];
		// 将数组A分为两个子数组，分为为A[p,q-1]和A[q+1,r].前一个数组的元素值均小于或者等于A[q],后个数组中的值均大于等于A[q]。
		int q = NewQuickSort.randomized_partition(A, p, r);
		// 计算A[p,q]中数组元素的个数
		int k = q - p + 1;
		// 判断A[k]是不是第i小元素，如果是，那就返回
		if (k == i)
			return A[q];
		// 如果不是，第i小元素落在哪个子数组中。如果i<k。说明落在A[p,q-1]中，若i>k，则说明落在A[q+1,r]中，因为已经知道有k个元素即A[p,q]，小于A[q+1,r]中的第i小元素，故所求的元素必为A[q+1,r]中第i-k小元素。
		else if (i < k)
			return randomized_select(A, p, q - 1, i);
		else
			return randomized_select(A, q + 1, r, i - k);
	}

}
