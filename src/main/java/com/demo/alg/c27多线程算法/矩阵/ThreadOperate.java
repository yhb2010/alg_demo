package com.demo.alg.c27多线程算法.矩阵;

import java.util.concurrent.CountDownLatch;

public class ThreadOperate extends Thread {

	private OperateMatrix om = null; // 定义矩阵操类对象
	private int row; // 当前处理的第几行
	private CountDownLatch cdl;
	
	public ThreadOperate(OperateMatrix om, int row, String name, CountDownLatch cdl) {
		super(name); // 线程名字
		this.row = row;
		this.om = om;
		this.cdl = cdl;
	}

	// 覆写run()方法
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName()); // 打印当前线程的名字
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*
		 * 调用OperateMatrix对象的operate方法，进行矩阵的计算 每次调用只计算一行结果
		 */
		this.om.operate(row);
		cdl.countDown();
	}

}
