package com.demo.alg.chapter7.quicksort;

import com.demo.alg.util.ArrayUtils;
import com.demo.alg.util.Generator;
import com.demo.alg.util.IntGenerator;

public class Test {

	public static void main(String[] args) {
		int size = 100000;
		int[] a = new int[size];
		Generator<Integer> g = new IntGenerator(size);
		for (int i = 0; i < size; i++) {
			a[i] = g.next();
		}

		System.out.println("Before heap:");
		// ArrayUtils.printArray(a);
		long t1 = System.currentTimeMillis();
		NewQuickSort.randomized_quickSost(a, 0, a.length - 1);

		System.out.println("After heap sort:");
		// ArrayUtils.printArray(a);
		long t2 = System.currentTimeMillis();
		System.out.println("time=" + (t2 - t1));
		ArrayUtils.printArray(a, 10000, 10100);
	}

}
