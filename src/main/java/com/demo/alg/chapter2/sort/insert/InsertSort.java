package com.demo.alg.chapter2.sort.insert;

import com.demo.alg.util.Generator;
import com.demo.alg.util.IntGenerator;

/**
 * 插入排序法
 * 
 * @author Administrator
 *
 */
public class InsertSort {

	public static int[] sort(int[] a) {
		int key;

		for (int j = 1; j < a.length; j++) {
			key = a[j];
			int i = j - 1;
			while (i >= 0 && a[i] > key) {
				a[i + 1] = a[i];
				i = i - 1;
			}
			a[i + 1] = key;
		}

		return a;
	}

	public static void main(String[] args) {
		int size = 100000;
		int[] a = new int[size];
		Generator<Integer> g = new IntGenerator(size);
		for (int i = 0; i < size; i++) {
			a[i] = g.next();
		}
		long t1 = System.currentTimeMillis();
		InsertSort.sort(a);
		long t2 = System.currentTimeMillis();
		System.out.println("time=" + (t2 - t1));
		for (int i = 10000; i < 10100; i++) {
			System.out.print(a[i] + " ");
		}
	}

}
