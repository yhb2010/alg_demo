package com.demo.alg.chapter2.sort.dis;

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
		MergeCollection mc = new MergeCollection();
		long t1 = System.currentTimeMillis();
		mc.mergeSort(a, 0, a.length - 1);
		long t2 = System.currentTimeMillis();
		System.out.println("time=" + (t2 - t1));
		for (int i = 10000; i < 10100; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
