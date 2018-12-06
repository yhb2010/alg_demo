package com.demo.alg.util;

public class ArrayUtils {

	public static void printArray(int[] array) {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}
		}
		System.out.println("}");
	}

	public static void printArray(int[] array, int start, int end) {
		System.out.print("{");
		for (int i = start; i <= end; i++) {
			if (end <= array.length - 1) {
				System.out.print(array[i]);
				if (i < end) {
					System.out.print(", ");
				}
			}
		}
		System.out.println("}");
	}

	public static void exchangeElements(int[] array, int index1, int index2) {
		int temp = array[index1];
		array[index1] = array[index2];
		array[index2] = temp;
	}

}
