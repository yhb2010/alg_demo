package com.demo.alg.chapter8.bucket;

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
		BucketSort.bucketSort(a, 1000);

		System.out.println("After heap sort:");
		// ArrayUtils.printArray(a);
		long t2 = System.currentTimeMillis();
		System.out.println("time=" + (t2 - t1));
		ArrayUtils.printArray(a, 99000, 99999);
	}

}
