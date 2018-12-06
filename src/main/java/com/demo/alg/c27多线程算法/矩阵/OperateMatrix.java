package com.demo.alg.c27多线程算法.矩阵;

public class OperateMatrix {

	int[][] matrix1 = null; // 第一个矩阵
	int[][] matrix2 = null; // 第二个矩阵
	int[][] result = null; // 存放矩阵相乘结果

	public OperateMatrix(int[][] m1, int[][] m2, int[][] result) {
		this.matrix1 = m1;
		this.matrix2 = m2;
		this.result = result;
	}
	
	// 第一个矩阵的行乘以第二个矩阵的列，得到新矩阵的行
	public void operate(int row) {
		for (int i = 0; i < matrix1[0].length; i++) {
			int sum = 0; // 存储第一个矩阵的行和 第二个矩阵的列的计算结果
			for (int j = 0; j < matrix2.length; j++) {
				sum += matrix1[row][j] * matrix2[j][i]; // 第一个矩阵的当前行乘以第二个矩阵
			}
			result[row][i] = sum; // 保存结果
		}
	}

	// 返回矩阵相乘的结果
	public int[][] getResult() {
		return this.result;
	}

}
