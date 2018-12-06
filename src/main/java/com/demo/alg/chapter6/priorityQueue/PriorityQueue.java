package com.demo.alg.chapter6.priorityQueue;

import com.demo.alg.chapter6.stacksort.StackMax;
import com.demo.alg.util.ArrayUtils;

/**
 * 优先队列，顾名思义，就是一种根据一定优先级存储和取出数据的队列。它可以说是队列和排序的完美结合体，不仅可以存储数据，
 * 还可以将这些数据按照我们设定的规则进行排序。
 * 
 * 在下面例子中用基于数组的堆实现优先队列，即堆中的元素保存在一个数组中。
 * 
 * 堆是一种二叉树，所遵守的唯一规律为：所有的子节点都要大于（小于）父节点。而这个数组元素的保存也是按照一定规律的：如果父结点的位置为n，那么，
 * 其对应的左右子结点的位置分别是2n+1和2n+2。
 * 
 * @author Administrator
 *
 */
public class PriorityQueue {

	private int[] quene = null;
	// 堆大小
	private int heapSize = 0;

	public PriorityQueue(int capacity) {
		quene = new int[capacity];
	}

	/**
	 * 返回当前最大值
	 * 
	 * @return
	 */
	public int maximum() {
		return quene[0];
	}

	/**
	 * 往优先级队列中，插入一个元素，利用INCREASE-Key方法，从堆的最后增加元素。
	 * 
	 * @param value
	 *            待插入元素
	 */
	public void insert(int value) {
		// 注意堆容量和数组索引的错位 1
		quene[heapSize] = Integer.MIN_VALUE;
		heapSize++;
		increaceKey(heapSize, value);
	}

	/**
	 * 增加给定索引位元素的值，并重新构成MaxHeap。 新值必须大于等于原有值。
	 * 
	 * @param index
	 *            索引位
	 * @param newValue
	 *            新值
	 */
	public void increaceKey(int heapIndex, int newValue) {
		if (newValue < quene[heapIndex - 1]) {
			System.err.println("错误：新值小于原有值！");
			return;
		}
		quene[heapIndex - 1] = newValue;
		int parentIndex = heapIndex / 2;
		while (parentIndex > 0 && quene[parentIndex - 1] < newValue) {
			ArrayUtils.exchangeElements(quene, parentIndex - 1, heapIndex - 1);
			heapIndex = parentIndex;
			parentIndex = parentIndex / 2;
		}
	}

	/**
	 * 返回堆顶元素（最大值），并且将堆顶元素移除。
	 * 
	 * @return
	 */
	public int extractMax() {
		if (heapSize < 1) {
			System.err.println("堆中已经没有元素!");
			return -1;
		}
		int max = maximum();
		quene[0] = quene[heapSize - 1];
		heapSize--;
		StackMax.maxHeap(quene, heapSize, 0);
		return max;
	}

}
