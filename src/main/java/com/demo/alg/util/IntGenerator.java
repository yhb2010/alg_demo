package com.demo.alg.util;

import java.util.Random;

/**
 * 泛型接口
 * 
 * @author Administrator
 * 
 * @param <T>
 */
public class IntGenerator implements Generator<Integer> {

	private Random rad = new Random(47);
	private int size;

	public IntGenerator(int size) {
		this.size = size;
	}

	@Override
	public Integer next() {
		return rad.nextInt(size);
	}

	@Override
	// 随机生成输入数组，所有元素都介于0到k之间
	public Integer next(int k) {
		return (int) (Math.random() * k);// 数字范围[0,k)
	}

}
