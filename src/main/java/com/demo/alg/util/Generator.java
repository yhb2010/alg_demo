package com.demo.alg.util;

/**
 * 泛型接口
 * 
 * @author Administrator
 * 
 * @param <T>
 */
public interface Generator<T> {

	T next();

	T next(int k);

}
