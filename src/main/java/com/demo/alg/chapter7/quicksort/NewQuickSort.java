package com.demo.alg.chapter7.quicksort;

import com.demo.alg.util.ArrayUtils;

/**
 * 快速排序的随机化版本
 * 
 * @author Administrator
 *
 */
public class NewQuickSort {

	public static void randomized_quickSost(int[] arr, int p, int r) {
		if (p < r) {
			int q = randomized_partition(arr, p, r);
			randomized_quickSost(arr, p, q - 1);
			randomized_quickSost(arr, q + 1, r);
		}
	}

	public static int randomized_partition(int[] arr, int p, int r) {
		int i = (int) (Math.random() * (r - p + 1)) + p;
		ArrayUtils.exchangeElements(arr, r, i);
		return partition(arr, p, r);
	}

	// 划分区域
	private static int partition(int A[], int p, int r) {
		int base = A[r];// 以最后一个数作为划分的基点
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (A[j] <= base) {
				i++;
				ArrayUtils.exchangeElements(A, i, j);
			}
		}
		ArrayUtils.exchangeElements(A, i + 1, r);
		return i + 1;
	}
}
