package com.demo.alg.chapter8.bucket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 桶排序 (Bucket sort)或所谓的箱排序，是一个排序算法，工作的原理是将阵列分到有限数量的桶子里。每个桶子再个别排序（
 * 有可能再使用别的排序算法或是以递回方式继续使用桶排序进行排序
 * ）。桶排序是鸽巢排序的一种归纳结果。当要被排序的阵列内的数值是均匀分配的时候，桶排序使用线性时间（Θ（n））。但桶排序并不是 比较排序，他不受到 O(n
 * log n) 下限的影响。
 * 例如要对大小为[1..1000]范围内的n个整数A[1..n]排序，可以把桶设为大小为10的范围，具体而言，设集合B[1]存储[1.
 * .10]的整数，集合B[2]存储(10..20]的整数，……集合B[i]存储((i-1)*10, i*10]的整数，i =
 * 1,2,..100。总共有100个桶。然后对A[1..n]从头到尾扫描一遍，把每个A[i]放入对应的桶B[j]中。
 * 然后再对这100个桶中每个桶里的数字排序
 * ，这时可用冒泡，选择，乃至快排，一般来说任何排序法都可以。最后依次输出每个桶里面的数字，且每个桶中的数字从小到大输出
 * ，这样就得到所有数字排好序的一个序列了。
 * 假设有n个数字，有m个桶，如果数字是平均分布的，则每个桶里面平均有n/m个数字。如果对每个桶中的数字采用快速排序，
 * 那么整个算法的复杂度是O(n+m*n/m*log(n/m))=O(n+nlogn-nlogm) 从上式看出，当m接近n的时候，桶排序复杂度接近O(n)
 * 当然，以上复杂度的计算是基于输入的n个数字是平均分布这个假设的。这个假设是很强的，实际应用中效果并没有这么好。如果所有的数字都落在同一个桶中，
 * 那就退化成一般的排序了。
 * 
 * @author Administrator
 *
 */
public class BucketSort {

	// bucketEleCount容量
	public static void bucketSort(int array[], int bucketEleCount) {
		int length = array.length;
		int bucketSize = length / bucketEleCount;
		List arrList[] = new ArrayList[bucketSize];
		/*
		 * 每个桶是一个list，存放落在此桶上的元素
		 * 上次的基数排序我采用的是计数排序实现的，其实也可以用下面的方法，有兴趣的读者不妨一试(我认为太复杂) 不过效率估计不高(采用了动态数组)
		 */
		// 划分桶并填元素
		for (int i = 0; i < length; i++) {
			// 0到bucketEleCount放在第1个桶里,编号1；第2个桶放bucketEleCount到2*bucketEleCount
			int temp = array[i] / bucketEleCount;
			if (null == arrList[temp])
				arrList[temp] = new ArrayList();
			arrList[temp].add(array[i]);
		}
		// 对每个桶中的数进行插入排序
		for (int i = 0; i < bucketSize; i++) {
			if (null != arrList[i]) {
				// 此处排序方法不定，不过越快越好，除了三大线性排序外，都没有Collections
				// 和Arrays里的sort好，因为这是调优后的快拍
				// Arrays里也有，在基数排序里用过copyOf和fill方法
				Collections.sort(arrList[i]);
			}

		}
		// 输出类似鸽巢排序
		int count = 0;
		for (int i = 0; i < bucketSize; i++) {
			if (null != arrList[i]) {
				Iterator iter = arrList[i].iterator();
				while (iter.hasNext()) {
					Integer d = (Integer) iter.next();
					array[count] = d;
					count++;
				}
			}
		}
	}

}
