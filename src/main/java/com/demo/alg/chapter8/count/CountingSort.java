package com.demo.alg.chapter8.count;

/**
 * 计数排序是一个类似于桶排序的排序算法，其优势是对已知数量范围的数组进行排序。它创建一个长度为这个数据范围的数组C，
 * C中每个元素记录要排序数组中对应记录的出现个数。这个算法于1954年由 Harold H. Seward 提出。
 * 
 * 下面以示例来说明这个算法
 * 
 * 假设要排序的数组为 A = {1,0,3,1,0,1,1}
 * 
 * 这里最大值为3，最小值为0，那么我们创建一个数组C，长度为4.
 * 
 * 然后一趟扫描数组A，得到A中各个元素的总数，并保持到数组C的对应单元中。
 * 
 * 比如0 的出现次数为2次，则 C[0] = 2;1 的出现次数为4次，则C[1] = 4。
 * 
 * 由于C 是以A的元素为下标的，所以这样一做，A中的元素在C中自然就成为有序的了，这里我们可以知道 顺序为 0,1,3 (2 的计数为0)
 * 
 * 然后我们把这个在C中的记录按每个元素的计数展开到输出数组B中，排序就完成了。
 * 
 * @author Administrator
 *
 */
public class CountingSort {

	public static void countsort(int[] input, int[] output, int k) {
		// input为输入数组，output为输出数组，k表示有所输入数字都介于0到k之间
		int[] c = new int[k];// 临时存储区
		int len = c.length;
		// 初始化
		for (int i = 0; i < len; i++) {
			c[i] = 0;
		}
		// 检查每个输入元素，如果一个输入元素的值为input[i],那么c[input[i]]的值加1，此操作完成后，c[i]中存放了值为i的元素的个数
		for (int i = 0; i < input.length; i++) {
			c[input[i]]++;
		}
		// 通过在c中记录计数和，c[i]中存放的是小于等于i元素的数字个数
		for (int i = 1; i < len; i++) {
			c[i] = c[i] + c[i - 1];
		}
		// 把输入数组中的元素放在输出数组中对应的位置上
		for (int i = input.length - 1; i >= 0; i--) {// 从后往前遍历
			output[c[input[i]] - 1] = input[i];
			c[input[i]]--;// 该操作使得下一个值为input[i]的元素直接进入输出数组中input[i]的前一个位置
		}
	}

}
