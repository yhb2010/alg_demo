package com.demo.alg.chapter9.randomSelect;

import com.demo.alg.util.Generator;
import com.demo.alg.util.IntGenerator;

public class Test {

	// 在O(n)时间内找到数组中的第i小的元素
	public static void main(String[] args) {
		int size = 100000;
		int[] a = new int[size];
		Generator<Integer> g = new IntGenerator(size);
		for (int i = 0; i < size; i++) {
			a[i] = g.next();
		}
		int result = RandomizedSelect.randomized_select(a, 0, a.length - 1, 20);
		System.out.println(result);

		int b[] = { 1, 34, 5, 16, 37, 28, 5, 9, 13, 26 };
		result = RandomizedSelect.randomized_select(b, 0, b.length - 1, 2);
		System.out.println(result);
	}

}