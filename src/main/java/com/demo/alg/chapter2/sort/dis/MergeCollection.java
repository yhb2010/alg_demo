package com.demo.alg.chapter2.sort.dis;

/**
 * 分治排序法：将原问题分解为几个规模较小但类似于原问题的子问题，递归求解这些子问题，然后再合并这些子问题的解来建立原问题的解
 * 
 * @author Administrator
 *
 */
public class MergeCollection {

	/**
	 * @param a
	 *            ：待排序数组
	 * @param p
	 *            ：数组下标
	 * @param q
	 *            ：数组下标
	 * @param r
	 *            ：数组下标，满足p小于等于q小于r
	 */
	public void merge(int[] a, int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int L[] = new int[n1 + 1];
		int R[] = new int[n2 + 1];
		int i;
		int j;
		for (i = 0; i < n1; i++) {
			L[i] = a[p + i];
		}
		for (j = 0; j < n2; j++) {
			R[j] = a[q + j + 1];
		}
		L[n1] = Integer.MAX_VALUE;// 哨兵值，当结果为哨兵值时，它不可能是较小的牌
		R[n2] = Integer.MAX_VALUE;// 哨兵值，当结果为哨兵值时，它不可能是较小的牌
		i = 0;
		j = 0;
		for (int k = p; k <= r; k++) {
			if (L[i] <= R[j]) {
				a[k] = L[i];
				i = i + 1;
			} else {
				a[k] = R[j];
				j = j + 1;
			}
		}
	}

	public void mergeSort(int[] a, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(a, p, q);
			mergeSort(a, q + 1, r);
			merge(a, p, q, r);
		}
	}

}
