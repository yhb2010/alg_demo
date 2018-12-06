package com.demo.alg.chapter4;

/**
 * 分治法求解连续和最大
 * 
 * @author Administrator
 * 
 */
public class MaxSub {

	static int arr[] = { 4, -3, 5, -2, 10, -2, -6, -2, -5 }; // 也可以随机生成

	// 核心代码：递归调用max()
	public static int max(final int[] arr, int leftIndex, int rightIndex,
			String flag) {
		System.out.println(flag + "*****leftIndex--------rightIndex--->:"
				+ leftIndex + "|***************|" + rightIndex);

		if (rightIndex == leftIndex) {
			return arr[rightIndex];
		} else {
			int center = (leftIndex + rightIndex) / 2;// 2分查找中间节点
			int maxLeft = max(arr, leftIndex, center, "左边");// 左边最大的
			System.out.println("左边最大" + maxLeft);
			int maxRight = max(arr, center + 1, rightIndex, "右边");// 右边最大的
			System.out.println("右边最大" + maxRight);
			int maxMid = midmax(arr, leftIndex, center, rightIndex, "中间");
			System.out.println("中间最大" + maxMid);

			System.out.println("结果" + max(maxLeft, maxRight, maxMid));
			return max(maxLeft, maxRight, maxMid);
		}
	}

	// 返回跨中点最大子数组的值
	public static int midmax(int[] arr, int leftIndex, int midIndex,
			int rightIndex, String flag) {
		System.out.println(flag
				+ "*****leftIndex----------midIndex---------rightIndex--->:"
				+ leftIndex + "|*********" + midIndex + "********|"
				+ rightIndex);
		int leftHalfMax = Integer.MIN_VALUE, rightHalfMax = Integer.MIN_VALUE;// 找到的最大和
		int sum = 0;// 所有值的和
		for (int i = midIndex; i >= leftIndex; --i) {
			sum += arr[i];
			if (sum > leftHalfMax) {
				leftHalfMax = sum;
			}
		}
		// System.out.println("左边的leftHalfMax----------->:" + leftHalfMax);
		sum = 0;
		// 从中点到右侧
		for (int i = midIndex + 1; i <= rightIndex; ++i) {
			sum += arr[i];
			if (sum > rightHalfMax) {
				rightHalfMax = sum;
			}
		}
		// System.out.println("右边的rightHalfMax----------->:" + rightHalfMax);
		return leftHalfMax + rightHalfMax;
	}

	// 三者取最大值
	public static int max(int a, int b, int c) {
		return a > b ? (a > c ? a : c) : (b > c ? b : c);
	}

	// 包装函数
	public static int max(final int[] arr) {
		return max(arr, 0, arr.length - 1, "开始");
	}

	public static void main(String args[]) {
		System.out.println(max(arr));
	}

}
