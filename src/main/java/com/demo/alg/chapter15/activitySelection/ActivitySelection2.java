package com.demo.alg.chapter15.activitySelection;

/**
 * 假设有11个活动，需要占用同一个资源(比如说一个会议室)，他们的活动时间按照结束时间递增的顺序， 有一个需要使用每个资源的n个活动组成的集合S=
 * {a1，a2，···，an }，资源每次只能由一个活动使用。每个活动ai都有一个开始时间si和结束时间fi，且 0≤si<fi<∞
 * 。一旦被选择后，活动ai就占据半开时间区间[si,fi
 * )。如果[si,fi]和[sj,fj]互不重叠，则称ai和aj两个活动是兼容的。该问题就是要找出一个由互相兼容的活动组成的最大子集。
 *
 */
/**
 * 定义子问题解空间Sij是S的子集，其中的每个活动都是互相兼容的。即每个活动都是在ai结束之后开始，且在aj开始之前结束。
 * 为了方便讨论和后面的计算，添加两个虚构活动a0和an+1，其中f0=0，sn+1=∞。 结论：当i≥j时，Sij为空集。
 * 如果活动按照结束时间单调递增排序，子问题空间被用来从Sij中选择最大兼容活动子集，其中0≤i＜j≤n+1，所以其他的Sij都是空集。
 * 最优子结构为：假设Sij的最优解Aij包含活动ak，则对Sik的解Aik和Skj的解Akj必定是最优的。
 * 通过一个活动ak将问题分成两个子问题，下面的公式可以计算出Sij的解Aij。
 *
 */
public class ActivitySelection2 {

	static void dynamic_activity_selector(int[] s, int[] f, int c[], int ret[],
			int N) {
		int i, j;

		for (i = 0; i <= N; i++) {
			c[i] = 0;
		}

		for (i = 2; i <= N; i++)
			for (j = 1; j < i; j++)
				if (f[j] <= s[i] && c[i] <= c[j]) {
					c[i] = c[j] + 1;
					ret[i] = j;
				}
	}

	static void trace_route(int ret[], int i, int j) {
		if (i < j) {
			trace_route(ret, i, ret[j]);
			if (ret[j] != 0)
				System.out.print("a" + ret[j] + " ");
		}
	}

	public static void main(String[] args) {
		// int s[] = { -1, 2, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12, Integer.MAX_VALUE
		// };
		// int f[] = { -1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14,
		// Integer.MAX_VALUE };
		int s[] = { -1, 1, 2, 3, 4, Integer.MAX_VALUE };
		int f[] = { -1, 2, 3, 4, 5, Integer.MAX_VALUE };
		int N = s.length - 1;

		int c[] = new int[N + 1];
		int ret[] = new int[N + 1];
		dynamic_activity_selector(s, f, c, ret, N);

		System.out.println("c[i]的值如下所示：");
		for (int i = 0; i <= N; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();
		// 包括第一个和最后一个元素
		System.out.println("最大子集的个数为:" + (c[N]));
		System.out.println("ret[i]的值如下所示：\n");
		for (int i = 0; i <= N; i++) {
			System.out.print(ret[i] + " ");
		}
		System.out.println();

		trace_route(ret, 0, N);
	}

}
