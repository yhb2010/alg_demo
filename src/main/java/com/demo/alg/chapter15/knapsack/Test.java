package com.demo.alg.chapter15.knapsack;

public class Test {

	public static void main(String[] args) {
		int c = 10;
		int w[] = { 0, 2, 2, 6, 5, 4 };// 物品的重量，其中0号位置不使用
		int v[] = { 0, 6, 3, 5, 4, 6 };// 物品对应的待加，0号位置置为空
		int n = 5;// n代表物品的个数

		int[][] m = new int[6][11];
		Knapsack.package0_1(m, w, v, n, c);

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

}
