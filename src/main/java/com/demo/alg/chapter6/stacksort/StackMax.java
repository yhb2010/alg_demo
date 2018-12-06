package com.demo.alg.chapter6.stacksort;

import com.demo.alg.util.ArrayUtils;

/**
 * 堆是一种重要的数据结构，为一棵完全二叉树, 底层如果用数组存储数据的话，假设某个元素为序号为i(Java数组从0开始,i为0到n-1),
 * 如果它有左子树，那么左子树的位置是2i
 * +1，如果有右子树，右子树的位置是2i+2，如果有父节点，父节点的位置是(n-1)/2取整。分为最大堆和最小堆，最大堆的任意子树根节点不小于任意子结点
 * ，最小堆的根节点不大于任意子结点。
 * 
 * @author Administrator 假定数组A，长度是n
 */
public class StackMax {

	public static void heapSort(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		// 构造一个最大堆，其中最大元素总在根节点A[0]
		buildMaxHeap(array);

		// 把A[0]和A[n-1]进行交换，此时原来根的孩子节点仍然是最大堆，而新的根节点可能会违背最大堆性质，因此需要调用maxHeap，从而在A[0，n-2]上构造一个新的最大堆
		for (int i = array.length - 1; i >= 1; i--) {
			ArrayUtils.exchangeElements(array, 0, i);

			maxHeap(array, i, 0);
		}
	}

	private static void buildMaxHeap(int[] array) {
		if (array == null || array.length <= 1) {
			return;
		}

		// n/2+1到n的元素都是叶子节点
		int half = array.length / 2;
		for (int i = half; i >= 0; i--) {
			maxHeap(array, array.length, i);
		}
	}

	/**
	 * 用于维持最大堆性质
	 * 堆排序中最重要的算法就是maxHeap，该函数假设一个元素的两个子节点都满足最大堆的性质(左右子树都是最大堆)，只有跟元素可能违反最大堆性质
	 * ，那么把该元素以及左右子节点的最大元素找出来
	 * ，如果该元素已经最大，那么整棵树都是最大堆，程序退出，否则交换跟元素与最大元素的位置，继续调用maxHeap原最大元素所在的子树
	 * 。该算法是分治法的典型应用。
	 * 
	 * @param array
	 *            ：目标数组
	 * @param heapSize
	 *            ：有多少个堆元素存储在该数据中，即0<=heapSize<=n
	 * @param index
	 *            ：数组下标
	 */
	public static void maxHeap(int[] array, int heapSize, int index) {
		int left = index * 2 + 1;
		int right = index * 2 + 2;

		// 最大元素对应的下标
		int largest = index;
		if (left < heapSize && array[left] > array[index]) {
			largest = left;
		}

		if (right < heapSize && array[right] > array[largest]) {
			largest = right;
		}

		if (index != largest) {
			ArrayUtils.exchangeElements(array, index, largest);
			maxHeap(array, heapSize, largest);
		}
	}

}
