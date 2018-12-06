package com.demo.alg.c27多线程算法.矩阵;

import java.util.concurrent.CountDownLatch;

public class TestDemo {
	
	static int[][] a = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
    static int[][] b = new int[][]{{1, 3, 5, 7}, {2, 4, 6, 8}, {11, 13, 15, 17}, {12, 14, 16, 18}};
    static int[][] result = new int[a.length][b[0].length]; // 存放矩阵相乘结果

	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(a.length);
		OperateMatrix om = new OperateMatrix(a, b, result); // 实例化OperateMatrix对象
		// 根据第一个矩阵的行数，启动对应数量的线程
		for (int i = 0; i < a.length; i++) {
			new ThreadOperate(om, i, "计算第一个矩阵的第" + (i) + "行*第二个矩阵的所有列", cdl).start();
		}
		try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
		display(om.getResult()); // 打印结果
	}
	
	public static void display(int[][] c) {
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }

}
